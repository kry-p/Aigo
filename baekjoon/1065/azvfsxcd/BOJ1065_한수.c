#include <stdio.h>

int main()
{
    int N;
    scanf("%d", &N);

    if (N < 100)
        printf("%d", N);
    else
    {
        int i;
        int cnt;
        int a100, a10, a; //A는 100의자리 B는 10의자리 C는 1의자리
        cnt = 99;
        for (i = 100; i <= N; i++)
        {
            a100 = i / 100;
            a10 = i / 10 % 10;
            a = i % 10;

            if ((a - a10) == (a10 - a100))
                cnt++;
        }
        printf("%d", cnt);
    }
}
