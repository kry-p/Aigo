#include <string>
#include <vector>

using namespace std;

int answer = 0;

void dfs(vector<int> n, int t, int sum, int cnt){
    if (cnt == n.size()){ // numbers만큼 cnt한 경우
        if (sum == t) answer++; // 타켓 값이 된 경우 체크하고 리턴
        return;
    }
        dfs(n, t, sum + n[cnt], cnt + 1); // 숫자를 더한 경우
        dfs(n, t, sum - n[cnt], cnt + 1); // 숫자를 뺀 경우
}

int solution(vector<int> numbers, int target) {
    dfs(numbers, target, 0, 0);
    return answer;
}