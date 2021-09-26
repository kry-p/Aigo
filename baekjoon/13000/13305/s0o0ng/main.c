#include <stdio.h>

int main()
{
	int ct;
	int len[100000] = { 0 };
	int money[100000] = { 0 };
	scanf("%d", &ct);

	for (int i = 0; i < ct - 1; ++i)
		scanf("%d", &len[i]);
	for (int i = 0; i < ct; ++i)
		scanf("%d", &money[i]);

	int min = money[0];
	int minPoint = 0;
	for (int i = 1; i < ct - 1 ; ++i)
	{
		if (min > money[i])
		{
			min = money[i];
			minPoint = i;
		}
	}
//	printf("min : %d , Point : %d\n", min, minPoint);

	int ans = 0;
	for (int i = 0 ; i < ct ; ++i)
	{
		if (i >= minPoint)
		{
			ans = ans + (money[minPoint] * len[i]);
		}
		else
		{
			ans = ans + (money[i] * len[i]);
		}
	}

	printf("%d", ans);

	return 0;
}