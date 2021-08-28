#include <stdio.h>

int main()
{
	
	int n,m;
	scanf("%d %d",&n,&m);
	int a, b;
	int flag[201][201] = {0} ;
	int i , j , k;
	int total = 0;
	
	for(i = 1 ; i <= m ; ++i)
	{
		scanf("%d %d",&a,&b);
		flag[a][b] = 1;
		flag[b][a] = 1;
	}
	
	for(i = 1 ; i <= n ; ++i)
	{
	//	printf("i : [%d] ",i);
		for(j = i + 1 ; j <= n ; ++j)
		{
	//		printf("j : [%d] ",j);
			if( flag[i][j] ) 
			{
	//			printf("stop\n"); 
				continue;
			}
			for(k = j +1 ; k <= n ; ++k)
			{
	//			printf("k : [%d] \n",k);
				if( flag[i][k] || flag[j][k]) 
				{
	//				printf("stop\n"); 
					continue;
				}
				++total;
	//			printf("t : [%d] ",total);
				
			}
		}
	}
	printf("%d",total);
	
	return 0;
}



