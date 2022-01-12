"""
Homework 5 ex 1
Quang Tran
Due 11-07-2021
Description:
    This program utilizes iterators to create an iterator class that takes a list and reverses it
"""


class MyIterator:
    def __init__(self, aList):
        self.start = len(aList)  # starts at the end of the list
        self.i = self.start
        self.aList = aList

    def __iter__(self):
        return self

    def __next__(self):
        if self.i > 0:
            result = self.i
            self.i -= 1
            return result
        else:
            raise StopIteration()


aList = {1, 2, 3, 4, 5}

myIterator = MyIterator(aList)

#Use a for loop to traverse through a list and print out each item while the iterator iterates
#Typically, an iterator will read from the start of the list (0) until the end of the list
#Here, my custom iterator will read from the end of a list until it reaches the front of a list.
for x in range(len(aList)):
    print(next(myIterator))

#THIS FOLLOWING PRINT WILL ATTEMPT TO CALL THE NEXT ITEM IN THE ITERATOR
#HOWEVER, SINCE THE ITERATOR HAS REACHED THE END, A STOPITERATION() ERROR WILL BE RAISED

#print(next(myIterator))