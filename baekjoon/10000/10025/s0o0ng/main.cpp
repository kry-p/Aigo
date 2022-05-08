#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
//  n 얼음 동이 개수 , x 얼음동이 좌표 , g 얼음 양, k 곰 손범위
int n, x, g, k, ans;
int arr[1000001];

int main() {
    cin >> n >> k;

    for (int i = 0; i < n; i++) {

        cin >> g >> x;
        arr[x] = g;
    }

    k = 2 * k + 1;
    int sum = 0;
    for (int i = 0; i <= 1000001; i++) {
        if (i >=k) {
            sum -= arr[i - k];
        }
        sum += arr[i];
        ans = max(ans, sum);
    }
    cout << ans;
    return 0;
}