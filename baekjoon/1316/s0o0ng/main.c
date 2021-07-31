#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
   
   int num;
   scanf("%d",&num);
   
   int len, diff_c ,gd_c ,n_ans = 0;
  
   int f;
   int i,j,k;
   
   //int *p = malloc( sizeof(int*) * num);
   
   
   for(i = 0 ; i < num ; i++)
   {
      char word[101] ;
      char gd[101] ;
      diff_c = 0;
      len = 0;
      
   
      scanf("%s",word);
      len = strlen(word);
    
      for(j = 0 ; j < len ; j++)
      {
         if (word[j] != word[j+1] )
         {
            
            gd[diff_c] = word[j];
            diff_c++;
         }
      }
      for(j = 0 ; j < diff_c ; j++)
      {
         f = 0;
         
            for(k = j + 1 ; k < diff_c   ; k++ )
            {
                  if(gd[j] == gd[k])
                  {
                     n_ans++;
                     f = 1;
                     break;
                  } 
            }
            if(f == 1)
            {
               break;
            }
      }
   }
   printf("%d", num - n_ans);
   return 0;
}