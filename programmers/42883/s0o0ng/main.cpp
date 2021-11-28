#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string number, int k) {
    string answer = "";
    int first = 0;  // 비교하기 시작하는 값
    int maxp = 0;   // 가장 큰 수가 있는 위치 값
    char maxnum = NULL; // 가장 큰 수의 문자
    for(int i = 0 ; i < number.size() - k ; i++)    // 전체 문자 길이에서 -k 만큼 반복
    {
        
        maxnum = number[first];                     // 처음 비교 시작하는 위치
        maxp = first;                               // 위치값 저장
        
        for(int j = first ; j <= i + k ; j++)       // 비교 시작 위치부터 +k 까지 가장 큰 수 인지 반복문으로 확인
        {
            if(maxnum < number[j]){
                maxnum = number[j];
                maxp = j;
            }
        }
        first = maxp + 1;
        answer += maxnum;
    }
    
    return answer;
}