#include <iostream>

using namespace std;
int heights[20];

void read_heights(int heights[20])
{
    for(int i = 0; i < 20; i++)
    {
        cin >> heights[i];
    }
}

int count_step(int heights[20])
{
    int countStep = 0;
    for(int i = 0; i < 20; i++)
    {
        for(int j = i+1; j <20; j++)
        {
            if(heights[j] < heights[i])
                countStep++;
        }
    }
    return countStep;
}

int main()
{
    int t;
    cin >> t;
    while(t--)
    {
        int n;
        cin >> n;
        read_heights(heights);
        int countStep = count_step(heights);
        cout << n << " " << countStep << endl;
    }
    return 0;
}
