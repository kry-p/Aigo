#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    int cnt = 0;
    
    queue<pair<int, int>> q;
    priority_queue <int> pro_q;
    

    for (int i = 0; i < priorities.size(); i++) {
        
        q.push(make_pair(i, priorities[i]));
        pro_q.push(priorities[i]);
    }
    

    while (!q.empty()) {
        int fq = q.front().first;
        int sq = q.front().second;
        q.pop();
       
        if (pro_q.top() == sq) 
        {
            cout << "sq" << sq << endl;
            pro_q.pop();
            cnt++;
            if (fq == location) {
                cout << "cnt" << cnt << endl;
                answer = cnt;
                break;
            }
        }
        else
            q.push(make_pair(fq, sq));
    }
    
    return answer;
}