#include <string>
#include <vector>

using namespace std;


bool dfs(vector<vector<int>>& computers, int n) {
    
    if (!computers[n][n]){ //이미 순회한 곳 리턴
        return false;
    }
    computers[n][n] = 0; //순회 체크
    
    
    for (int i = 0; i < computers.size(); i++) { //노드수만큼 반복
        
        if (computers[n][i] == 1){   //연결된 노드가 있다면 재귀
            dfs(computers, i);
        }
    }
    return true;
}
 
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
        //순회하지 않은 노드라면 dfs탐색후 answer증가
        if (computers[i][i] == 1){
            if(dfs(computers, i) == true){
                answer++;
            }
        }
    }
    return answer;
}