#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {
	stack<string> st;
	string str, temp;
	int sum, ans = 1;
	cin >> str;
	
	int ns = str.size(); 
	
	// str <-- (([])[])
	for (int i = 0; i < ns ; i++) 
	{
		temp = str.at(i);  // 첫 자리 가져옴. 
		if (temp == "(" || temp == "[") // '(' , '[' 일시 푸쉬. 
		{
			st.push(temp);
		}
		else 
		{
			sum = 1;
			while (!st.empty() && st.top() != "(" && st.top() != "[") 
			{
				sum *= stoi(st.top());
				st.pop();
			}
			if (st.empty() || (temp == ")" && st.top() != "(") || (temp == "]"&& st.top() != "[")) 
			{
				ans = 0;
				break; 
			}	// 짝이 안 맞을 시 오류.
			 
			if (temp == ")")
			{
				sum *= 2;
			}
			else
			{
				sum *= 3;
			}
			st.pop();
			while (!st.empty() && st.top() != "(" && st.top() != "[") 
			{
				sum += stoi(st.top()); 
				st.pop();
			}
			st.push(to_string(sum));
		}
	}
	if (ans == 0 || st.size()!=1 || st.top()=="[" || st.top()=="(" )
	{
		cout << 0;
	}
	else
	{
		cout << st.top();
	}

	return 0;
}