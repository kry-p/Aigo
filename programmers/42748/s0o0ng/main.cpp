#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    int size = commands.size();
    for(int i = 0 ; i < size ; ++i)
    {
        vector<int> tmp;
        for(int k = commands[i][0] - 1 ; k < commands[i][1] ; ++k)
        {
            tmp.push_back(array[k]);
            cout << "배열" << array[k] << " " ;
        }
        cout << "\n" <<commands[i][2] << endl;
        sort(tmp.begin(), tmp.end());
        answer.push_back(tmp[commands[i][2] - 1]);
    }
    
    return answer;
}