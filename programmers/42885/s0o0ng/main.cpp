#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(),people.end());

    
    for(int i = 0 ; i < people.size() ; i++ )
    {
        int big = people.back();
        people.pop_back();

        
        if(people[i] + big <= limit)
        {
            answer++;
            
        }
        else{
            answer++;
            i--;

        }
        
    }
    return answer;
}