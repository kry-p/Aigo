include <iostream>

using namespace std;

long long solution(int w,int h) {
    long long answer = 1;
    answer = (long long)w * (long long)h - (w + h);
    int tmp; 
    while(h != 0)
    {
        tmp = w % h;
        w = h;
        h = tmp;
    }
    answer += w;
    return answer;
}