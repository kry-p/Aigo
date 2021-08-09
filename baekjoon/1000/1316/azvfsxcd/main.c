#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{

    int num;
    scanf("%d", &num);

    int len;
    int diff_c;

    int n_ans = 0;

    int f;
    int i, j;
    for (i = 0; i < num; i++)
    {
        char word[101];
        char gd[101];

        diff_c = 0;
        len = 0;

        scanf("%s", word);
        len = strlen(word);

        //printf("%d %s",len ,word);

        for (j = 0; j < len; j++)
        {
            if (word[j] != word[j + 1])
            {
                //   printf("%c ", word[j]);

                gd[diff_c] = word[j];
                diff_c++;
            }
        }

        for (j = 0; j < diff_c; j++)
        {
            int k;
            f = 0;
            for (k = j + 1; k < diff_c; k++)
            {

                if (gd[j] == gd[k])
                {
                    n_ans++;

                    f = 1;
                    break;
                }
                else
                {
                    continue;
                }
            }

            if (f == 1)
            {
                f = 0;
                break;
            }
        }
    }

    printf("%d", num - n_ans);

    return 0;
}