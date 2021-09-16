#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char* argv[]) {

	int num ,ten , i ,j;
	scanf("%d", &num);

	int arr_ss[] = {2, 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,14,13,12,11,10,9,8,7,6,5,4,3};

	for (i = 0; i < num; ++i)
	{
		scanf("%d", &ten);
		ten = ten % 28;
		ten = arr_ss[ten];

		for (j = 3; j >= 0; --j)
		{
			int tmp = 0;
			tmp = ten & (0x01 << j);
			if (tmp)
				fputs("딸기", stdout);
			else
				fputs("V", stdout);
		}
		putchar('\n');
	
	}
	return 0;
}