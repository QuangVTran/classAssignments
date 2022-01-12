'''
Homework 1
Quang Tran
9-2-2021

This program is a simulated security program. When all of the puzzles are deciphered, a secret message will appear!

'''
from random import randint #imported to use randint function

print("---\t\t Quang's Security Program \t\t---\n\n")
print(" Good luck with these problems")

#These two boolean will shut off the main while loop
programSolved = False
allProblemsSolved = False

q1FirstValue = randint(1,9)
q1SecondValue = randint(1,9)

#These booleans will determine whether or not the questions are answered correctly or not
q2Right = False
q3Right = False
q4Right = False
q5Right = False

while programSolved == False:
    #Important to cast these int values into strings in order to concat
    print('Question 1: What is ' + str(q1FirstValue) + " + " + str(q1SecondValue))
    q1Answer = input()
    if int(q1Answer) != q1FirstValue + q1SecondValue:
        print('Wrong')
        continue

    for i in range(0, 3):
        if i == 0:
            # Complete the sequence of perfect squares
            print('Question 2: Complete this sequence:\n1\t2\t4\t9')
            q2Input = input()
            if q2Input == str(16):
                q2Right = True
            else:
                print("Wrong")
                q2Right = False
                break

        elif i == 1:
            print('Hidden Question 1: What is the UCCS Mascot\'s first name? ' )
            mascotName = input()
            if mascotName == 'Clyde':
                q3Right = True
            else:
                print('Wrong')
                q3Right = False
                break

        elif i == 2:
            print('Hidden Question 2: How many letters are in the word "Colorado" ?')
            numOfLetters = input()
            if numOfLetters != str(len('Colorado')):
                print("Wrong")
                q4Right = False
                break
            else:
                q4Right = True

    print('Question 3: If a circle has a radius of 5, what is it\'s area?')
    pi = float(3.14)
    circleArea = input()
    circleAreaAnswer = float(5 * 5 * pi)

    if circleArea != str(circleAreaAnswer):
        print('Wrong ')
        continue

    print("From the previous answer, if you round the number, what is it?  (HINT: It's a float value) ")
    circleAreaRoundedDown = input()
    if circleAreaRoundedDown != str((circleAreaAnswer//1)):
        print('Wrong')
        print(circleAreaAnswer//1)
        q5Right = False

    else:
        q5Right = True

    if q2Right and q3Right and q4Right:
        allProblemsSolved = True

    if allProblemsSolved:
        programSolved = True
        print("Here is my wifi password : a9tnmufauz")

    else:
        print("\n\nTry again.\n\n")

