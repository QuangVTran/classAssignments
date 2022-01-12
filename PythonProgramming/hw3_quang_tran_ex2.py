"""
Homework 3 - exercise 2
Quang Tran
Due 10-06-2021
Description:
    This program will count the various different characters in a string, and store them into a dictionary, with the
    individual chars being keys and the number of each char being it's value.
"""
import pprint

myDict = {}

print("Please type in a string")
myString = input()

#for i in myString:
 #   myDict[i] = 1
'''
for i in myString:
    if myString[i] in myDict.keys():
        myDict[i]+= 1
'''

i = 1
myDict = {x:i for x in myString}

'''
input: The quick brown fox jumped over the lazy dog.
output:
{' ': 1,
 'T': 1,
 'a': 1,
 'b': 1,
 'c': 1,
 'd': 1,
 'e': 1,
 'f': 1,
 'g': 1,
 'h': 1,
 'i': 1,
 'j': 1,
 'k': 1,
 'l': 1,
 'm': 1,
 'n': 1,
 'o': 1,
 'p': 1,
 'q': 1,
 'r': 1,
 't': 1,
 'u': 1,
 'v': 1,
 'w': 1,
 'x': 1,
 'y': 1,
 'z': 1}

'''

'''
for x in myString:
    if x == 'a':
        myDict.get('a',x)
'''

#print(myDict)

pprint.pprint((myDict))

