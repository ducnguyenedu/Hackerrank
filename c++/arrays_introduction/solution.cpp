#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int array_length;
    cin >> array_length;
    int arr[array_length];
    for (int i = 0; i < array_length; i++) {
        int input;
        cin >> input;
        arr[i] = input;
    }

    for (int i = array_length; i > 0; i--) {
        int output;
        output = arr[i - 1];
        cout << output << ' ';
    }

    return 0;
}
