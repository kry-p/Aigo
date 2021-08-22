#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int arr_max(int* _arr , int _n);

int main(int argc, char *argv[]) {
	
	int n , t;
	int arr[1001] = { 0 };

	
	scanf("%d",&t);			// 테스트 케이스 개수 
	
	int i , j;
	
	for(i = 0 ; i < t ; ++i)
	{

		scanf("%d", &n);	// N의 개수 
	
		for(j = 0 ; j < n ; ++j)
		{
			scanf("%d",&arr[j]);	

			
		}
		int max = arr_max(arr, n);
//		printf("**last max : %d\n", max);
		printf("%d\n", max);
	}
	
	return 0;
}

int arr_max(int* _arr , int _n)
{
	int sum;

	int max = _arr[0];
	int i , j , k;
	

		for(i = 0; i < _n ; ++i)
		{
			sum = 0;
			for(j = i ; j < _n  ; j++)
			{
				sum += _arr[j];
				max = max > sum ? max : sum;
//				printf("sum[%d] ~ [%d] : %d \nmax : %d\n\n",i , j , sum , max);
			}
		}


	return max;
}

//0 1 2 3
//
//0
//0 1
//0 1 2
//0 1 2 3

