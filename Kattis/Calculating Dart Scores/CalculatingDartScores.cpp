#include <iostream>

using namespace std;

void print_result(int x, int y, int z)
{
    if((x % 3) == 0 && (x / 3) > 0)
        cout << "triple " << x / 3 << endl;
    else if ((x % 2) == 0 && (x / 2) > 0)
        cout << "double " << x / 2 << endl;
    else if(x > 0)
        cout << "single " << x << endl;

    if((y % 3) == 0 && (y / 3) > 0)
        cout << "triple " << y / 3 << endl;
    else if ((y % 2) == 0 && (y / 2) > 0)
        cout << "double " << y / 2 << endl;
    else if(y > 0)
        cout << "single " << y << endl;

    if((z % 3) == 0 && (z / 3) > 0)
        cout << "triple " << z / 3 << endl;
    else if ((z % 2) == 0 && (z / 2) > 0)
        cout << "double " << z / 2 << endl;
    else if(z > 0)
        cout << "single " << z << endl;

}

int main()
{
    int n;
    cin >> n;
    int x, y, z;
    bool possible = false;
    for(x = 0; x <= 60; x++)
    {
        if(x % 3 != 0 && (x % 2 != 0 || (x % 2 == 0 && x / 2 > 20)) && x > 20)
            continue;

        for(y = 0; y <= 60; y++)
        {
            if(y % 3 != 0 && (y % 2 != 0 || (y % 2 == 0 && y / 2 > 20)) && y > 20)
                continue;

            for(z = 0; z <= 60; z++)
            {
                if(z % 3 != 0 && (z % 2 != 0 || (z % 2 == 0 && z / 2 > 20)) && z > 20)
                    continue;

                if((x + y + z) == n)
                {
                    print_result(x, y, z);
                    possible = true;
                    break;
                }
            }
            if(possible)
                break;
        }
        if(possible)
            break;
    }
    if(!possible)
        cout << "impossible" << endl;
    return 0;
}
