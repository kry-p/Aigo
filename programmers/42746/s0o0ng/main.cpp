#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

bool cmp(const string &x, string &y){
    return x + y > y + x;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> tmp;
    for(int i = 0 ; i < numbers.size() ; i++)
    {
        tmp.push_back(to_string(numbers[i]));
    }
    sort(tmp.begin(),tmp.end(),cmp);
    if(tmp[0] == "0") 
    {
        return "0";
    }
    for(int i = 0 ; i < tmp.size() ; i ++)
    {
        answer += tmp[i];
    }
    return answer;
}