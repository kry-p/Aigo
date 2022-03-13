#include <iostream>
#include <map>
#include <string>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;
int test, num;

int main(int argc, char** argv) {
	
	cin >> test;
	while (test--) {

		map<string, int> m;
		cin >> num;
		while (num--) {
			string clothes, kind;
			cin >> clothes >> kind;
			m[kind]++;
		}

		int res = 1;
		map<string, int>::iterator iter;
		for (iter = m.begin(); iter != m.end(); iter++)
			res *= (iter->second + 1);
		cout << res - 1 << "\n";
	}
	
	return 0;
}
