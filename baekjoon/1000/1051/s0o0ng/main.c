#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int n , m;
	
	scanf("%d %d", &n ,&m);

	int arr[60][60] = {0};
//	int ans[100000] = {0};
	
	int i , j , k;
	
	for(i = 0 ; i < n ; ++i)
	{
		for(j = 0 ; j < m ; ++j)
		{
			scanf("%1d", &arr[i][j]);

		}
	}
	
	int max = (n <= m) ? n : m ;
//	printf("max : %d \n" , max);
	int ans = 1;
	for(i = 0 ; i < n ; ++i)
	{
		for(j = 0 ; j < m ; ++j)
		{
			for(k = 1 ; k <= max ;++k)
			{
				if( ( (i + k) < n) && ( (j + k) < m) && \
				( arr[i][j] == arr[i][j+k]) && \
				( arr[i][j] == arr[i+k][j]) && \
				(arr[i][j] == arr[i+k][j+k]))
				{
					int sq = (k+1)*(k+1);
					if(ans < sq)
						ans = sq;
				}
			}
		}
	}
	printf("%d",ans);
	
	return 0;
}




/*

int ans_cnt = 0;
	for(i =  1; i <= max ; ++i)
	{
		if( (arr[1][1] == arr[1][1+i]) && (arr[1+i][1] == arr[1+i][1+i]) )
		{
			
			ans[ans_cnt] = (i+1)*(i+1);
			printf("(1) ans[%d] = %d \n" , ans_cnt , ans[ans_cnt]);
			ans_cnt++;
		}
	}
	
	for(i = 1 ; i <= max ; ++i)
	{
//		printf("[2] %d %d %d %d  \n", arr[1][m-i],arr[1][m] ,arr[1+i][m-i],arr[1+i][m]);
		if( (arr[1][m-i] == arr[1][m]) &&  (arr[1+i][m-i] == arr[1+i][m]) )
		{
			printf("[2] %d %d %d %d  \n", arr[1][m-i],arr[1][m] ,arr[1+i][m-i],arr[1+i][m]);
			ans[ans_cnt] = (i+1)*(i+1);
			printf("(2) ans[%d] = %d \n" , ans_cnt , ans[ans_cnt]);
			ans_cnt++;	
		}
	}
	
	for(i = 1 ; i <= max ; ++i)
	{
		if( (arr[n-i][1] == arr[n-i][1+i]) && (arr[n][1] == arr[n][1+i]))
		{
			printf("[3]%d %d %d %d  \n", arr[n-i][1],arr[n-i][1+i],arr[n][1],arr[n][1+i]);
			ans[ans_cnt] = (i+1)*(i+1);
			printf("(3) ans[%d] = %d \n" , ans_cnt , ans[ans_cnt]);
			ans_cnt++;
		}
	}
	
	for(i = 1 ; i <= max ; ++i)
	{
		if((arr[max-i][max-i] == arr[max-i][max]) && (arr[max][max-i] == arr[max][max]))
		{
			printf("[4] %d %d %d %d  \n", arr[max-i][max-i],arr[max-i][max] ,arr[max][max-i] ,arr[max][max]);
			ans[ans_cnt] = (i+1)*(i+1);
			printf("(4) ans[%d] = %d \n" , ans_cnt , ans[ans_cnt]);
			ans_cnt++;
		}
	}
	
	int ans_e = 1;
	for(i = 0 ; i < ans_cnt ; ++i)
	{
	//	printf("%d\n" , ans_e);
		
		if(ans_e < ans[i])
			ans_e = ans[i];
	}

	printf("%d" , ans_e);
*/