#include <string>
#include <vector>

using namespace std;
int answer = 51;


void dfs(string begin, string target, vector<string> words, vector<bool>& check, int cnt = 0) { //시작단어, 목표단어, 리스트, 사용여부, 깊이
    
    for (int i = 0; i < words.size(); i++) { //사용한 단어 체크용
        
        int count =  0 ; //알파벳끼리 일치여부 초기화
       
        for (int j = 0; j < words[i].length(); j++){  //한글자씩 비교하면서 글자가 다를경우 카운트 증가
            if (!check[i] && begin[j] != words[i][j]){
                count++;
            }
        }
        
        if (count == 1) { //카운트가 1이라면(한 글자만 다른경우)
            
            if (target == words[i] && answer > cnt + 1) { //1글자만 다른 단어가 target단어이고 answer가 지금까지 들어온 깊이+1보다 큰경우 answer변경
                answer = cnt + 1;
                return;
            }
            
            check[i] = true; //단어 사용 체크
            dfs(words[i], target, words, check, cnt + 1);
            
            check[i] = false; //함수를 나온경우 단어사용여부 해제
        }
    }
}
 
int solution(string begin, string target, vector<string> words) {
    
    vector<bool> check(words.size(), false); //사용한 단어 체크용 false 초기화
    dfs(begin, target, words, check);
    
    if (answer == 51){ //answer가 51개면 불가 처리
        return 0;
    }
    return answer;
}