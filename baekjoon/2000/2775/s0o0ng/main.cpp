#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

int rerere(int k_ , int n_)
{
	if(n_ == 1)
	{
		return 1;
	}
	if(k_ == 0)
	{
		return n_;
	}
	int tmp;
	tmp = rerere(k_ - 1, n_) + rerere(k_, n_ - 1);
	return tmp;
}


int main(int argc, char** argv) {
	
	int k, n, t;
	
	cin >> t;
	
	int i ;
	for(i = 0 ; i < t ;i++)
	{
		cin >> k >> n;
		cout << rerere(k, n) << '\n';
	}
	
	return 0;
}