#include <iostream>
#include <map>
#include<algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;
    long long errorList[100004];
    for(int i =0; i < n; i++){
        int currentE;
        cin >> currentE;
        errorList[currentE]++;
    }

    long long firstTurn[100001];
    for(int i = 0; i < 100001; i++){
        firstTurn[i]=errorList[i];
    }
    for(int i = 0; i < n - 1; i++){
        int currentE;
        cin >> currentE;
        firstTurn[currentE]--;
    }

    long long firstCorrect;
    for(int i = 0; i < 100001; i++){
        if(firstTurn[i] > 0){
            firstCorrect = i;
            cout << i << endl;
            break;
        }
    }

    long long secondturn[100001];
    for(int i = 0; i < 100001; i++){
        secondturn[i]=errorList[i];
    }
    secondturn[firstCorrect]--;
    for(int i = 0; i < n - 2; i++){
        int currentE;
        cin >> currentE;
        secondturn[currentE]--;
    }

    for(int i = 0; i < 100001; i++){
        if(secondturn[i] > 0){
            cout << i << endl;
            break;
        }
    }


    return 0;
}
