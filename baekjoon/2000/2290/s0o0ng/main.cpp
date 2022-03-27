#include <iostream>
#include <stdio.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int s = 0;
string n ="";
int seg[10][7] = {

{1,1,1,0,1,1,1},
{0,0,1,0,0,1,0},
{1,0,1,1,1,0,1},
{1,0,1,1,0,1,1},
{0,1,1,1,0,1,0},
{1,1,0,1,0,1,1},
{1,1,0,1,1,1,1},
{1,0,1,0,0,1,0},
{1,1,1,1,1,1,1},
{1,1,1,1,0,1,1}

};

// --   <-- 0
//|  |  <-- 1 2
// --   <-- 3      *
//|  |  <-- 4 5
// --   <-- 6      *
//
//
void printSeg(char ch, int num){
	
	int och = ch - '0';
	int i;
	if(num % 3 == 0) //0, 3, 6 "-"
	{
		cout << " "; //
		//printf(" ");
		if(seg[och][num] == 1)
		{
			for(i = 0 ; i < s ; i++)
			{
				cout << "-";
				//printf("-");

			}
		}
		else
		{
			for(i = 0 ; i < s ; i++)
			{
				cout << " ";	
				//printf(" ");
			}	
		}
		cout << "  "; // xxxxx 
		//printf(" ");
	}
	
	
	else	// (1, 2), (4, 5) "|"
	{
		if(seg[och][num] == 1)
		{
			cout << "|";
			//printf("|");
		}
		else
		{
			cout << " ";
			//printf(" ");
		}
		
		if(num % 3 == 1) // 0일 때 공백은 길이 s만큼. (1, 4) 
		{
			for(i = 0 ; i < s; i++)
			{
				cout << " ";
				//printf(" ");
			}
		}
		else // (2, 5)일 때. 
		{
			cout << " ";
			//printf(" ");
		}
		
	}
	
}
// s 길이  ,  n 숫자 
// 가로 : s+2 , 세로 2s+3 12 



int main(int argc, char** argv) {

	cin >> s >> n;
	
	int i = 0, j = 0, k = 0;
	int ns = n.size();
	
	//cout << s << " asdasd " << n << " "<< ns <<  "\n";
	
	// 0
	for(i = 0 ; i < ns ; i++) 
	{
		printSeg(n[i], 0);
	}
	cout << "\n";
	//printf("\n");
	
	// 1, 2
	for(i = 0 ; i < s ; i++)
	{
		for(j = 0 ; j < ns ; j++)	// 숫자 개수. 
		{
			for(k = 1 ; k < 3; k++)	//  1 , 2
			{
				printSeg(n[j], k);
			}
			
		}
		cout << "\n";
		//printf("\n");
	}
	
	// 3
	for(i = 0 ; i < ns ; i++)
	{
		printSeg(n[i], 3);
	}
	cout << "\n";
	//printf("\n");
	
	// 4 5
	for(i = 0; i < s ; i++)
	{
		for(j = 0 ; j < ns; j++)
		{
			for(k = 4; k < 6 ; k++)
			{
				printSeg(n[j], k); // xxx
			}
		}
		cout << "\n";
		//printf("\n");
	}
	
	// 6
	for(i = 0 ; i < ns ; i++)
	{
		printSeg(n[i], 6);
	}
	cout << "\n";
	//printf("\n");
	
	
	return 0;
}



