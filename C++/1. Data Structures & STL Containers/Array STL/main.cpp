#include <iostream>
#include <array>
#include <algorithm>

using namespace std;

void updateArray(array<int,6> &arr, int i, int val ) {
    arr[i] = val;
}
int main() {
    array<int,6> arr = {1,2,3,6,7,8};
    arr[0] = 10;

    updateArray(arr, 0, 100);

    sort(arr.begin(), arr.end());

    for(int i = 0; i < arr.size(); i++) {
        cout << arr[i] << " ";
    }
    return 0;
}
