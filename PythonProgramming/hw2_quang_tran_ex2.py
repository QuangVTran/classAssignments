'''
Homework 2,
Exercise 2: Try/Catch exception block for Collatz Function
Name: Quang Tran
Date: 9-25-2021
Description of your program:
    Expanding upon the previous program, this program will implement a try and catch exception block
    which will print out a message letting the user know that an error has been caught. In this particular example,
    we want to catch an error that is resulting of inputting a non-integer value into the Collatz function.
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

#The following try/except clause here is not needed
#try:
exercise1Input = input()
#except ValueError:
#    print("Input must be an integer ")
#except TypeError:
#    print("Input must be an integer ")

try:
    collatzOutput = collatz(int(exercise1Input))
except ValueError:
    print("Input must be an integer ")
except TypeError:
    print("Input must be an integer ")


#continue to call collatz on the input function until it returns 1, which is always will at some point.

try:
    while collatzOutput != 1:

        collatzOutput = collatz(collatzOutput)
except NameError:
    print("Since the input is not an integer, the function cannot continue")