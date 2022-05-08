#include <iostream>
#include <algorithm>
#include <vector>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

int main(int argc, char** argv) {
	ios_base::sync_with_stdio(0);cin.tie(0);
	
	int n, m;
	vector<int> v;
	cin >> n;
	int i ,j;
	for(i = 0 ; i < n ;i++)
	{
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());
	
	cin >> m;
	for(i = 0; i < m ; i++)
	{
		int tmp;
		cin >> tmp;
		cout << binary_search(v.begin(), v.end(), tmp) << '\n';
	}
	

	return 0;
}