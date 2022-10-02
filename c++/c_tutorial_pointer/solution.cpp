#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
void update(int *a,int *b) {
    int temp = *a;
    temp = *a + *b;
    *b = *a - *b;
    if (*b<0){
        *b = *b*(-1);
    }
    *a = temp;
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int a, b;
    int *pa = &a, *pb = &b;

    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);
    return 0;
}
