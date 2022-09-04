#include <iostream>
#include <algorithm>
using namespace std;

int n, m, map[105][105], row_max[100], col_max[100];
int dy[4] = { 1, -1, 0, 0 };
int dx[4] = { 0, 0, 1, -1 };

int main() {
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> map[i][j];
		}
	}

	int res = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			for (int d = 0; d < 4; d++) {
				int ty = i + dy[d];
				int tx = j + dx[d];

				int gap = map[i][j] - map[ty][tx];
				if (gap > 0) {
					res += gap;
				}
			}
		}
	}

	res += 2 * n * m;

	cout << res << '\n';

	return 0;
}