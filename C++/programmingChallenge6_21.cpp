#include <iostream>
using namespace std;

//prototype function
bool isPrime (int num);

int main (){

int num=0;

cout << "Enter a number and I'll tell you whether it is prime: ";

//take the user's input number
cin >> num;

//the function will either return 1 or 0, which is for true and false respectively
if (isPrime(num)==true){
    cout << num << " is prime.\n";
}
else{
    cout << num << " is NOT prime.\n";
}

return 0;
}

bool isPrime(int input){

if(input<1){ 
    return false;
}
//The following numbers are always prime
    // therefore, it must return as true if value is 1 2 or 3
else if (input == 1||input == 2 ||input == 3){
    return true;
}

//the % allows for prime numbers to return true
//for any number other than 1 2 or 3, performing modulus on it with an incrementing value will eventually return a 0 if the value is not prime. 
else{
    for(int i=2; i<input; i++){
        if(input % i == 0)
        return false;
    }
return true;
    }
}