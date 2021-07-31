#include <stdio.h>

int main()
{
   int num;
   scanf_s("%d", &num);
   int cnt = 99;

   if (num < 100)
   {
      printf("%d", num);
   }
   else
   {
      int h_num, t_num, o_num;
      int i;
      for (i = 0; i < num - 99; i++)
      {
         int num_c = 100;

         h_num = num_c / 100;
         t_num = num_c / 10 % 10;
         o_num = num_c % 10;

         if ((h_num - t_num) == (t_num - o_num))
         {
            cnt++;
         }

      }

      printf("%d", cnt);
   }


   return 0;
}