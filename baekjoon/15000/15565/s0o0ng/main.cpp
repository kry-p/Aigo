#include <iostream>
#include <algorithm>
#include <vector>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

int n, k;
vector<int> v;
int ans = 1000000;


int main(int argc, char** argv) 
{
	
	int tmp;
	cin >> n >> k;


	int i ;
	for (i = 0; i < n; i++)
	{
		cin >> tmp;
		if (tmp == 1) 
		{
			v.push_back(i);
		}
	}


	if (v.size() < k)
	{
		cout << -1 << '\n';
	}
	else
	{
	
		for (int i = 0; i <= v.size() - k; i++)
		{

			ans = min(ans, ( v[i + k - 1] - v[i] ) + 1);
		}
    
		cout << ans << '\n';
	}
}

