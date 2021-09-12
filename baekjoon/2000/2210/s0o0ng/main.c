#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int arr[10][10];
int dx[] = {0 , 0 , 1 , -1};
int dy[] = {1 , -1 , 0, 0};
int lensix[1000000];
int ans;

void dfs(int y , int x , int first_num , int fin)
{
	int i ;
	
	if(fin == 5)
	{
		if(lensix[first_num] == 0)
		{
			lensix[first_num] = 1;
			++ans;
//			printf("%d\n",first_num);
		}
		return;
	}
	

	for( i = 0 ; i < 4 ; ++i)
	{
		int move_x = dx[i] + x;
		int move_y = dy[i] + y;
		 
//		 printf("%d\n", i);


		if(move_y >= 1 && move_x >= 1 && move_y <= 5 && move_x <= 5)
		{
			dfs(move_y,move_x, first_num * 10 + arr[move_y][move_x],fin+1);
		}
	}
	

	
}


int main(int argc, char *argv[]) {
	
	
	int i , j;

	for(i = 1 ; i <= 5 ; ++i)
	{
		for(j = 1 ; j <= 5 ;++j)
		{
			scanf("%d",&arr[i][j]);
		}
	}

	
	for(i = 1 ; i <=5 ; ++i )
	{
		for(j = 1 ; j <= 5; ++j)
		{

			
			dfs(i , j , arr[i][j], 0);

		}
	}
	
	printf("%d\n", ans);
	return 0;
}