#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

int main(int argc, char** argv) {
	
	string str, sub;
	vector<char> vc;
	
	cin >> str >> sub;
	
	int str_sz, sub_sz;
	
	str_sz = str.size();
	sub_sz = sub.size();
	
	int i, j,k;

	for(i = 0 ; i < str_sz ; i++)
	{

		vc.push_back(str[i]);
		
		if(vc.size() >= sub_sz)
		{
			int cp = 1;
			for(j = 0 ; j < sub_sz ; j++)
			{
				if(vc[vc.size() - sub_sz + j] != sub[j])
				{
					cp = 0;
					break;
				}
			}
			
			if(cp == 1)
			{
				for(j = 0 ; j < sub_sz ; j++)
				{
					vc.pop_back();
				}
			}
		}
	}
	
	if(vc.empty())
	{
		cout << "FRULA";
	}
	else
	{
		for(i = 0 ; i < vc.size(); i++)
		{
			cout << vc[i];
		}
	}

	
	
	return 0;
}