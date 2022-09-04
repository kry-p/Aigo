#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int main(int argc, char** argv) {
	
	int arr[7] = {0,1,0,1,1,1,1};
	
	long long n;
	
	cin >> n;
	
	int tmp = n % 7;
	//cout << "tmp ==>" << tmp << '\n';
	
	
	int ans = arr[tmp];
	//cout << "ans ==>" << ans << '\n';
	
	
	if(ans == 1)
	{
		cout << "SK" << '\n';
	}
	else if(ans == 0)
	{
		cout << "CY" << '\n';
	}
	
	
	return 0;
}