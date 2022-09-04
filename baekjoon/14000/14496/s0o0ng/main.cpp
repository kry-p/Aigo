#include <iostream>
#include <queue>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

int lis[1001];
bool arr[1001][1001];
int vis[1001];
int n, m, a, b;


int main(int argc, char** argv) {
	
	cin >> a >> b;
	cin >> n >> m;
	
	int i, j;
	for(i = 0 ; i < m ; i++)
	{
		int tmp_a, tmp_b;
		
		cin >> tmp_a >> tmp_b;
		
		arr[tmp_a][tmp_b] = true;
		arr[tmp_b][tmp_a] = true;
		
	}
	
	queue<int> q;
	q.push(a);
	
	int cnt = 1;
	while(!q.empty())
	{
		int siz = q.size();
		
		int i , j;
		for(i = 0; i < siz ; i++)
		{
			int now = q.front();
			q.pop();
			
			if(vis[now])
			{
				continue;
			}
			vis[now] = cnt;
			for(j = 1 ; j <= n ; j++)
			{
				if(arr[now][j])
				{
					q.push(j);
				}
			}
			
		}
		cnt++;
	}
	if(vis[b] == 0)
		cout << -1 << '\n';
	else
		cout << vis[b] - 1 << '\n';
	
	return 0;
}





