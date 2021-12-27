#include <iostream>
#include <stack>
using namespace std;

int main()
{
    int t;
    cin >> t;
    while(t--){
        string s;
        cin >> s;
        stack<string> charStack;
        for(int i = 0; i < s.length();i++){
            if(charStack.empty){
                charStack.push(s.at(i)+"");
            }
        }
    }
    return 0;
}
