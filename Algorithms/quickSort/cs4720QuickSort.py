import timeit

#rough timing test
start = timeit.default_timer()

def choosePivot(arr,leftEnd,rightEnd):
    return leftEnd # returns first index, therefore making the pivot the first value of the list/array

def swapArrayValues(arr,firstValue,secondValue):
    i = firstValue
    j = secondValue
    arr[i], arr[j] = arr[j], arr[i]

'''
    temp = arr[firstValue]
    arr[firstValue] = arr[secondValue]
    arr[secondValue] = temp
'''
'''
'''


def partition(arr, leftEnd, rightEnd):
    p = arr[leftEnd]
    i = (leftEnd + 1)


    lowerBound = leftEnd + 1
    upperBound = rightEnd

    #biggest problem here, in python, range doesnt count the upper bound, so we must increment upperbound by 1
    #for the sorting to work.
    for j in range(lowerBound,upperBound+1):
        if arr[j] < p:
            swapArrayValues(arr,i,j)
            i = i + 1

    #testing out two ways to swap in python
    swapArrayValues(arr,leftEnd, (i-1))
    #arr[leftEnd] , arr[i-1] = arr[i-1], arr[leftEnd]

    return i - 1


def quickSort(arr, leftEnd, rightEnd):
    # default case
    if leftEnd >= rightEnd:
        return

    # pivot i
    i = choosePivot(arr,leftEnd,rightEnd)

    swapArrayValues(arr,leftEnd, i)

    j = partition(arr, leftEnd, rightEnd)

    quickSort(arr, leftEnd, j - 1)
    quickSort(arr, j + 1, rightEnd)


array = []

#read from file into array
file = open("problem5.6test3.txt", "r")
for line in file:
    array.append(int(line.strip('\n')))


arrLength = len(array)

print('Before: ' + str(array))

leftIndex = 0

rightIndex = (arrLength - 1)

#swapArrayValues(array,leftIndex ,rightIndex)

quickSort(array, leftIndex, rightIndex)

print('After: ' + str(array))

#rough timing test
stop = timeit.default_timer()

print('Time: ', stop - start)