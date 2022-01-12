'''
Quang Tran
Homework 6 ex 1
Due 11-23-2021
Description:
    Using the Slow Down decorator example given in class, this function will take a countdown function, and slow it down
    second by second. I took the in-class example and made a little hide and seek simulation.

'''

import functools
import time

#Copied the slowDown.py given in class over
def slowDown(func):
    """Sleep 1 second before calling the function"""
    @functools.wraps(func)
    def wrapperSlowDown(*args, **kwargs):
        time.sleep(1)
        return func(*args, **kwargs)
    return wrapperSlowDown


@slowDown
#default argument fromNumber is 1, if there is no input, the function's default input will be 1
def countdown(fromNumber = 10):
    if fromNumber < 1:
        print("Ready or not, here I come!")
    else:
        print(fromNumber)
        countdown(fromNumber - 1)

def defaultOrNot():
    print("Let's play hide and seek!")
    print("Would you like to countdown from 10 seconds? Or input a custom amount of time?")
    print("T/F (Case sensitive)")
    userInput = input()
    if userInput == 'T':
        return True
    elif userInput == 'F':
        return False
    else:
        print("Invalid input")
        exit()


myBool = defaultOrNot()

print(myBool)

if myBool is True:
    countdown()
else:
    print("How much time do the hiders get to hide? (In seconds)")
    howLongToSleep = int(input())
    countdown(howLongToSleep)


