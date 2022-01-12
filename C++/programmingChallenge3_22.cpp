#include <iostream>
#include <string>
using namespace std;

int main(){

    //declaring variables
    string name;
    string city;
    string age; 
    string collegeName;
    string profession;
    string animalType;
    string petName;
    
    //Prompting the user to fill in these string variables;
    cout << "Enter name: ";
    getline(cin,name);

    cout << "Enter city: ";
    getline(cin,city); 

    cout << "Enter age: ";
    getline(cin,age);

    cout << "Enter college: ";
    getline(cin,collegeName);

    cout << "Enter profession: ";
    getline(cin,profession);
    
    cout << "Enter animal: ";
    getline(cin,animalType);

    cout << "Enter pet name: ";
    getline(cin,petName);

    //printing some empty lines to make it neat
    cout << endl << endl << endl;

    //putting the story together
    cout << "There once was a person named " << name << " who lived in " << city << endl;
    cout << "At the age of " << age << ", " << name << " went to college at " << collegeName << "." << endl;
    cout << name << " graduated and went to work as a " << profession << ". " << endl;
    cout << "Then, " << name << " adopted a(n) " << animalType << " named " << petName << "." << endl;
    cout << "They both lived happily ever after " << endl;

    return 0;
    
    }