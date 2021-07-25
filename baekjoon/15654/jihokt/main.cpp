#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int arr[8]; 
int ans[8]; 
int check[8];

void func(int cnt)
{	// 1부터 n까지 자연수 중 m개를 고른 수열

	if (cnt == m)  // m = 2 
	{		//출력하는 부분 이므로 항시 동일함
		for (int i = 0; i < m; i++)
			cout << ans[i] << " ";
		cout << "\n";
		return;
	}

	for (int i = 0; i < n; i++) // n = 4  
	{
		if (check[i] == 0)
		{
			check[i] = true; // 검사

			ans[cnt] = arr[i];

			func(cnt + 1);
			
			
			check[i] = false;  // 완료
		}
	}
}

int main()
{
	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	sort(arr, arr + n); //#include <algorithm>
	func(0);
}