#include <iostream>
#include <vector>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

vector<int> vec;
int n, res = 0;

void dfs(int n)
{
	int a,b;
	if(vec.size() == 2)
	{
		res = max(n, res);
		return;
	}
	int i ;
	for(i = 1; i < vec.size() - 1; i++)
	{
		a = vec[i];
		b = vec[i+1] * vec[i-1];
		
		
		vec.erase(vec.begin() + i);
		dfs(n + b);
		vec.insert(vec.begin()+i,a);
	}
}

int main(int argc, char** argv) {
	int cnt;
	cin >> cnt;
	int i, j;


	for(i = 0 ; i < cnt ; i++)
	{
		cin >> j;
		vec.push_back(j);
	}
	
	dfs(0);
	cout << res << "\n";

	return 0;
}



