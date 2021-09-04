#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int t = 0;
	int n , m;
	int a , b;
	
	scanf("%d" , &t);
	int i  , j , k;
	
	for(i = 0 ; i < t ; i++)
	{
		scanf("%d %d", &n , &m);
		for(j = 0 ; j < m ; j++)
		{
			scanf("%d %d",&a,&b);
		}
		printf("%d\n", n - 1);
	}

	
	return 0;
}