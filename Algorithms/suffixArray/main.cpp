#include <bits/stdc++.h>
using namespace std;

int main()
{
    string s;
    cin >> s;

    map<string, int> Map;
    int n = s.length();
    int suffix[n];

    string sub = "";
    for (int i = n - 1; i >= 0; i--)
    {
        sub = s[i] + sub;
        Map[sub] = i;
    }

    int j = 0;
    for (auto x : Map)
    {
        suffix[j] = x.second;
        j++;
    }

    for (int i = 0; i < n; i++)
    {
        cout << suffix[i] << " ";
    }
    cout << endl;
    return 0;
}