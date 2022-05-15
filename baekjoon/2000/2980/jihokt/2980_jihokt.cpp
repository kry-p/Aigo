#include <iostream>
#include <vector>
using namespace std;

typedef struct
{
    int D;
    int R;
    int G;
    int iT;
}Signal_Lamp;

int N, L;
vector<Signal_Lamp> V;

bool Traffic_State(int Idx, int T)
{
    if (T % V[Idx].iT <= V[Idx].R) return false;
    return true;
}

void Solution()
{
    cin >> N >> L;
    for (int i = 0; i < N; i++)
    {
        Signal_Lamp S;
        int D, R, G;
        cin >> D >> R >> G;
        S.D = D;
        S.R = R;
        S.G = G;
        S.iT = S.R + S.G;
        V.push_back(S);
    }

    int Distance = 0;
    int Time = 0;
    int Idx = 0;

    while (1)
    {
        if (Distance == L) break;
        if (Idx < V.size())
        {
            if (V[Idx].D == Distance)    // 신호등에 도착하는 시간이면
            {
                if (Traffic_State(Idx, Time) == true)  // 현재 신호등이 초록불
                {
                    Distance++;
                    Time++;
                }
                else  // 빨간불이라면
                {
                    int Tmp = Time % (V[Idx].iT);
                    Time = Time + V[Idx].R - Tmp;
                }
                Idx++;
                continue;
            }
        }
        Distance++;
        Time++;
    }
    cout << Time << endl;
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Solution();

    return 0;
}