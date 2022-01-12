'''
Quang Tran
Homework 6 ex 2
Due 11-23-2021
Description:
    Taking a typical fibonacci sequence function, I will implement a cache decorator
    to save these calculations in a dictionary, and improve runtime performance by reusing
    fibonacci values rather than recalculating them.

    There was a huge difference in using the cache, in fact I
    was able to compute up to 250 iterations of fibonacci, and it only took about 500 calls in the countCall
    function, in comparison, without the cache, it went upwards of over 1 million calls without ever ending and
    computing the fibonacci value.

'''
import functools

#countCalls function from lecture notes
def countCalls(func):
    @functools.wraps(func)
    def wrapperCountCalls(*args, **kwargs):
        wrapperCountCalls.numCalls += 1
        print("Call {} of {}".format(wrapperCountCalls.numCalls, func.__name__))
        return func(*args, **kwargs)
    wrapperCountCalls.numCalls = 0
    return wrapperCountCalls

#tried implementing the nested decorator from the lecture notes, failed to implement properly
'''
def cache(func):
    @functools.wraps(func)
    def wrapperDecorator(*args,**kwargs):
        #Do something before
        #print(wrapperDecorator.dictionary)

        value = func(*args, **kwargs)
        #Do something after
        if value in wrapperDecorator.dictionary:
            return value
        if value not in wrapperDecorator.dictionary:
            wrapperDecorator.dictionary[wrapperDecorator.index] = value
            print(wrapperDecorator.dictionary.values())
            wrapperDecorator.index += 1
        return value
    wrapperDecorator.dictionary = {}
    wrapperDecorator.index = 1
    return wrapperDecorator
'''

#the way this cache function works is that it stores the value into a dictionary if that value is already calculated
#for example, in fibonacci(5), you need the sum of fib(4) and fib(3), and for fib(4), you need the sum of fib(3)
#and fib(2). Since fib(3) has already been calculated, instead of making the computer recalculate it, it can just simply
#grab that value that we stored in the cache
def cache(func):
    cache = {}
    def wrapper(value):
        if value not in cache:
            cache[value] = func(value)
        return cache[value]
    return wrapper

@countCalls
@cache
def fibonacci(num):
    if num < 2:
        return num
    return fibonacci(num - 1) + fibonacci(num - 2)


print(fibonacci(255))

#with the @cache decorator, there are 19 total calls for fibonacci(10)
#without it, there are 177 calls for fibonacci(10)