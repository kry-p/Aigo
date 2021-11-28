#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 1;
    sort(routes.begin(),routes.end());
    int out = routes[0][1];
    for(int i = 0 ; i < routes.size(); i++)
    {
        if(out < routes[i][0]){
            answer++;
            out = routes[i][1];
        }
        if(out >= routes[i][1]){
            out = routes[i][1];
        }
    }
    return answer;
}