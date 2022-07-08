#include <iostream>
#include <vector>
#include <map>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

map<string, int> m=
{
{"####.##.##.####",0}, 
{"###..#####..###", 2}, 
{"###..####..####", 3}, 
{"#.##.####..#..#", 4}, 
{"####..###..####", 5}, 
{"####..####.####", 6}, 
{"###..#..#..#..#", 7}, 
{"####.#####.####", 8}, 
{"####.####..####", 9}
};
int main(int argc, char** argv) {
	int n;
	string sig;
	cin >> n >> sig;
	
	int endd = n/5;
	
	int i, j;
	vector<string> tmp;
	
	for(i = 0 ; i < n ; i = i + endd)
	{
		tmp.push_back(sig.substr(i, endd));
	}
	
	

	for(i = 0 ; i < endd ; i++)
	{
		if(tmp[0][i] == '#')
		{
			if( i == endd - 1 || (tmp[0][i+1] == '.' && tmp[3][i] == '#'))
			{
				cout << 1 << "";
				continue;
			}
			
			string num = "";
			for(j = 0 ; j < 5; j++)
			{
				num += tmp[j].substr(i, 3);
			}
			
			if(m.find(num)!= m.end())
			{
				cout << m[num] << "";
				i+=3;
			}
		}
	}
	
	
	
	
	
	
	return 0;
}