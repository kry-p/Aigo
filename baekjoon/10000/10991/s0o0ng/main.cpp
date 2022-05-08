#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	
	int n;
	
	cin >> n;
	
	int i , j ;
	
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n - i; j++) {
			cout << " ";
		}
		
		for (int j = 1; j < i; j++) {
			cout << "* ";
		}
		cout << "*\n";
	}
 
	
	return 0;
}