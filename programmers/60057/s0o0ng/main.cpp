#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    int len = s.size();
    answer = len;
    
    for(int i = 1; i <= len/2 ; i++){
        string mString = "";
        
        string ss = s.substr(0,i);
        
        int cnt = 1;
        
        for(int k = i ; k <= len; k+=i){
            if( ss == s.substr(k,i)) cnt++;
            else{
                if(cnt == 1){
                    mString += ss;
                }
                else{
                    mString += (to_string(cnt) + ss);
                }
                
                ss = s.substr(k,i);
                
                cnt = 1;
            }
        }
        
        if((len % i) != 0){
            mString += s.substr((len/i)*i);
        }
        if(answer > mString.size()) 
            answer = mString.size();
    }
    
    
    
    
    return answer;
}