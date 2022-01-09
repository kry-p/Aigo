#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(int n) {
    string answer = "";
    char ary[3] = {'4', '1', '2'};
    while(n != 0)
    {
            
        if(n % 3 == 0)
        {
            answer = ary[0] + answer;
            n--;
        }
        else if(n % 3 == 1)
        {
            answer = ary[1] + answer;
        }
        else if(n % 3 == 2)
        {
            answer = ary[2] + answer;
        }
        n = n/3;
        
        
    }
    cout << answer << endl;
    return answer;
}