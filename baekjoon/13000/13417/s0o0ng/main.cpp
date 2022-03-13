#include <iostream>
#include <deque>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

int main(int argc, char** argv) {
	int test;
	char c[1001];
	cin >> test;
	int i , j;
	for(i = 0 ; i < test ; i++)
	{
		int cnt;
		deque <char> dq;
		deque <char>::iterator i;
		cin >> cnt;
		for(j = 0; j < cnt ; j++)
		{
			cin >> c[j];
			if(j == 0)
			{
				dq.push_back(c[0]);
			}
			else if(c[j]<=(dq.front()))
			{
				dq.push_front(c[j]);
			}
			else
			{
				dq.push_back(c[j]);
			}
		}
		for(i = dq.begin(); i != dq.end();i++)
		{
			cout << *i ;
		}
		cout << "\n";
	}
	
	return 0;
}