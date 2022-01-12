"""
Quang Tran
CS 3080
Homework 7 ex 3
Due 12-08-2021
Description:
    Here, we create a multi threaded program that takes user input for a number of threads, and run a single function
    that has multiple threads running at the same time, allowing it to simultaneously do multiple things at once.
    Also, by using the logging module, I was able to print out these lines with human-readable time and line numbers
    to show the user where they are in the code and how long it takes to run the code.

"""
import threading
import logging
import time

#logging format
logging.basicConfig(level=logging.DEBUG, format='%(asctime)s - %(lineno)d - %(message)s')

logging.debug('Start of program')

def someFunc(i):
    thingToPrint = "Welcome thread " + str(i)
    logging.debug(thingToPrint)
    if i % 2 == 0:
        logging.debug("Number " + str(i) + " is even" )
    else:
        logging.debug("Number " + str(i) + " is odd")

    time.sleep(3)
    logging.debug("Goodbye Thread " + str(i))


print("Please enter an integer for the number of threads")

numThreads = 0

numThreads = int(input())

while(numThreads < 2):
    print("Please re-enter an integer that's greater than or equal to 2")
    numThreads = int(input())

#threadObj = threading.Thread(target=someFunc)

threads = [None] * numThreads

for i in range(len(threads)):

    threads[i] = threading.Thread(target=someFunc,args=(i,))
    threads[i].start()



for i in range(len(threads)):
    threads[i].join()

