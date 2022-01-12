'''
Homework 2,
Exercise 3: Lists
Name: Quang Tran
Date: 9-25-2021
Description of your program:
    Here, I will demonstrate my knowledge of lists by starting with a List of pocket items,
    and rearranging them as well as performing list operations.
'''

def strList(inputList):

    upperBound = len(inputList)
    upperBoundIndex = upperBound - 1

    for i in range(upperBound):
        if i < upperBoundIndex:
            print(str(inputList[i]) ,end=', and ')
        if i == upperBoundIndex:
            print(str(inputList[i]))

#lists

print("The given list is: ")

myList = ['Wallet','Phone','Keys']

print(myList)

print("\nNow sorting...")

myList.sort()

print(myList)

print("\nThe first item of the list is:")

print(myList[0])

print("\nEverything else is:")

print(myList[1:3])

print("\nThe last item of the list is: ")

print(myList[-1])

print("\nThe index of \"Keys\" is :")

print(myList.index('Keys'))

print("\nNow appending a \'Tablet\' to the list")
myList.append('Tablet')
print(myList)

print("\nNow inserting a \'Mask\' into the second index of list")
myList.insert(1,'Mask')
print(myList)

print("\nNow removing the \'Phone\' from the list")
myList.remove('Phone')
print(myList)

print("\nNow reversing the list")
myList.reverse()
print(myList)

print("\nNow, I will take this list and return it as a list separated by a space, comma, and the word \"and\"")
strList(myList)