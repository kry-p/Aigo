#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>,greater<int>> pq;
    for(int i = 0 ; i < scoville.size(); i++)
    {
        pq.push(scoville[i]);
    }
    while(!pq.empty())
    {
        int small = 0;
        small = pq.top();
        pq.pop();
        if(small >= K)
        {
            break;
        }
        else
        {
            if(pq.empty())
                return -1;
        }
        pq.push(small + (pq.top() * 2));
        pq.pop();
        answer++;
    }
    return answer;
}