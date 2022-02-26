#include <iostream>
#include <algorithm>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
	
int pay[1001];
int ary[1001];

int main(int argc, char** argv) {

	
	int n;
	
	cin >> n;
	
	int i, j;
	for(i  = 1; i <= n; i++)
	{
		cin >> pay[i];
		ary[i] = pay [i];
	}
	
	for( i = 2 ; i <= n ; i++)
	{
		for( j = 1 ; j <= i ; j++)
		{
			ary[i] = min(ary[i], ary[i - j] + pay[j]);
		}
	}
	
	cout << ary[n] ;
	return 0;
}