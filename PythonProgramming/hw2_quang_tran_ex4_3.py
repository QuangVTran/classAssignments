'''
Homework 2,
Exercise 4 part 3: Guess the number game
Name: Quang Tran
Date: 9-25-2021
Description of your program:
    Same as the previous one, however, this time we will have the program randomly guess the number instead of the user.
    Importantly, the computer generated guesses cannot have repeated guesses. So if the computer guesses 5,
    it cannot guess 5 again.
'''

from random import randint

numberGuessed = False

lowerBound = randint(1,50)

upperBound = randint(1,50)

#reassign random values in case they're equal
while lowerBound == upperBound:
    lowerBound = randint(1, 50)

    upperBound = randint(1, 50)

#swap lower and upper bound if lower is greater than upper
if lowerBound > upperBound:
    temp = lowerBound
    lowerBound = upperBound
    upperBound = temp

randomNumber = randint(lowerBound,upperBound)

numOfGuesses = 0

#answer key
#print(randomNumber)

listOfGuesses = []

print("I am thinking of a random number between " + str(lowerBound) + " and " + str(upperBound) + "\nYou have 10 guesses.\nGood luck!")

while numOfGuesses < 10 or numberGuessed == False:
    currentGuess = randint(lowerBound,upperBound)
    listOfGuesses.append(currentGuess)
    #makes sure there are no repeating guesses
    while currentGuess in listOfGuesses:
        currentGuess = randint(lowerBound,upperBound)
        #swap just in case the bounds are equal
        if lowerBound > upperBound:
            temp = lowerBound
            lowerBound = upperBound
            upperBound = temp

    print("You guessed: " + str(currentGuess))

    if int(currentGuess) == randomNumber:
        # if the user correctly guesses
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

    # stops the program if the user fails
    if numOfGuesses >= 10 and numberGuessed == False:
        print("Nice try, the number was " + str(randomNumber))
        exit()



