#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle) {
	int triSize = triangle.size();
	for (int i = 1; i < triSize; i++) {
		int floorSize = triangle[i].size();
		for (int j = 0; j < floorSize; j++) {
			if (j == 0) { // 왼쪽 끝
				triangle[i][j] += triangle[i - 1][j];
			}
			else if (j == floorSize - 1) { // 오른쪽 끝
				triangle[i][j] += triangle[i - 1][j - 1];
			}
			else {
				triangle[i][j] += max(triangle[i - 1][j - 1], triangle[i - 1][j]);
			}
		}
	}

	int maxNum = 0;
	for (int i = 0; i < triangle[triSize - 1].size(); i++) {
		if (maxNum < triangle[triSize - 1][i]) {
			maxNum = triangle[triSize - 1][i];
		}
	}

	return maxNum;
}