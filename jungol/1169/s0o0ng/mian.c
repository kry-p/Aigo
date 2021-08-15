#include <stdio.h>
#include <stdlib.h>

//int cc = 0;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void prin(int* n, int* arr);
void m0(int* np, int* arr, int cnt);
void m1(int* np, int* arr , int cnt);
void m3(int* np, int* arr , int* xrr , int cnt);

int main(int argc, char *argv[]) {
	
	int arr[10] = {1 , 0};
	int xrr[10] = {0};
	
//	printf("%d  %d \n", arr[0], arr[1] );
	int n , m ;
	scanf("%d %d", &n , &m);
	
	if( m < 2)
	{
		m0(&n , arr , 1);	
	}
	else if(m == 2)
	{
		m1(&n , arr , 1);
	}
	else
	{
		m2(&n , arr , xrr , 1);
	}
//	int i ,j ,k;
//	for(i = 1 ; i <= 6 ; i++)
//	{
//		for(j = 1 ; j <= 6 ; j++)
//		{
//			for(k = 1 ; k <= 6 ; k++ )
//			{
//				printf("%d %d %d\n",i , j ,k);
//			}
//		}
//	}
//	
	return 0;
}

void prin(int* np, int* arr)
{
	int i;
	int n = *np;

	for(i = 1 ; i <= n ; i++)
	{
		printf("%d ",arr[i]);
	}
	printf("\n");
	
}

void m0(int* np, int* arr , int cnt)
{
	int n = *np;
	int i;
//	printf("m0\n");
	if(cnt > n )
	{
		prin(&n , arr);
		return;
	}

	for(i = 1 ; i <= 6 ; i++)
	{
		arr[cnt] = i;
		m0(&n ,arr , cnt+1);
	}
	
}

void m1(int* np, int* arr , int cnt)
{
	int n = *np;
	int i;
//	printf("m1\n");
	if(cnt > n)
	{
		prin(&n , arr);
		return;		
	}
	
	for(i = arr[cnt - 1] ; i <= 6 ; i++)
	{
		arr[cnt] = i;
		m1(&n , arr , cnt+1);
	}	
}

void m2(int* np, int* arr , int* xrr , int cnt)
{
	int n = *np;
	int i;
//	printf("m0\n");
	if(cnt > n )
	{
		prin(&n , arr);
		return;
	}

	for(i = 1 ; i <= 6 ; i++)
	{
		if(xrr[i] == 1 ) continue;
		
		arr[cnt] = i;
		
		xrr[i] = 1;
		
		m2(&n ,arr , xrr ,cnt+1);
		
		xrr[i] = 0;
	}
	
}







