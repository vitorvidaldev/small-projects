// logChopping.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

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
		int nLogs;
		cin >> nLogs;

		int choppingTimes = 0;
		for (int i = 0; i < nLogs; i++)
		{
			int in;
			cin >> in;

			choppingTimes += in;
		}

		if ((choppingTimes - nLogs) % 2 != 0)
		{
			cout << "errorgorn" << endl;
		}
		else
		{
			cout << "maomao90" << endl;
		}
	}

	return 0;
}