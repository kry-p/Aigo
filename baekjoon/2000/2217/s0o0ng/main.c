#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int compare(const void* first, const void* second) {
	if(*(int*)first < *(int*)second)
		return -1;
	else if(*(int*)first > *(int*)second)
		return 1;
	else
		return 0;
}

int main(int argc, char *argv[]) {
	
	int n = 0;
	int num[100001] = {0};
	
	scanf("%d",&n);
	
	int i;
	for(i = 0 ; i < n ; i++)
	{
		scanf("%d",&num[i]);
	}
	
	// 내림차순 정리 
	qsort(num, n, sizeof(int), compare);
	
	int max = 0;
	for(i = 0 ; i < n ; i++)
	{
		if(max < num[i] * (n - i))
		{
			max = num[i] * (n - i);
		}
	}
	printf("%d",max);
	return 0;
}