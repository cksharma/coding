#include <iostream>
using std::cout;
using std::endl;

double f(int k, int values[][4], int n);

tostring-c++11
int main() {
  int beans[3][4] = {
                         { 1.0,  2.0,  3.0,  4.0},
                         { 5.0,  6.0,  7.0,  8.0},
                         { 9.0, 10.0, 11.0, 12.0}
                       };

  cout << f(0, beans, sizeof beans/sizeof beans[0])<< endl;
  return 0;
}

double f(int k, int array[][4], int size) {
  double sum = 0.0;
  for(int i = 0 ; i < size ; i++)       
    for(int j = 0 ; j < 4 ; j++)        
      sum += array[i][j];
  return sum;
}