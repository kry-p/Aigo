#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
void inpu(int* tp , int* min, int* max);

int main(int argc, char *argv[]) {
	
	int min[25] = {0};
	int max[25] = {0};
	int t , cnt;
	
	inpu(&t,min,max);
	
	
	int i , j , k;
	for(i = 1 ; i <= t ; i++)
	{
		int ans = 0;
		cnt = min[i];
		while(cnt <= max[i])
		{

//			printf("\ncnt : %d\n",cnt);
			int len = 0;
			int ten = 0;
			int num_n[10] = {0};
			if(cnt != 0)
				len = (int)log10((double)cnt) + 1;			//자릿수 갯수
			else
				len = 1;
//			printf("len : %d\n",len);
			for(k = 1 ; k <= len  ; k++)
			{
				ten = len - k  ;
				num_n[k] = (int)cnt / (int)pow(10.0, ten) % 10;
//				printf("num_n[%d] : %d ", k , num_n[k]);
				if(num_n[k] == 0)
					ans++;
			}
//			printf("\n");
			cnt++;
		}
		printf("%d\n",ans);	
	}
	
	
	return 0;
}

void inpu(int* t , int* min, int* max)
{
	scanf("%d",t);
	int i;
	for(i = 1 ; i <= *t ; i++)
	{
		scanf("%d %d",&min[i] , &max[i]);
	}	
}




