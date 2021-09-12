#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int num = 0;
	scanf("%d",&num);
	
	int x = 0, y = 0;
	
	
	int i,j;
	int sum = 0;
	int diff = 0;
	
	for(i = 1 ; sum < num ; i++)
	{
		sum += i;	
	}
	--i;
	
//	printf("%d\n", i);
//	printf("%d\n", sum);
	
	if(i % 2 == 0)
	{
		x = i;
		y = 1;
		diff = sum - num;
		
		for(j = 0 ; j < diff ; ++j)
		{
			--x;
			++y;
		}
		
		
	}
	else
	{
		x = 1;
		y = i;
		diff = sum - num;
		
		for(j = 0 ; j < diff ; ++j)
		{
			++x;
			--y;
		}
		
	}
	
//	printf("diff : %d\n", diff);
	printf("%d/%d",x , y);
	return 0;
}