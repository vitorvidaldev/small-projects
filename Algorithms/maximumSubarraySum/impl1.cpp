#include <iostream>
using namespace std;

int main()
{
    int array[] = {1, 2, 3, 4, 5, 6, 7};
    int n = sizeof(array) / sizeof(array[0]);

    int best = 0;
    for (int a = 0; a < n; a++)
    {
        for (int b = a; b < n; b++)
        {
            int sum = 0;
            for (int k = a; k <= b; k++)
            {
                sum += array[k];
            }
            best = max(best, sum);
        }
    }
    cout << best << "\n";
}
