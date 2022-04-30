#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int inputSize;
	cin >> inputSize;

	vector<int> elements;

	while (inputSize)
	{
		int input;
		cin >> input;

		elements.push_back(input);

		inputSize--;
	}
	return 0;
}