#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    sort(phone_book.begin(), phone_book.end());
    
        for(int k = 0 ; k < phone_book.size() - 1 ; k++)
        {
            if(phone_book[k] == phone_book[k+1].substr(0, phone_book[k].size()))
            {
                return false;
            }
        }
    return answer;
}