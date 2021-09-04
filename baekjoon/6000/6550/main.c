#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	char s[1000100];
	char t[1000100];
	int ch = 0;
	
	int i , j;
	int len_t;
	int len_s;	
	while(~scanf("%s %s", s , t) )
	{	 
		len_s = strlen(s);
		len_t = strlen(t);
	
		int flag = 0;
		int cnt = 0;

		for(j = 0 ; j < len_t  ; j++)
		{
//			printf("s[%d] --> %c ?? ",i , s[i]); 
//			printf("t[%d] --> %c\n\n", j ,t[j]); 
			if(s[i] == t[j])
			{
				i++;
			}
			if(i == len_s )
				flag = 1;
		}

	
		if(flag)
			printf("Yes\n");
		else
			printf("No\n");
			
		memset(s , 0 , 1000100);
		memset(t , 0 , 1000100);
	}

	return 0;
}