#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <set>
#include <string>

#define endl "\n"
using namespace std;

string BFS(string start , int count)
{
	// 처음 입력 받은 문자열의 길이를 저장
	int length = start.size();
	// 너비 탐색을 위한 문자열 queue 생성
	queue<string> q;
	q.push(start);

	// 입력받은 k 수 만큼 반복문 실행
	for (int i = 0; i < count; i++)
	{
		// 방문을 체크 하기 위해 set 을 통해 방문 체크
		set<string> visit;
		int qsize = q.size();
		for (int i = 0; i < qsize; i++)
		{
			string start = q.front(); 
			q.pop();
			// set 에 수가 있으면 continue
			if (visit.count(start))
				continue;
			visit.insert(start);

			for (int a = 0; a < length - 1; a++)
			{
				for (int b = a + 1; b < length; b++)
				{
					// 0이 앞으로 오는 경우의 수 방지
					if (a == 0 && start[b] == '0') continue;
					// 자리를 바꾼후 queue 에 넣어 준 뒤 다시 자리를 바꿉니다.
					swap(start[a],start[b]);
					q.push(start);
					swap(start[a], start[b]);
				}
			}
		}
	}
	string answer = "0";
	// k 번 만큼 연산을 통해 만들어 진 수들을 비교하여 가장 큰 수를 출력합니다.
	while (!q.empty())
	{
		answer = max(answer, q.front());
		q.pop();
	}
	// 0으로 시작하는 수가 가장 큰 경우 -1 출력
	if (answer[0] == '0')
		return "-1";
	else
		return answer;
}

void Answer()
{
	string N;
	int K;
	cin >> N >> K;
	cout << BFS(N, K);
}

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	Answer();
}