#include <string>
#include <vector>
#include <iostream>
#include <math.h>
#include <algorithm>

using namespace std;

bool isPrime(int n)  // 에라토스테네스의 체
{ 
    if (n < 2) return false; 
    
    for (int i = 2; i <= sqrt(n); i++) 
        if (n % i == 0) return false; 
        
    return true; 
}



int solution(string numbers) {
    int answer = 0;
    vector<char> vc;
    vector<int> vi;
    
    for(int i = 0 ; i < numbers.size(); i++)
    {
        vc.push_back(numbers[i]);
        
    }
    sort(vc.begin(),vc.end());
    do
    {
        string temp = "";
        
        for(int i = 0 ; i < vc.size() ; i++)
        {
            temp.push_back(vc[i]);
            vi.push_back(stoi(temp));
            //cout << vi[i] << endl;
        }
        
    }while(next_permutation(vc.begin(),vc.end()));
    
    sort(vi.begin(),vi.end());
    vi.erase(unique(vi.begin(),vi.end()),vi.end());
    
    for(int i = 0 ; i < vi.size(); i++)
    {
        if(isPrime(vi[i]))
            answer++;
    }
    
    return answer;
}
