#include "header.h"

string ExcelSheetColumnTitle::convertToTitle(int n) {
	string sb;
	n = n - 1;
	while (n >= 0) {
		int mod = n % 26;
		sb += ((char)('A' + mod));
		n = n / 26 - 1;
	}
	reverse(sb.begin(), sb.end());
	return sb;
}
	
