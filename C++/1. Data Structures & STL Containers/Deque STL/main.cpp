#include <iostream>
#include <deque>
using namespace std;

int main()
{
    deque<int> dq(10);
    for(int i = 0; i < 10; i++){
        dq[i] = i*i;
    }
    dq.push_back(120);
    dq.push_front(-10);
    for(int i : dq){
        cout << i << " ";
    }
    return 0;
}
