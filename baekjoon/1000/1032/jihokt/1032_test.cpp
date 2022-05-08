#include <iostream>
#include <string>

using namespace std;

int main()
{
	int iN;
	cin >> iN; // 입력받는 개수

	string str[50]; // 문자 저장
	char iResult;

	for (int i = 0; i < iN; i++)
	{
		cin >> str[i];
	}
	
	for (int i = 0; i < str[0].length(); i++)
	{
		for (int j = 1; j < iN; j++)
		{
			if(str[0][i] != str[j][i])
			{
				str[0][i] = '?';
				break;
			}
		}
		cout << str[0][i];
	}
	cout << endl;
	return 0;
}