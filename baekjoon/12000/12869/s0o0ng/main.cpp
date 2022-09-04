#include <iostream>
#include <cstring>
#include <algorithm>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int n = 0;
int h[5];
int dp[65][65][65];

using namespace std;

int re(int a, int b, int c)
{
	if(a < 0)
	{
		return re(0, b, c);
	}
	if(b < 0)
	{
		return re(a, 0, c);
	}
	if(c < 0)
	{
		return re(a, b, 0);
	}
	
	if(a == 0 && b == 0 && c == 0)
	{
		return 0;
	}
		
	
	int& res = dp[a][b][c];
	
	if(res != -1)
	{
		return res;
	}
	
	res = 99999999;
	res = min(res, re(a - 9, b - 3, c - 1) + 1);
	res = min(res, re(a - 9, b - 1, c - 3) + 1);
	res = min(res, re(a - 3, b - 9, c - 1) + 1);
	res = min(res, re(a - 1, b - 9, c - 3) + 1);
	res = min(res, re(a - 3, b - 1, c - 9) + 1);
	res = min(res, re(a - 1, b - 3, c - 9) + 1);	
	
	return res;
}

int main(int argc, char** argv) {
	cin >> n;
	
	int i, j;
	for(i = 0 ; i < n ; i++)
	{
		cin >> h[i];
	}
	memset(dp, -1, sizeof(dp));
	cout << re(h[0], h[1], h[2]) << '\n';
	return 0;
}