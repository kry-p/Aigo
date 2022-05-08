#include<iostream>
#include<string>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;
 
int main() {
    
    int n;
    int i , j;
	cin >> n;
    
    string str[50];
    
    for(i=0; i<n; i++){
        cin >> str[i];
    }
    int len = str[0].length();
    char c;
    
    for(i=0; i<len; i++){
        c = str[0][i];
        for(j=0; j<n; j++){
            if(c != str[j][i]){
                c = '?';
            }
        }    
        cout << c;    
    }
    
}