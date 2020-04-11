#include "../archive/EAlmostEverywhereZero.cpp"

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <cctype>
#include <ctime>

namespace jhelper {

struct Test {
    std::string input;
    std::string output;
    bool active;
    bool has_output;
};

bool check(std::string expected, std::string actual) {
    while(!expected.empty() && isspace(*--expected.end()))
        expected.erase(--expected.end());
    while(!actual.empty() && isspace(*--actual.end()))
        actual.erase(--actual.end());
    return expected == actual;
}

} // namespace jhelper

string trimEndOfLine(string str) {
    int n = str.size();
    if( str[n - 1] == '\n' )
        str = str.substr(0, n - 1);
    return str;
}

int main() {
    std::vector<jhelper::Test> tests = {
        {"100\n1\n", "19\n", true, true},{"25\n2\n", "14\n", true, true},{"314159\n2\n", "937\n", true, true},{"9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999\n3\n", "117879300\n", true, true},
    };
    bool allOK = true;
    int testID = 0;
    std::cout << std::fixed;
    double maxTime = 0.0;
    for(const jhelper::Test& test: tests ) {
        std::cout << "Test #" << ++testID << std::endl;
        std::cout << trimEndOfLine(test.input) << std::endl << std::endl;
        if (test.has_output) {
            std::cout << "Expected output: " << trimEndOfLine(test.output) << std::endl;
        }
        else {
            std::cout << "Expected output: " << "N/A" << std::endl;
        }
        if (test.active) {
            std::stringstream in(test.input);
            std::ostringstream out;
            std::clock_t start = std::clock();
            EAlmostEverywhereZero solver;
            solver.solve(in, out);
            std::clock_t finish = std::clock();
            double currentTime = double(finish - start) / CLOCKS_PER_SEC;
            maxTime = std::max(currentTime, maxTime);
            std::cout << "Actual   output: " << trimEndOfLine(out.str()) << std::endl;
            if (test.has_output) {
                bool result = jhelper::check(test.output, out.str());
                allOK = allOK && result;
                std::cout << "Result: " << (result ? "Correct answer" : "Wrong answer") << std::endl;
            } else {
                std::cout << "Result: OK, but is it right?" << std::endl;
            }
            //std::cout << "Time:" << currentTime << " seconds" << std::endl;
        }
        else {
            std::cout << "SKIPPED" << std::endl;
        }
        std::cout << "==============================================\n" << std::endl;
    }
    if(allOK) {
        std::cout << "\nYou're a stud (at least on the example cases)!" << std::endl;
    }
    else {
        std::cout << "Some of the test cases failed." << std::endl;
    }
    return 0;
}
