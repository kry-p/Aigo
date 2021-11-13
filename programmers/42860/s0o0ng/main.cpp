#include <string>
 
using namespace std;
 
int solution(string name) {
    int answer = 0, i = 0;
    string temp(name.length(), 'A'); // 주어진 문장과 같은 길이의 AAA 문장을 생성
    while (true) {
        temp[i] = name[i];           // 변경할 문장을 반영
        
        if(name[i] - 'A' > 'Z' + 1 - name[i]) // 문자를 'A'에서 빼가냐 'Z'에서 줄여가냐 중 빠른 쪽을 선택
            answer += 'Z' + 1 - name[i];
        else
            answer += name[i] - 'A';
        
        if (temp == name)    break;         // 변경된 문장이 같으면 탈출
        
        for (int move = 1; move < name.length(); move++) // 좌우 방향 선택
        {
            if (name[(i + move) % name.length()] != temp[(i + move) % name.length()]) {
                i = (i + move) % name.length();
                answer += move;
                break;      // 오른쪽이 빠르면 
        }
            else if (name[(i + name.length() - move) % name.length()] != temp[(i + name.length() - move) % name.length()]) {
                i = (i + name.length() - move) % name.length();
                answer += move;
                break;      // 왼쪽이 빠르면
            }
        }
    }
    return answer;
}