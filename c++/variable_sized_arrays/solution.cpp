#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n, q;
    cin >> n >> q;
    vector <vector<int>> a;
    for (int i = 0; i < n; ++i) {
        int size;
        cin >> size;
        vector<int> b(size);
        for (int j = 0; j < size; ++j) {
            cin >> b[j];
        }
        a.push_back(b);
    }

    for (int i = 0; i < q; ++i) {
        int first, second;
        cin >> first >> second;

        cout << a[first][second] << endl;
    }
    return 0;
}
