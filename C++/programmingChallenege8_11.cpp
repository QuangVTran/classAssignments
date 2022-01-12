#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;


void readFile(string[], string, int);
void selectionSort(string[], int);
void swap(string &, string &);
void displayArray(string[], int);

int main() {
    const int numOfNames = 20;
    string names[numOfNames];

    readFile(names, "names.txt", numOfNames);

    

    cout << "not sorted:" << endl;

    displayArray(names,numOfNames);

    selectionSort(names,numOfNames);

    cout << "sorted: ";

    displayArray(names,numOfNames);


    return 0; 
}



void readFile(string array[], string fileName, int arraySize)
{
    
    
    ifstream inputFile;

    inputFile.open(fileName);

    if (inputFile.fail())
    {
        cout << "Invalid file." << endl;
    }
    else
    {
     
        int index = 0;

        while(getline(inputFile, array[index]) && index != arraySize)
            index++;

        
        inputFile.close();
    }
    
    
}
    




//from book
void selectionSort(string array[], int arraySize)
{
    int minIndex;
    string minValue;

    for (int k = 0; k < (arraySize - 1); k++)
    {
        minIndex = k;
        minValue = array[k];

        for (int index = k + 1; index < arraySize; index++)
        {
            if (array[index] < minValue)
            {
                minValue = array[index];
                minIndex = index;
            }
        }
        swap(array[minIndex], array[k]);
    }
}

//from book
void swap(string &a, string &b)
{
    string temp = a;
    a = b;
    b = temp;
}


void displayArray(string array[], int arraySize)
{

    for (int i = 0; i < arraySize; i++)
        cout << array[i] << endl;

}

