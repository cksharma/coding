#include <bits/stdc++.h>

struct MyException : public std::runtime_error
{
    MyException(const std::string& message) : std::runtime_error(message)
    {}

    virtual const char* what() const noexcept override {
        return std::runtime_error::what();
    }
};

int main()
{
    try
    {
        std::string name = "Chandra";
        throw MyException( name );
    }
    catch( const MyException& ex )
    {
        std::cout << "Got exception: [" << ex.what() << "]" << std::endl;
    }
    /*finally
    {
        std::cout << "Is this even valid" << std::endl;
    }*/
}
