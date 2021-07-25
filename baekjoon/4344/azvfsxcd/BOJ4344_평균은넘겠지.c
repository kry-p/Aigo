#include <stdio.h>

int main()
{
    int c;
    scanf("%d", &c);
    for (int i = 0; i < c; i++)
    {
        int stu = 0;
        scanf("%d", &stu);

        int sco[stu];
        int sum = 0;
        for (int i = 0; i < stu; i++)
        {
            scanf("%d", &sco[i]);
            sum += sco[i];
        }
        int aver = sum / stu;
        int cnt = 0;
        for (int i = 0; i < stu; i++)
        {
            if (sco[i] > aver)
            {
                cnt += 1;
            }
        }
        double win = (double)cnt / stu * 100;

        printf("%.3f% \n", win);
    }

    return 0;
}