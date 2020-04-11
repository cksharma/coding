#include <bits/stdc++.h>
using namespace std;

struct Song {
    long long length;
    long long beauty;

    bool operator<(const Song& other) const {
        return (1LL * length * beauty < 1LL * other.length * other.beauty);
    }
};

class CPlaylist {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int n, k; cin >> n >> k;
        vector<Song> v(n);
        for (int i = 0; i < n; ++i) {
            int t, b; cin >> t >> b;
            v[i] = Song{t, b};
        }

        sort(v.rbegin(), v.rend());

        Song song = v[0];
        long long withoutHim = song.length * song.beauty;
        long long withHim = 0;
        int steps = 0;

        for (int i = 1; i < v.size(); ++i ) {
            Song& him = v[i];
            withoutHim = 1LL * song.length * song.beauty;
            withHim = 1LL * (song.length + him.length) * min(song.beauty, him.beauty);

            if (withoutHim >= withHim) continue;
            song.length += him.length;
            song.beauty = min(song.beauty, him.beauty);
            ++steps;
        }
        cout << max(withoutHim, withHim);
    }
};
