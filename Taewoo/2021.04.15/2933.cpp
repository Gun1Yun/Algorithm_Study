#include <bits/stdc++.h>
using namespace std;

int dx[] = {-1, 0, 1, 0}; // ��, ��, ��, ��
int dy[] = {0, -1, 0, 1}; 
int r, c, n;
char _map[101][101];
int stick[101];
vector<pair<int, int>> cluster;

void input() {
    cin >> r >> c;
    for(int i = 0; i < r; i++) {
        string s; cin >> s;
        for(int j = 0; j < c; j++) {
            _map[i][j] = s[j];
        }
    }
    cin >> n;
    for(int i = 1; i <= n; i++) {
        int x; cin >> x;
        stick[i] = x;
    }
}

void throw_stick(int flag, int height) {
    if(flag == 1) {
        // �� -> ��
        for(int i = c - 1; i >= 0; i--) {
            if(_map[height][i] == 'x') {
                _map[height][i] = '.';
                break;
            }
        }
    }

    else if(flag == 2) {
        // �� -> ��
        for(int i = 0; i < c; i++) {
            if(_map[height][i] == 'x') {
                _map[height][i] = '.';
                break;
            }
        }
    }
}

void find_cluster() {
    queue<pair<int, int>> q;
    cluster.clear();
    int visited[101][101];
    memset(visited, 0, sizeof(visited));
    
    for(int i = 0; i < c; i++) {
        // �ٴ��� �����̰ų� �湮�ߴ� ���̸� ����
        if(_map[r - 1][i] == '.' || visited[r - 1][i])  continue;
        
        // �湮���� �ʰ� �̳׶��̸�
        visited[r - 1][i] = 1;
        q.push({r -1, i});

        while(!q.empty()) {
            int x, y;
            tie(x, y) = q.front(); q.pop();

            for(int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx < 0 || nx == r || ny < 0 || ny == c) continue;
                if(visited[nx][ny] || _map[nx][ny] == '.') continue;

                visited[nx][ny] = 1;
                q.push({nx, ny});
            }
        }
    }
};

void drop_cluster() {
    // cout << '\n';
    // for(int i = 0; i < r; i++) {
    //     for(int j = 0; j < c; j++) {
    //         cout << _map[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';


    int temp[101][101];
    memset(temp, 0, sizeof(temp));

    int temp_row = n - 1;
    for(int col = 0; col < c; col++) {
        for(int row = r - 1; row >= 0; row--) {
            if(_map[row][col] != 0) {
                temp[temp_row][col] = _map[row][col];
                temp_row--;
            }
        }
    }
    
    for(int row = 0; row < r; row++) {
        for(int col = 0; col < c; col++) {
            _map[row][col] = temp[row][col];
        }
    }   

    // cout << '\n';
    // for(int i = 0; i < r; i++) {
    //     for(int j = 0; j < c; j++) {
    //         cout << _map[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';

}

void pro() {
    for(int i = 1; i <= n; i++) {
        int flag;
        // ¦�� ; �� -> ��
        if(i % 2 == 0) flag = 1;
        // Ȧ�� ; �� -> ��
        else flag = 2;
        int height = r - stick[i];

        throw_stick(flag, height); // ����� ������    
        cout << '\n';
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                cout << _map[i][j] << ' ';
        }
            cout << '\n';
        }
        cout << '\n';    

        // find_cluster(); // Ŭ������ ���صǰ� ã��
        // drop_cluster(); // Ŭ������ ����߷��� �� ��ȭ��Ű��

    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    input();
    pro();
}