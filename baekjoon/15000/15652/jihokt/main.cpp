#include <iostream>
using namespace std;

int n, m;
int arr[10];
bool check[10];

void func(int num, int dfs)
{	// 1부터 n까지 자연수 중 m개를 고른 수열
	// 중복 가능 //비내림차순
	
	if (dfs == m)  // m = 2 
	{
		for (int i = 0; i < m; i++)
			cout << arr[i] << " ";
		cout << "\n"; 
		return;
	}

	for (int i = num; i <= n; i++) // n = 4
		//if (!check[i])   중복 상관 없으므로
		{
			check[i] = true; // 검사

			arr[dfs] = i;

			func(i,dfs + 1);

			check[i] = false;  // 완료
		}
}

int main(void)
{
	cin >> n >> m;

	func(1,0);

	return 0;
}