'''
Homework 2,
Exercise 1: Collatz Function
Name: Quang Tran
Date: 9-25-2021
Description of your program:
    This program has a function that will take an input integer x, and depending on it's parity(even or odd)
    the program will return x / 2 for even values, and 3x + 1 for odd values.
    No matter what integer is input, the function will eventually return the integer 1.
'''

def collatz(number):
    #if the number is even
    if number % 2 == 0:
        print(number // 2)
        #print and return number / 2 (floored division)
        return number // 2

    if number % 2 == 1:
        print(3 * number + 1)
        #print and return 3x + 1
        return 3 * number + 1



print("Collatz Function: \nPlease enter an integer.")
exercise1Input = input()

collatzOutput = collatz(int(exercise1Input))

#continue to call collatz on the input function until it returns 1, which is always will at some point.
while collatzOutput != 1:
    collatzOutput = collatz(collatzOutput)