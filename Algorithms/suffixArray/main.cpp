#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void count_sort(vector<int> &stringOrderArray, vector<int> &equivallenceArray)
{
	int size = stringOrderArray.size();
	vector<int> counters(size);
	for (auto element : equivallenceArray)
	{
		counters[element]++;
	}
	vector<int> newStringOrderArray(size);
	vector<int> pos(size);
	pos[0] = 0;
	for (int i = 1; i < size; i++)
	{
		pos[i] = pos[i - 1] + counters[i - 1];
	}

	for (auto element : stringOrderArray)
	{
		int i = equivallenceArray[element];
		newStringOrderArray[pos[i]] = element;
		pos[i]++;
	}
	stringOrderArray = newStringOrderArray;
}

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
			positions[i] = {inputString[i], i};
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

	while ((1 << k) < inputSize)
	{

		for (int i = 0; i < inputSize; i++)
		{
			stringOrderArray[i] = (stringOrderArray[i] - (1 << k) + inputSize) % inputSize;
		}

		count_sort(stringOrderArray, equivallenceArray);

		vector<int> newEquivallenceArray(inputSize);
		newEquivallenceArray[stringOrderArray[0]] = 0;
		for (int i = 1; i < inputSize; i++)
		{
			pair<int, int> prev = {equivallenceArray[stringOrderArray[i - 1]], equivallenceArray[(stringOrderArray[i - 1] + (1 << k)) % inputSize]};
			pair<int, int> now = {equivallenceArray[stringOrderArray[i]], equivallenceArray[(stringOrderArray[i] + (1 << k)) % inputSize]};
			if (now == prev)
			{
				newEquivallenceArray[stringOrderArray[i]] = newEquivallenceArray[stringOrderArray[i - 1]];
			}
			else
			{
				newEquivallenceArray[stringOrderArray[i]] = newEquivallenceArray[stringOrderArray[i - 1]] + 1;
			}
		}
		equivallenceArray = newEquivallenceArray;
		k++;
	}

	for (int i = 0; i < inputSize; i++)
	{
		cout << stringOrderArray[i] << " " << inputString.substr(stringOrderArray[i], inputSize - stringOrderArray[i]) << "\n";
	}
}