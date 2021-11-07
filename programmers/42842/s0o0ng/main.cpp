#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int sum = brown + yellow;
    for(int i = sum/2 ; i >0 ;i--)
    {
        if(sum%i == 0)
        {
            int x = i;
            int y = sum / i;
            if((x-2)*(y-2) == yellow)
            {
                answer.push_back(x);
                answer.push_back(y);
                break;
            }
        }
    }
    
    
    return answer;
}