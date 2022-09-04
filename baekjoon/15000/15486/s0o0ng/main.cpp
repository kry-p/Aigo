#include <iostream>
#include <algorithm>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int n = 0;
int dp[1500001];
int maxint;
int ans;

pair<int, int> pint[1500001];


int main(int argc, char** argv) {

	int i , j;
	cin >> n;


	for(i = 0 ; i < n ; i++)
	{
		cin >> pint[i].first >> pint[i].second;
		
	}
	
	for(i = 0 ; i <= n ;i++)
	{
		maxint = max(maxint, dp[i]);
		if(i + pint[i].first > n) // 기간 이상일 때. 
		{
			continue;
		}
		dp[i + pint[i].first] = max(dp[i + pint[i].first], maxint + pint[i].second);
		ans = max(ans, dp[i + pint[i].first]);
	}
	
	cout << ans << '\n';
	
	
	return 0;
}

