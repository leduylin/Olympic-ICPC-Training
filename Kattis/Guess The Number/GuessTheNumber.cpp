#include <iostream>
#include <string>

using namespace std;

int main()
{
    int current_number;
    string status;
    int left = 1;
    int right = 1000;
    while(true)
    {
        current_number = (left+right)/2;
        cout << current_number << endl;
        cin >> status;
        if(status == "higher")
        {
            left = current_number + 1;
        }
        else if(status == "lower")
        {
            right = current_number - 1;
        }else{
            break;
        }
    }
    return 0;
}
