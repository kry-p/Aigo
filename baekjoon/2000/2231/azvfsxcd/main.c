#include <stdio.h>
#include <math.h>

int main() {
    int N;
    scanf("%d", &N);
    
    int len = log10(N) +1;
    
    int arr[len];
    int min = 2147483647;
    
    // printf("%d", len);
    for(int i = 1; i <= N; i++){
        for(int j=0;j<len;j++){
            arr[j]=0;
        }
        int j = 0, M = i;
        while(M > 0){
            arr[j]= M % 10;
            M/=10;
            j+=1;
        }
        
      int sum = 0; 
        for(int j =0; j<len; j++) {
            //printf("%d\n",arr[j]);
            sum += arr[j];
        }
        sum += i;
        if(sum==N){
            // printf("%d\n", i);
            if(min>i){
                min = i;
            }
        }
    }
    if(min!=2147483647){
        printf("%d", min);
    } else {
        printf("0");
    }
    
    return 0;
}