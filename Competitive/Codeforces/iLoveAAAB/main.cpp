#include <iostream>

using namespace std;

int main()
{
	int inputSize;
	cin >> inputSize;

	while (inputSize) {

		string input;
		cin >> input;

		bool isPossible = true;

		int aCount = 0, bCount = 0;
		for (int i = 0; i < input.size(); i++)
		{
			if (i != 0 && input[i - 1] == 'B' && input[i] == 'A')
			{
				aCount -= bCount;
				bCount = 0;
			}

			if (input[i] == 'A') aCount++;
			else if (input[i] == 'B') bCount++;

			if (input[0] == 'B' || aCount < bCount || input.size() < 2 || input[input.size() - 1] == 'A')
			{
				isPossible = false;
				break;
			}
		}

		if (isPossible)
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
