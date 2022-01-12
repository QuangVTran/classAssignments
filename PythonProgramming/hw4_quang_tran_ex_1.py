'''
Homework 4
Quang Tran
Due 10-24-2021
Description:
    Creates a password manager, and use pyperclip to copy the password onto the user's clipboard.
    Since pyperclip wouldn't work in my pycharm, I just had the program print out the passwords
'''

class pwLocker:
    def __init__(self):
        self.username = "myInstagramUsername"
        self.username2 = "myEmailPassword"
        #I decided to have fun here
        self.username3 = "qtran2@uccs.edu"

    password = "htS:D`t*hQH3]9\"C)"
    password2 = "asdmkluivhgru12324"
    password3 = "NICE TRY YOU WILL NEVER GUESS MY PASSWORD"

# *Note*
#import pyperclip wouldn't work for me on pycharm, so I could not copy the password onto the user's clipboard

import random;

#prompt the user to input their username
print("Welcome to the password locker!")
print("Please type in your username.")

thePwLocker = pwLocker();

randomNumber = random.randint(1,10)

userInput = input()

# 3 possible inputs for user names
if userInput == thePwLocker.username:
    print("This is the password: " + pwLocker.password)
    exit()
elif userInput == thePwLocker.username2:
    print("This is the password: " + pwLocker.password2)
    exit()
elif userInput == thePwLocker.username3:
    print("You wanna know my email password?")
    print("What's my favorite number?")

    guess = input()


    if guess == str(randomNumber):
        print(pwLocker.password3)
    else:
        print("Nice try, maybe next time")

    exit()

#print error if user inputs blank string
if userInput == "":
    print("You have to actually put in a username ")
    exit()

#print error if username is not in the password locker
if userInput != thePwLocker.username or thePwLocker.username2 or thePwLocker.username3:
    print("ERROR: INCORRECT USER NAME")
    exit()
