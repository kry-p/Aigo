#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int n;
	scanf("%d", &n);

	if(n%2 == 0){
		printf("CY");
	}else{
		printf("SK");
	}
	
	return 0;
}