/**
 * File: A_Vasya_and_Socks.cpp
 */
#include <bits/stdc++.h>
using namespace std;
#define int long long
#define endl '\n'

void push() {
    int n, m; cin >> n >> m;

    int res = n + (n - 1)/(m - 1);

    cout << res << endl;
}

signed main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    // int t; cin >> t; while (t--)
    push();
    return 0;
}