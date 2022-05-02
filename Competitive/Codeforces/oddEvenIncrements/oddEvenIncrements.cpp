#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

int main()
{
	int inputSize;
	cin >> inputSize;

	while (inputSize--)
	{
		int iterationSize;
		cin >> iterationSize;

		vector<int> input;
		for (int i = 0; i < iterationSize; i++)
		{
			int in;
			cin >> in;
			input.push_back(in);
		}

		bool isPossible = true;
		int evenParity = input[0] % 2;
		for (int i = 0; i < input.size(); i += 2)
		{
			if (input[i] % 2 != evenParity) isPossible = false;
		}

		int oddParity = input[1] % 2;
		for (int i = 1; i < input.size(); i += 2)
		{
			if (input[i] % 2 != oddParity) isPossible = false;
		}

		if (isPossible) cout << "YES" << endl;
		else cout << "NO" << endl;
	}

	return 0;
}