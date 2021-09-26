#include <stdio.h>

void sort(int* arr ,int n)
{
	int tmp;

	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n - 1; ++j)
		{
			if (arr[j] > arr[j + 1])
			{
				tmp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = tmp;
			}
		}
	}
}

int main()
{
	int n;
	scanf("%d", &n);

	int time[1001] = { 0 };
	for (int i = 0; i < n; ++i)
	{
		scanf("%d", &time[i]);
	}

	sort(time, n);

	//for (int i = 0; i < n; ++i)
	//{
	//	printf("i : %d time :%d\n",i, time[i]);
	//}

	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < i + 1; j++)
		{
			ans += time[j];
//			printf("ans[%d][%d] : %d\n", i, j, ans);
		}
	}
	
	printf("%d", ans);

	return 0;
}