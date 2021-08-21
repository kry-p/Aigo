#include <stdio.h>
#include <math.h>
#include <string.h>

#define LEN 3

typedef struct base
{
   int num[101];
   int s[101];
   int b[101];

} Base;

void input(int* q_p, Base* b1);
void m1(Base* b1, int* num_n, int i);
int m2(Base* b1, int* num_c, int cnt);

int main()
{
   int q;
   Base b1;
   b1.num[0] = 0;
   b1.s[0] = 0;
   b1.b[0] = 0;

   int ck[1000] = { 0 };

   int cnt = 0;

   int num_n[5] = { 0 };
   int num_c[5] = { 0 };
   int s_c, b_c;                     // 스트라이크 , 볼 카운트

   int i, j, k;

   input(&q, &b1);
   memset(ck, 1, 1000 * sizeof(int)); // ck 값을 초기화 

   for (i = 1; i <= q; i++)         //테스크 만큼 반복
   {

      m1(&b1, num_n, i);                  // 입력값을 3단 분할
    
      for (cnt = 123; cnt <= 987; ++cnt)
      {
         if (ck[cnt] == 0) continue;

         s_c = 0;
         b_c = 0;                  //스트라이크 , 볼 초기화

         if (m2(&b1, num_c, cnt))
         {
            continue;
         }               //   cnt에 0이 들어가 있을 때  중복 일때 무시

         for (j = 1; j <= LEN; j++)
         {
            for (k = 1; k <= LEN; k++)
            {
               if (num_n[j] != num_c[k]) continue;

               j == k ? s_c++ : b_c++;
            }
         }                           //스트라이크와 볼 개수 확인
            //테스크에서 입력한 볼과 스트라이크의 개수가 일치하는지 확인
            ck[cnt] = (b1.b[i] == b_c) && (b1.s[i] == s_c);
      }        
            
   }   //   for문

   int ans = 0;
   for (cnt = 123; cnt <= 987; ++cnt)
   {
      if (ck[cnt] == 1)
      {
         ans++;
      }
   }

   printf("%d", ans);

   return 0;
}


int m2(Base* b1, int* num_c, int cnt)   //cnt값 3단 분할 , 같은 수 제거
{
   int j;
   for (j = 1; j <= LEN; j++)
   {
      int ten = 10;
      num_c[j] = cnt / (int)pow((double)ten, (double)(LEN - j)) % 10;

      if (num_c[j] == 0)
      {
         return 1;
      }
      //    printf("num_c[%d] %d\n", j, num_c[j]);
   }
   if ((num_c[1] == num_c[2]) || (num_c[2] == num_c[3]) || (num_c[1] == num_c[3]))
   {
      return 1;
   }

   return 0;
}

void m1(Base* b1, int* num_n, int i)            //입력값 3단 분할
{

   int j;
   for (j = 1; j <= LEN; j++)
   {
      int ten = 10;
      num_n[j] = b1->num[i] / (int)pow((double)ten, (double)(LEN - j)) % 10;
   }
}

void input(int* q, Base* b1)               // 입력값
{
   scanf("%d", q);

   int i;
   for (i = 1; i <= *q; i++)
   {
      scanf("%d %d %d", &b1->num[i], &b1->s[i], &b1->b[i]);
   }
}