#include "header.h"

string ZigZagConversion::convert(string s, int nRows) {
	string sb = "";
	nRows = min(nRows, (int)s.size());
	int k = (nRows - 1) * 2;
	int fir = k;
	int sec = 0;

	if (fir == 0 && sec == 0) {
		sb = s;
	}
	else {
		for (int i = 0; i < nRows; i++) {
			int cnt = i;
			sec = k - fir;
			sb += s[cnt];
			while (cnt < s.length()) {
				cnt += fir;
				if (cnt < s.length() && fir != 0) {
					sb += s[cnt];
				}
				cnt += sec;
				if (cnt < s.length() && sec != 0) {
					sb += s[cnt];
				}
			}
			fir = fir - 2;
		}
	}
	return sb;
}

