#include <iostream>
using namespace std;
// dfs : 깊이 우선 탐색  //스택 사용 // 모든 노드 방문
// //경우 어떤 노드를 방문했었는지 여부를 반드시 검사 해야 한다는 것이다.
// bfs : 너비 우선 탐색  // 큐 사용 (빨름)

const int MAX = 1 + 8;
int n, m;
int dfs_arr[MAX] = { 0,  };
bool dfs_check[MAX] = { 0, };

void search(int num, int dfs) 
{	//1부터 n까지 자연수 중에서 중복없이  m개를 고른 수열
 	if (dfs == m)  // m = 2 
	{
		for (int i = 0; i < m; i++)
			//if()
			cout << dfs_arr[i] << " ";
			cout << "\n"; //   시간초과???
		return;
	}

	for (int i = num; i <= n; i++) // n = 4
		if (!dfs_check[i])
		{
			dfs_check[i] = true; // 검사

			dfs_arr[dfs] = i;
			search(i + 1, dfs + 1);

			dfs_check[i] = false;  // 완료
		}

}

int main(void)
{
	cin >> n >> m;

	search(1,0);
	return 0;
}