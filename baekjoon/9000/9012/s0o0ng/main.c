#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	
	int num = 0;
	scanf("%d", &num);
	
	char rkfh[51];
	
	int cheak = 0;

	
	int i , j;
	for(i = 0 ; i < num ; i++)
	{
		cheak = 0;
		memset(rkfh , '\0' , 51);
		scanf("%s" , rkfh);	
		int len = strlen(rkfh);
		
		
//		printf("len : %d\n", len);
//		printf("rkfh : %s\n", rkfh);
		
		
		if( ( len%2) == 1)
			puts("NO");
		else
		{
		
			for(j = 0 ; j < len ; j++)
			{
				if(rkfh[0] == ')')
				{
					cheak = -1;
					break;
				}
				
				if(rkfh[j] == '(')
					cheak++;
					
				else if(rkfh[j] == ')')
					cheak--;	
//			printf("rkfh %d : %c\n\n",j ,rkfh[] ,cheak);
				if(cheak < 0)
				{
					break;
				}
						
			}		
		if( (cheak < 0) || (cheak > 0))
		{
			puts("NO");
		}
		else if(cheak == 0)
			puts("YES");
		}
//				printf("cnt : %d\n\n", cheak);

	}
	return 0;
}







