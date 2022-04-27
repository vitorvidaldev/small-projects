#include <iostream>

using namespace std;

int main()
{
	int inputSize;
	cin >> inputSize;

	while (inputSize != 0)
	{
		string input;
		cin >> input;

		bool isComposed = true;

		for (int i = 0; i < input.size(); i++)
		{
			if ((i == 0 || input[i] != input[i - 1]) && (i == input.size() - 1 || input[i] != input[i + 1]))
			{
				isComposed = false;
			}

		}

		if (isComposed)
		{
			cout << "YES" << endl;
		}
		else
		{
			cout << "NO" << endl;
		}

		inputSize--;
	}

	return 0;
}