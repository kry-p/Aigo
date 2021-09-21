#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int rn[] = {1 , 5 , 10 , 50};
int arr[10000000] = {0};
int arr_cnt = 0;
int ans = 0;


void dfs(int cnt , int n , int set)
{
	if(cnt == 0)
	{
		if(arr[n] == 0)
		{
			arr[n] = 1;
			ans++;
		}
		return;
	}
	int i;
	for(i = set; i < 4 ; ++i)
	{
		dfs(cnt - 1 , n + rn[i] , i);
	}
}


int main(int argc, char *argv[]) {
	
	int n ;
	scanf("%d",&n);
	

	
	// 경우의 수 4가지 1 , 5 , 10 , 50
	dfs(n , 0 , 0);
	printf("%d", ans );
	
	return 0;
}

//void dfs(int cnt , int n)
//{
////	printf("this start --> cnt : %d , n : %d\n\n", cnt , n);
//	if(n == 0)
//	{
//		int i , false_match = 0;
//		
//		arr[arr_cnt++] = cnt;
////		printf("arr[%d] : %d \n", arr_cnt - 1, arr[arr_cnt - 1]);
//		for(i = 0 ; i < arr_cnt ; ++i)
//		{
//			if(i == (arr_cnt - 1))
//				continue;
//				
//			if(arr[i] == cnt)
//			{
////				printf("match\n");
//				--arr_cnt;
//				false_match = 1;
//				break;
//			}
//		}
//		if(!false_match)
//		{
//			++ans;
////			printf("ans : %d \n", ans);
//		}
//		
//		cnt = 0;
//		return;
//	}
//	int i;
//	for(i = 0 ; i < 4 ; ++i)
//	{
//		int tmp = cnt;
//		cnt += rn[i];
////		printf("cnt : %d \n", cnt);
//		dfs(cnt , n - 1);
//		cnt = tmp;
//	}
//}