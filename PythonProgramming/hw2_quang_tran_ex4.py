'''
Homework 2,
Exercise 4: Guess the number game
Name: Quang Tran
Date: 9-25-2021
Description of your program:
    This program simulates a guessing game, where the user has to guess a randomly generated integer. If the user
    inputs the wrong number, the program will give hints. After 10 guesses, if the user cannot correctly guess it,
    the program will stop.
'''

from random import randint

numberGuessed = False

randomNumber = randint(1,20)

numOfGuesses = 0

#answer key
#print(randomNumber)

print("I am thinking of a random number between 1 and 20.\nYou have 10 guesses.\nGood luck!")

while numOfGuesses <= 10 or numberGuessed == False:
    currentGuess = input()
    if int(currentGuess) == randomNumber:
        #if the user correctly guesses
        print("You guessed the right number!")
        print("It took you " + str(numOfGuesses) + " tries.")
        numberGuessed = True
        exit()
    else:
        numOfGuesses += 1
        print("Wrong. " + str(10 - numOfGuesses) + " guesses left")
        print("Num of guesses = " + str(numOfGuesses))
        if int(currentGuess) < randomNumber:
            print("Try something higher\n")
        else:
            print("Try something lower\n")

    #stops the program if the user fails
    if numOfGuesses >= 10 and numberGuessed == False:
        print("Nice try, the number was " + str(randomNumber))
        exit()



