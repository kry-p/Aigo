#include <stdio.h>

int main()
{
    int T;
    scanf("%d", &T);

    for (int tc = 1; tc <= T; tc++)
    {
        int a = 0, b = 0, cnt = 0;
        scanf("%d %d", &a, &b);

        for (int i = a; i <= b; i++)
        {
            if (i == 0)
            {
                cnt++;
            }
            int c = i;
            while (c > 0)
            {
                if (c % 10 == 0)
                {
                    cnt += 1;
                    c /= 10;
                }
                else
                {
                    c /= 10;
                }
            }
        }

        printf("%d\n", cnt);
    }

    return 0;
}