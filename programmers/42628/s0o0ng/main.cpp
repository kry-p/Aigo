#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <string>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    int size = operations.size();
    int cnt = 0;
    priority_queue<int, vector<int>, less<int>> pq_max;
    priority_queue<int, vector<int>, greater<int>> pq_min;
    int num = 0;;
    for(int i = 0 ; i < size ; i++)
    {
        if(operations[i].substr(0,1) == "I")
        {
            num = stoi(operations[i].substr(2));
            pq_max.push(num);
            pq_min.push(num);
            cout << num << endl;
            cnt++;
        }
        else
        {
            if(cnt > 0 )
            {
                if(operations[i].substr(0,3) == "D -")
                {
                    pq_min.pop();
                }
                else
                {
                    pq_max.pop();
                } 
                cnt--;
                if(cnt == 0)
                {
                    while(!pq_min.empty())
                    {
                        pq_min.pop();
                    }
                    while(!pq_max.empty())
                    {
                        pq_max.pop();
                    }
                }
            }
        }
        cout << "cnt " << cnt << endl;
    }
    if(cnt == 0){
        answer.push_back(0);
        answer.push_back(0);
    }
    else{
        answer.push_back(pq_max.top());
        answer.push_back(pq_min.top());
    }
    
    return answer;
}