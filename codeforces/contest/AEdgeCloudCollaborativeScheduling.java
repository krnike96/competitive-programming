import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class AEdgeCloudCollaborativeScheduling {

    static class Request {
        int id;
        int lin;
        int assignedRemote = -1;
        boolean finished = false;

        Request(int id, int lin) {
            this.id = id;
            this.lin = lin;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        // 1. Read System Parameters
        String line = reader.readLine();
        if (line == null || line.trim().equals("END")) return;
        StringTokenizer st = new StringTokenizer(line);

        int K = Integer.parseInt(st.nextToken());
        double S = Double.parseDouble(st.nextToken());
        double latencyInMs = Double.parseDouble(st.nextToken());
        double bandwidthGbps = Double.parseDouble(st.nextToken());
        long bytesPerToken = Long.parseLong(st.nextToken());
        int numLayers = Integer.parseInt(st.nextToken());

        // Scoring parameters (Line 2)
        reader.readLine();

        // 2. Read Task-Time Table
        line = reader.readLine();
        if (line != null && !line.trim().isEmpty()) {
            int N = Integer.parseInt(line.trim());
            for (int i = 0; i < N; i++) {
                reader.readLine(); // Consuming task-time table rows
            }
        }

        // Hardware state tracking
        boolean edgeBusy = false;
        boolean[] cloudBusy = new boolean[K];
        int[] cloudActiveCount = new int[K];

        Map<Integer, Request> requests = new HashMap<>();

        // Explicit O(1) Queues for Pipeline States
        Queue<Request> arrivedQueue = new ArrayDeque<>();
        Queue<Request> pPostQueue = new ArrayDeque<>();
        Queue<Request> dPreQueue = new ArrayDeque<>();
        Queue<Request> dPostQueue = new ArrayDeque<>();

        @SuppressWarnings("unchecked")
        Queue<Request>[] cloudPProcQueue = new Queue[K];
        @SuppressWarnings("unchecked")
        Queue<Request>[] cloudDProcQueue = new Queue[K];

        for (int k = 0; k < K; k++) {
            cloudPProcQueue[k] = new ArrayDeque<>();
            cloudDProcQueue[k] = new ArrayDeque<>();
        }

        // 3. Interactive Event Loop
        while (true) {
            line = reader.readLine();
            if (line == null || line.trim().equals("END")) {
                break;
            }

            double t = Double.parseDouble(line.trim());
            int e = Integer.parseInt(reader.readLine().trim());

            // Process all events in current frame
            for (int i = 0; i < e; i++) {
                String eventLine = reader.readLine().trim();
                String[] tokens = eventLine.split("\\s+");
                String eventType = tokens[0];

                switch (eventType) {
                    case "ARR": {
                        int rid = Integer.parseInt(tokens[1]);
                        int linVal = Integer.parseInt(tokens[2]);
                        Request req = new Request(rid, linVal);
                        requests.put(rid, req);
                        arrivedQueue.add(req);
                        break;
                    }
                    case "TDN": {
                        String server = tokens[1];
                        if (server.equals("E")) {
                            edgeBusy = false;
                        } else if (server.startsWith("C")) {
                            int cloudIdx = Integer.parseInt(server.substring(1));
                            cloudBusy[cloudIdx] = false;
                        }

                        String step = tokens[2];
                        if (step.equals("P")) {
                            String subStep = tokens[3];
                            if (subStep.equals("POST")) {
                                int rid = Integer.parseInt(tokens[5]);
                                Request req = requests.get(rid);
                                if (req != null && !req.finished) {
                                    dPreQueue.add(req);
                                }
                            }
                        } else if (step.equals("D")) {
                            String subStep = tokens[3];
                            if (subStep.equals("POST")) {
                                int m = Integer.parseInt(tokens[5]);
                                for (int k = 0; k < m; k++) {
                                    int rid = Integer.parseInt(tokens[6 + k]);
                                    Request req = requests.get(rid);
                                    if (req != null && !req.finished) {
                                        dPreQueue.add(req);
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case "XDN": {
                        String direction = tokens[1]; // UP or DOWN
                        String phase = tokens[4];     // PRE or DEC
                        int m = Integer.parseInt(tokens[5]);
                        for (int k = 0; k < m; k++) {
                            int rid = Integer.parseInt(tokens[6 + k]);
                            Request req = requests.get(rid);
                            if (req != null && !req.finished) {
                                if (phase.equals("PRE")) {
                                    if (direction.equals("UP")) {
                                        cloudPProcQueue[req.assignedRemote].add(req);
                                    } else if (direction.equals("DOWN")) {
                                        pPostQueue.add(req);
                                    }
                                } else if (phase.equals("DEC")) {
                                    if (direction.equals("UP")) {
                                        cloudDProcQueue[req.assignedRemote].add(req);
                                    } else if (direction.equals("DOWN")) {
                                        dPostQueue.add(req);
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case "FIN": {
                        int rid = Integer.parseInt(tokens[1]);
                        Request req = requests.get(rid);
                        if (req != null && !req.finished) {
                            req.finished = true;
                            if (req.assignedRemote >= 0 && req.assignedRemote < K) {
                                cloudActiveCount[req.assignedRemote]--;
                            }
                        }
                        break;
                    }
                }
            }

            // Decide assignments for this frame
            List<String> assignments = new ArrayList<>();

            // 1. Edge Computer Scheduling Priorities
            if (!edgeBusy) {
                // Priority 1: E D POST (Deliver decoded tokens to edge)
                List<Integer> batch = new ArrayList<>();
                while (!dPostQueue.isEmpty()) {
                    Request req = dPostQueue.poll();
                    if (req != null && !req.finished) batch.add(req.id);
                }
                if (!batch.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("E D POST -1 ").append(batch.size());
                    for (int id : batch) sb.append(" ").append(id);
                    assignments.add(sb.toString());
                    edgeBusy = true;
                }
                // Priority 2: E P POST (Finish prefill post-processing so TDR timer stops)
                else {
                    Request pPostReq = null;
                    while (!pPostQueue.isEmpty()) {
                        Request req = pPostQueue.poll();
                        if (req != null && !req.finished) {
                            pPostReq = req;
                            break;
                        }
                    }
                    if (pPostReq != null) {
                        assignments.add("E P POST " + pPostReq.assignedRemote + " " + pPostReq.id);
                        edgeBusy = true;
                    }
                    // Priority 3: E P PRE (Start new arrivals immediately to avoid TDR delay)
                    else {
                        Request pPreReq = null;
                        while (!arrivedQueue.isEmpty()) {
                            Request req = arrivedQueue.poll();
                            if (req != null && !req.finished) {
                                pPreReq = req;
                                break;
                            }
                        }
                        if (pPreReq != null) {
                            // Assign to cloud with lowest total active workload
                            int bestCloud = 0;
                            int minActive = Integer.MAX_VALUE;
                            for (int k = 0; k < K; k++) {
                                if (cloudActiveCount[k] < minActive) {
                                    minActive = cloudActiveCount[k];
                                    bestCloud = k;
                                }
                            }
                            pPreReq.assignedRemote = bestCloud;
                            cloudActiveCount[bestCloud]++;

                            assignments.add("E P PRE " + bestCloud + " " + pPreReq.id);
                            edgeBusy = true;
                        }
                        // Priority 4: E D PRE (Batch all ready decodes)
                        else {
                            while (!dPreQueue.isEmpty()) {
                                Request req = dPreQueue.poll();
                                if (req != null && !req.finished) batch.add(req.id);
                            }
                            if (!batch.isEmpty()) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("E D PRE -1 ").append(batch.size());
                                for (int id : batch) sb.append(" ").append(id);
                                assignments.add(sb.toString());
                                edgeBusy = true;
                            }
                        }
                    }
                }
            }

            // 2. Cloud Computers Scheduling Priorities
            for (int k = 0; k < K; k++) {
                if (!cloudBusy[k]) {
                    // Priority 1: Cloud Prefill (P_PROC) to prevent TDR starvation
                    Request pProcReq = null;
                    while (!cloudPProcQueue[k].isEmpty()) {
                        Request req = cloudPProcQueue[k].poll();
                        if (req != null && !req.finished) {
                            pProcReq = req;
                            break;
                        }
                    }

                    if (pProcReq != null) {
                        assignments.add("C" + k + " P PROC 0 " + numLayers + " " + k + " " + pProcReq.id);
                        cloudBusy[k] = true;
                    }
                    // Priority 2: Cloud Decode (D_PROC) batched for all waiting decode tasks
                    else {
                        List<Integer> batch = new ArrayList<>();
                        while (!cloudDProcQueue[k].isEmpty()) {
                            Request req = cloudDProcQueue[k].poll();
                            if (req != null && !req.finished) batch.add(req.id);
                        }
                        if (!batch.isEmpty()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("C").append(k).append(" D PROC ").append(k).append(" ").append(batch.size());
                            for (int id : batch) sb.append(" ").append(id);
                            assignments.add(sb.toString());
                            cloudBusy[k] = true;
                        }
                    }
                }
            }

            // 4. Output Response Frame
            writer.println(assignments.size());
            for (String cmd : assignments) {
                writer.println(cmd);
            }
            writer.flush();
        }
    }
}