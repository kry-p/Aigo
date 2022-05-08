#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int n, s;
int num[30];
int cnt = 0;
void dfs(int a, int sum, int c)
{
	int i , j;
	if(c == n)
	{
		return;
	}
	for(i = a ; i < n ; i++)
	{
		int tmp = sum + num[i];
		if(s == tmp )
		{
			cnt++;	
		}
		dfs(i + 1, tmp , c + 1);
	}
	
}


int main(int argc, char** argv) {
	int i , j;
	cin >> n >> s;
	
	for(i = 0 ; i < n ; i++)
	{
		cin >> num[i];
	} 
	
	dfs(0, 0, 0);
	
	cout << cnt;
	
	return 0;
}