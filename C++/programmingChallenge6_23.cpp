#include <iostream>
#include <fstream>
#include <stdlib.h>
using namespace std;

//include fstream for files

bool isPrime(int);

int main(){

    int value = 0;
    int i;
    //bool prime for true false 0/1
    bool prime;



    //prompt user to input values
    cout << "Please input a value (3000 and below)";

    ofstream outFile;
    outFile.open("PrimeList.txt");


    while (value == 0 ){//in case the user inputs a 0
    cin >> value;
    }

    //input validation to stop the program if value > 3000

    if(value >= 3000){

        exit(EXIT_SUCCESS);
    }



for(i = 2 ; i < value; i++){
    if(isPrime(i)){
        outFile << i << "\n";
    }
}

    cout << "Prime numbers written to PrimeList.txt.\n";
    outFile.close();
    return 0;
}

//loop returns 0 for nonprime and 1 for prime numbers

//same as previous code
bool isPrime(int n){

    if(n < 1){ 
    return false;
}
else if (n == 1||n == 2 ||n == 3){
    return true;
}

//the % allows for prime numbers to return true
//for any number other than 1 2 or 3, performing modulus on it with an incrementing value will eventually return a 0 if the value is not prime. 
else{
    for(int i=2; i< n; i++){
        if(n % i == 0)
        return false;
    }
return true;
    }
}
