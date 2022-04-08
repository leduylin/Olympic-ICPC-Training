#include <iostream>

using namespace std;

void updateArray(int arr[], int i, int val){
    arr[i] = val;
}

int main()
{
    int arr[5] = {1,5,4,3,2};
    int n = sizeof(arr)/sizeof(int);

    updateArray(arr, 1, 13);

    for(int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    return 0;
}
