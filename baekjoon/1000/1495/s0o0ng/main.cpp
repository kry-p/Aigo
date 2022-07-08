#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int main(int argc, char** argv) {
	
	int n, s, m;
	int v[100] = {0,};
	
	
	cin >> n >> s >> m;
	
	int i, j , k;
	
	for(i = 1 ; i <= n ; i++)
	{
		cin >> v[i];
	}
	
	int dp[100][1001] ={0,};
	dp[0][s] = 1;
	
	for(i = 1; i <= n ; i++)
	{
		int volOffset = v[i];
		//cout << "vol " << v[i] << "\n";
		for(j = m ; j >= 0 ; j--)
		{
			if(dp[i-1][j] == 1)
			{
			
				if( j - volOffset >= 0)
				{
					dp[i][j - volOffset] = 1;
				}
				
				if( j + volOffset <= m )
				{
					dp[i][j + volOffset] = 1;
				}		
					
			}
		}
	}
	
	int ans = -1;
	for(i = m ; i >= 0 ; i--)
	{
		if(dp[n][i] == 1)
		{
			//cout << "i = " << i << "\n";
			ans = i;
			break;
		}
	}
	
	cout << ans;
	return 0;
}