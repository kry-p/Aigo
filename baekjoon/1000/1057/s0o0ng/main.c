#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int match, n, m, count = 0;
	scanf("%d %d %d",&match,&n,&m);
	
	while(n != m){
		n -= n/2;
		m -= m/2;
		count++;
	}
	printf("%d", count);
	return 0;
}