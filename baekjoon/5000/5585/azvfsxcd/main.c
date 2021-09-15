#include <stdio.h>

int main()
{
    int N, a500 = 0, a100 = 0, a50 = 0, a10 = 0, a5 = 0, a1 = 0, cnt = 0;
    scanf("%d", &N);
    N = 1000 - N;
    while (N > 0)
    {
        if (N >= 500)
        {
            cnt += (N / 500);
            N %= 500;
        }
        else if (N >= 100)
        {
            cnt += (N / 100);
            N %= 100;
        }
        else if (N >= 50)
        {
            cnt += (N / 50);
            N %= 50;
        }
        else if (N >= 10)
        {
            cnt += (N / 10);
            N %= 10;
        }
        else if (N >= 5)
        {
            cnt += (N / 5);
            N %= 5;
        }
        else
        {
            cnt += N;
            break;
        }
        //        printf("%d %d\n", N, cnt);
    }

    printf("%d\n", cnt);
    return 0;
}