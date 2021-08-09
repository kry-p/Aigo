#include <stdio.h>
int main(void)
{
    int num;
    scanf("%d", &num);
    
    for (int i = 1; i <= num; i++)
    {
        for (int k = 1; k < i; k++)
        {
            printf(" ");
        }
        for (int j = num * 2 - 1; j >= i * 2 - 1; j--)
        {
            printf("*");
        }
        printf("\n");
    }
    for (int i = 1; i <= num - 1; i++)
    {
        for (int k = num - 2; k >= i; k--)
        {
            printf(" ");
        }
        for (int j = 1; j <= i*2+1; j++)
        {
            printf("*");
        }
        printf("\n");
    }
}

