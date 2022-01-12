"""
Homework 5 ex 2
Quang Tran
Due 11-07-2021
Description:
    This program utilizes a generator expression to create a list of pythagorean triples.
"""

import math

#The hard part was figuring out how to find the pythagorean triplets themselves, however, with some clever
#algebra and help I found on youtube, a formula can be derived for side a, b, and c of a right triangle

print("Please input how many pythagorean triplets you would like")

userInput = input()
if userInput.isnumeric():
    print("Printing " + userInput + " Pythagorean triples")
else:
    print("Input is not an integer. Good bye")
    exit()

exp1 = (x for x in range(1,1000))

exp2 = (x for x in range(2,1000))

theList = []

for i in range(int(userInput)):
    number1 = next(exp1)

    number2 = next(exp2)

    b = 2 * (number1 * number2)
    a = int(math.pow(number2,2)) - int(math.pow(number1,2))
    c = int(math.pow(number2,2)) + int(math.pow(number1,2))

    pythaTripTuple = (a,b,c)
    theList.append(pythaTripTuple)

#The resulting list has tuples of pythagorean triplets... however, it skips some values
print(theList)