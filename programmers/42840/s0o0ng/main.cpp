#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int a[] = {1,2,3,4,5};
    int b[] = {2,1,2,3,2,4,2,5};
    int c[] = {3,3,1,1,2,2,4,4,5,5,};
    int aa = 0;
    int ab = 0;
    int ac = 0;
    cout << "size" << answers.size() << endl;
    for(int i = 0 ; i < answers.size() ; i++)
    {
        if(answers[i] == a[i % 5]) aa++;
        if(answers[i] == b[i % 8]) ab++;
        if(answers[i] == c[i % 10]) ac++;
    }
    cout << aa << " " << ab << " " << ac << endl;
    int ans = max(aa, ab);
    ans = max(ans, ac);
    if(ans == aa) answer.push_back(1);
    if(ans == ab) answer.push_back(2);
    if(ans == ac) answer.push_back(3);
    
    return answer;
}