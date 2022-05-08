#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int main(int argc, char** argv) {
	
	char in[101][101];
	char out[101][101];
	
	int n, m;
	cin >> n >> m;

	int i , j ;
	for(i = 0 ; i < n ; i++)
	{
		for(j = 0 ; j < m ; j++)
		{
			cin >> in[i][j];
		}
	}
	
	for(i = 0 ; i < n ; i++)
	{
		for(j = 0 ; j < m ; j++)
		{
			if (in[i][j] == '.')    
				in[i][j] = '.';
			else if (in[i][j] == 'O')    
				in[i][j] = 'O';
			else if (in[i][j] == '-')    
				in[i][j] = '|';
			else if (in[i][j] == '|')    
				in[i][j] = '-';
			else if (in[i][j] == '/')    
				in[i][j] = '\\';
			else if (in[i][j] == '\\')    
				in[i][j] = '/';
			else if (in[i][j] == '^')    
				in[i][j] = '<';
			else if (in[i][j] == '<')    
				in[i][j] = 'v';
			else if (in[i][j] == 'v')    
				in[i][j] = '>';
			else if (in[i][j] == '>')    
				in[i][j] = '^';
		}
	}
	
	for(i = 0 ; i < n ; i++)
	{
		for(j = 0; j < m ; j++)
		{
			char c = in[i][j];
			out[m - 1 - j][i] = c;
		}
	}
	
	for(i = 0 ; i < m ; i++)
	{
		for(j = 0; j < n ; j++)
		{
			cout << out[i][j];
		}
		cout << '\n';
	}
	
	
	
	
	return 0;
}