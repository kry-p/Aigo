#include <iostream>
#include <vector>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

bool check[1001];
vector<int> listNum[1001];

void dfs(int n)
{
	check[n] = true;
	int i ;
	for(i = 0 ; i <listNum[n].size(); i++)
	{
		int m = listNum[n][i];
		if(check[m] == false)
		{
			dfs(m);
		}
	}
}

int main(int argc, char** argv) {
	int n1, n2;
	
	cin >> n1 >> n2;
	
	int cnt = 0;
	
	int i;
	for( i = 0 ; i < n2; i++)
	{
		int x, y;
		cin >> x >> y;
		
		listNum[x].push_back(y);
		listNum[y].push_back(x);
		
	}
	
	for(i = 1 ; i <= n1 ; i++)
	{
		if(!check[i])
		{
			cnt++;
			dfs(i);
		}
	}
	cout << cnt << endl;
	return 0;
}