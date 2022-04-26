#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	string inputString;
	cin >> inputString;
	inputString += "$";

	int inputSize = inputString.size();
	vector<int> stringOrderArray(inputSize), equivallenceArray(inputSize);

	{
		vector<pair<int, int>> positions(inputSize);
		for (int i = 0; i < inputSize; i++) 
		{
			positions[i] = { inputString[i], i };
		}

		sort(positions.begin(), positions.end());

		for (int i = 0; i < inputSize; i++)
		{
			stringOrderArray[i] = positions[i].second;
		}

		equivallenceArray[stringOrderArray[0]] = 0;

		for (int i = 1; i < inputSize; i++)
		{
			if (positions[i].first == positions[i - 1].first)
			{
				equivallenceArray[stringOrderArray[i]] = equivallenceArray[stringOrderArray[i - 1]];
			}
			else
			{
				equivallenceArray[stringOrderArray[i]] = equivallenceArray[stringOrderArray[i - 1]] + 1;
			}
		}
	}

	int k = 0;

	while ((1 << k)< inputSize)
	{
		vector<pair<pair<int, int>,int>> positions(inputSize);

		for (int i = 0; i < inputSize; i++)
		{
			positions[i] = { {equivallenceArray[i], equivallenceArray[(i + (1 << k)) % inputSize]}, i};
		}

		sort(positions.begin(), positions.end());

		for (int i = 0; i < inputSize; i++)
		{
			stringOrderArray[i] = positions[i].second;
		}

		equivallenceArray[stringOrderArray[0]] = 0;

		for (int i = 1; i < inputSize; i++)
		{
			if (positions[i].first == positions[i - 1].first)
			{
				equivallenceArray[stringOrderArray[i]] = equivallenceArray[stringOrderArray[i - 1]];
			}
			else
			{
				equivallenceArray[stringOrderArray[i]] = equivallenceArray[stringOrderArray[i - 1]] + 1;
			}
		}
		k++;
	}

	for (int i = 0; i < inputSize; i++)
	{
		cout << stringOrderArray[i] << " " << inputString.substr(stringOrderArray[i], inputSize - stringOrderArray[i]) << "\n";
	}
}