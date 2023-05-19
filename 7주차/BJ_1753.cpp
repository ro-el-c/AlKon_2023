// 최단경로
#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
#define endl "\n"
using namespace std;

#define INF 1000000 // 무한을 의미 = 가능한 최댓값보다 큰 수 = 20000 * 10 보다 큰 수
#define MAX_NODE 20001

vector<pair<int, int>> vertex[MAX_NODE]; // 정점 정보 - 같은 정점을 향한 간선 여러 개 존재 가능
int dist[MAX_NODE]; // 시작 정점부터 각 정점까지의 최단 거리
priority_queue<pair<int, int>> pq;
// 거리 정보: 거리, 도착 노드

/**
 * 우선순위 큐
 * 큰 값부터 top에 위치
 * ex) 1 6 2 4 push -> (top) 6 4 2 1
 * 
 * -> 거리 저장시 -1을 곱하여, 거리가 가장 작은 값이 top에 위치하도록 한다.
 * ex) 1 6 2 4 push -> (top) -1 -2 -4 -6
 */

void dijkstra(int start) {
    memset(dist, INF, sizeof(dist));

    pq.emplace(0, start);
    dist[start] = 0;

    while(!pq.empty()) {
        auto [cur_dist, cur] = pq.top(); pq.pop();
        cur_dist *= -1;
        if(cur_dist > dist[cur]) continue;

        for(auto& [next, next_cost] : vertex[cur]) { // 연결된 정점 거리 갱신
            int ncost = cur_dist + next_cost;

            if(ncost < dist[next]) {
                dist[next] = ncost;
                pq.emplace(-ncost, next);
            }
        }
    }
}

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);

    int v, e, start;
    cin >> v >> e >> start;

    int i, j, w;
    while(e--) {
        cin >> i >> j >> w;
        vertex[i].push_back(make_pair(j, w));
    }

    dijkstra(start);

    for(int i=1; i<=v; i++) {
        if(dist[i] < INF) cout << dist[i] << endl;
        else cout << "INF" << endl;
    }

    return 0;
}