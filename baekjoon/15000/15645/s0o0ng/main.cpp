#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;



int ary[100001][3];
int dp[100001][3];
int main(int argc, char** argv) {
	

	int cnt ;
	int ansMax = 0, ansMin = 0;
	cin >> cnt;
	
	
	int i;
	for(i = 1 ; i <= cnt ; i++)
	{
		cin >> ary[i][0] >> ary[i][1] >> ary[i][2];
	}
	
	for(i = 0 ; i < 3 ; i++)
	{
		dp[1][i] = ary[1][i];
	}
	
	for(i = 2; i <= cnt ;i++)
	{
		dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]) + ary[i][0];
		dp[i][1] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2])) + ary[i][1];
		dp[i][2] = max(dp[i - 1][1], dp[i - 1][2]) + ary[i][2];
	}
	ansMax = max(dp[cnt][0], max(dp[cnt][1], dp[cnt][2]));
	
	for(i = 0 ; i < 3 ; i++)
	{
		dp[1][i] = ary[1][i];
	}
	
	
	for (int i = 2; i <= cnt; i++)
	{
		dp[i][0] = min(dp[i - 1][0], dp[i - 1][1]) + ary[i][0];
		dp[i][1] = min(dp[i - 1][0], min(dp[i - 1][1], dp[i - 1][2])) + ary[i][1];
		dp[i][2] = min(dp[i - 1][1], dp[i - 1][2]) + ary[i][2];
	}
	
	ansMin = min(dp[cnt][0], min(dp[cnt][1], dp[cnt][2]));
	cout << ansMax << " " << ansMin;
	
	
	return 0;
}



