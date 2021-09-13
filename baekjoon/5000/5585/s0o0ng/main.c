#include <stdio.h>
#include <stdlib.h>
#define GOLD 1000

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int money;
	scanf("%d",&money);
	
	int  diff = GOLD - money;
	int cnt_m = 0;
	int i;
//	printf("diff : %d\n", diff);
	while(diff >= 500)
	{

		diff = diff - 500;
		cnt_m++;
	}	
//	printf("cnt_500 : %d\n\n", cnt_m);
	
//	printf("diff : %d\n", diff);
	while(diff >= 100 )
	{
		diff = diff - 100;
		cnt_m++;

	}	
//	printf("cnt_100 : %d\n\n", cnt_m);
	
//	printf("diff : %d\n", diff);
	while(diff >=50 )
	{
		diff = diff - 50;
		cnt_m++;
	}	
//	printf("cnt_50 : %d\n\n", cnt_m);
	
//	printf("diff : %d\n", diff);
	while(diff >= 10)
	{
		diff = diff - 10;
		cnt_m++;
	}
//	printf("cnt_10 : %d\n", cnt_m);
	
//	printf("diff : %d\n", diff);
	while(diff >= 5)
	{
		diff = diff - 5;
		cnt_m++;
	}
//	printf("cnt_5 : %d\n", cnt_m);
	printf("%d\n", cnt_m + diff);
	
	
	return 0;
}