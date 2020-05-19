//============================================================================
// Name        : HelloWorld.cpp
// Author      : Me
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
#include <cstdio>
#include <stack>
#include <array>

using namespace std;

int main()
{
	string test = "";
	test += "Hello World!";

	cout << "Hello..." << endl << "...World" << "Bae" << endl; // prints Hello World!!!
	cout << test << endl;
	cout << test.size() << endl;

	int twelve = 12;

	printf("%d is the number twelve!", twelve);

	int num;

	cout << endl << "Please" << " enter" << " a" << " number: ";
	cin >> num;

	cout << "You entered " << num << endl;

	stack<int> myStack;

	for (int i = 0; i < num; i++)
	{
		myStack.push(i);
	}

	for (int i = 0; i < num; i++)
	{
		int j = myStack.top();
		cout << endl << j << endl;

		myStack.pop();
	}


	return 0;
}
