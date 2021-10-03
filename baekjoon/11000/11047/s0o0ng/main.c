#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int n , k;
	scanf("%d %d" , &n , &k);
	
	int money[11] = { 0 };
	int i , j ;
	for(i = 0 ; i < n ; i++)
	{
		scanf("%d" , &money[i]);
	}
	int coin = 0 ;
//	int change = 0;
	for(i = n - 1 ; i > -1 ; i--)
	{
		while(1)
		{
//			printf("money[%d] : %d\n", i , money[i]);
			if(k < money[i])
			{
				break;
			}			
			coin = coin + k / money[i];
			k = k % money[i];
//			printf("coin : %d\n" , coin);
	
		}
	}
	printf("%d", coin);
	
		
	return 0;
}