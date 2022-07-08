#include <iostream>
#include <queue>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
bool ck[101][101];
char tmp[101][101];	
int n, m;
int d[4][2] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

int w_ans, b_ans;
void bfs(int _m , int _n, char _tmp)
{
	int count = 0;
	ck[_m][_n] = true;
	
	queue<pair<int, int>> q;
	q.push({_m, _n});
	
	while(!q.empty())
	{
		count++;
		pair<int, int> tmpp = q.front();
		q.pop();
		
		int i, j;
		for(i = 0 ; i < 4 ; i++)
		{
			int d_m = tmpp.first + d[i][0], d_n = tmpp.second + d[i][1];
			
			if( (d_m >= 0) &&( d_m < m) && (d_n >= 0 ) && (d_n < n))
			{
				if( (ck[d_m][d_n] == false) && (tmp[d_m][d_n] == _tmp) )
				{
					ck[d_m][d_n] = true;
					q.push({d_m, d_n});
				}
			}
		}
	}
	//cout << " count ==> "<< count << "\n";
	if(_tmp == 'W')
	{
		
		w_ans += count * count;
	}
	else
	{
		b_ans += count * count;
	}
	
	
}

int main(int argc, char** argv) {
	

	
	cin >> n >> m;
	

	
	int i, j;
	for(i = 0 ; i < m ; i++)
	{
		for(j = 0 ; j < n ; j++)
		{
			cin >> tmp[i][j];
		}
	}

	for(i = 0 ; i < m ; i++)
	{
		for(j = 0 ; j < n ; j++)
		{
			if(ck[i][j] == false)
			{
				bfs(i, j, tmp[i][j]);
			}
		}
	}
	
	cout << w_ans << " " << b_ans << "\n";
	
	return 0;
}