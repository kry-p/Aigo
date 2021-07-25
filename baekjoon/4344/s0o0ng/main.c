#include <stdio.h>

int main()
{
	int test_case = 0;		
	
	
	double ans = 0.0;

	scanf("%d",&test_case); 

	for(int i = 0 ; i < test_case ; i++)
	{
	int stu_cnt = 1;		
	double avg = 0.0;
	int sum = 0;

	scanf("%d",&stu_cnt);
	int stu_arr[1001];

		for (int j = 0; j < stu_cnt; j++)
		{
		

			scanf("%d", &stu_arr[j]);
			sum += stu_arr[j];
		}
	int cnt = 0;				
	avg = sum / stu_cnt;
	for (int x = 0; x < stu_cnt; x++)
	{
		if (stu_arr[x] > avg)
		{
			cnt++;
		}
	}
	ans = cnt / (double)stu_cnt;
	printf("%.3f%%\n", ans*100);
	}						


	return 0;
}