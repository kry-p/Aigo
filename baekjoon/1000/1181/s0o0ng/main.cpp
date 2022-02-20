#include <iostream>
#include <vector>
#include <algorithm>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

bool compare(string a, string b){
  if(a.length() == b.length())
    return a<b;
  return a.length()<b.length();
}

int main(int argc, char** argv) {
	int n;
	
	vector<string> vec;
	cin >> n;
	
	int i;
	for(i = 0; i < n ; i++)
	{
		string str;
		cin >> str;
		if(find(vec.begin(), vec.end(), str ) == vec.end())
		{
			vec.push_back(str);
		}
	}
	
	sort(vec.begin(), vec.end(), compare);
	for(i = 0 ; i < vec.size(); i++)
	{
		cout<< vec[i] << '\n';
	}
	
	return 0;
}