#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<vector<int>> jobs) {    // 0-> 작업 요청 시간, 1 -> 작업량
    int answer = 0;
    int startWorkEnd = 0;                   // 시작한 일이 끝난 횟수
    int work = 0;                           // rq에서 일의 진행 정도
    int timeNow = 0;                        // 현재 시간
    int size = jobs.size();                  // 요청될 일의 량
    
    pair<int, int> rq = {0, 0};     //현재 작업하고 있는 요청
    priority_queue <pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    


    while(startWorkEnd != size)
    {
        for(int i = 0 ; i < size ; i++)
        {
            if(jobs[i][0] == timeNow)          // 요청시간에 맞는 작업을 불러옴
                pq.push(make_pair(jobs[i][1], jobs[i][0]));     // 작업량에 따라 정렬을 하기 위해서 0과 1을 바꾸어줌
            
        }
  
        
        if(rq.first == work && rq.first != 0)
        {
            answer += (timeNow - rq.second);     // 현재 시간에서 작업 요청 시간을 뺀다.
            rq = {0, 0};                        // 현재 작업을 리셋
            work = 0;                           // 일한 량도 리셋
            startWorkEnd++;                       // 끝난 일의 량 상승
        }
        
        if(!pq.empty() && rq.first == 0)        // 요청이 아직 남아있고 현재 작업하고 있는게 없다면 작업을 받음
        {
            rq = pq.top();
            pq.pop();
        }
        if(rq.first != 0)       // 작업이 들어오면 시간과 함께 일한 시간도 상승
        {
            timeNow++;
            work++;
        }
        else                    // 시간은 계속 상승
            timeNow++;
        
    }
    answer /= size;
    return answer;
}