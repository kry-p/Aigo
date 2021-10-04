#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int tree;
	scanf("%d",&tree);
	
	int num[100001] = {0};
	int i , j , k;
	int sum = 0;

	int two_cnt = 0;
	for(i = 0 ; i < tree ; i++)
	{
		scanf("%d",&num[i]);
		sum += num[i];
//		printf("sum1 : %d \n ", sum);
//		if(sum % 2 == 0)
//		{
//			two_cnt++;
//		}
		two_cnt = two_cnt + (num[i] / 2) ;
//		printf("cnt : %d \n" ,two_cnt);
	}
	
	if(sum % 3 == 0)
	{
		sum = sum / 3;
//		printf("sum : %d \n ", sum);
		if(two_cnt >= sum )
		{
			printf("YES");
		}
		else
		{
			printf("NO");
		}
	}
	else
	{
		printf("NO");
	}

	
	return 0;
}