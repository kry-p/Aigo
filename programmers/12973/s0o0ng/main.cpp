#include <iostream>
#include <stack>
#include<string>

using namespace std;

int solution(string s)
{
    int answer = 0;

    if(s.empty() || s.size() % 2 != 0)
    {
        return answer;
    }
    stack<char> tmp;
    for(size_t nIndex = 0; nIndex < s.size() ; ++nIndex)
    {
        if(tmp.empty() || tmp.top() != s[nIndex])
        {
            tmp.push(s[nIndex]);
        }
        else
        {
            tmp.pop();
        }
    }

    if(tmp.empty())
    {
        ++answer;
    }
    return answer;
}