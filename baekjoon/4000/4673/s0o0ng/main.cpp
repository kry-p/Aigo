#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int rerere(int n)
{
	int tmp = n;
	while(n != 0)
	{
		tmp = tmp + (n % 10);
		n = n / 10;
	}
	return tmp;
}


int main(int argc, char** argv) {
	int num[10001] = {0,};
	
	int i;
	for(i = 1 ; i < 10001 ; i++)
	{
		int nself;
		
		nself = rerere(i);
		if(nself < 10001)
		{
			num[nself] = 1;
		}
	}
	
	for(i = 1; i<10001;i++)
	{
		if(!num[i])
		{
			cout << i << '\n';
		}
	}
	
	return 0;
}



