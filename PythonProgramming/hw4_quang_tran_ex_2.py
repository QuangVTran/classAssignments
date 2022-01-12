'''
Homework 4
Quang Tran
Due 10-24-2021
Description:
    Create a rectangle, circle, and square class, and use their parameters to solve a problem
'''

import math
import random

class Rectangle:
    def __init__(self,length,width):
        self.length = length
        self.width = width

    def area(self):
        return self.length * self.width

    def diagonal(self):
        a = self.length
        b = self.width
        cSquared = math.pow(self.length,2) + math.pow(self.width,2)
        c = math.sqrt(cSquared)

        return c

    def perimeter(self):
        perimeterFormula = (2 * self.length) + (2 * self.width)
        return perimeterFormula

class Circle:
    def __init__(self,radius):
        self.radius = radius

    def area(self):
        pi = math.pi
        return self.radius * self.radius * pi

    def diameter(self):
        return self.radius * 2

    def circumference(self):
        return math.pi * self.diameter()

class Square:
    def __init__(self,length):
        self.length = length

    def area(self):
        return self.length * self.length

    def perimeter(self):
        return 4 * self.length


mySquare = Square(random.randint(2,10))

myCircle = Circle(random.randint(2,10))

myRectangle = Rectangle(random.randint(2,10) , random.randint(2,10))

print("This is a square:")
print("Square Length = " + str(mySquare.length))
print("Square Area = " + str(mySquare.area()))
print("Square Perimeter = " + str(mySquare.perimeter()))
print("Square Diagonal = " + str(mySquare.length))
print()

print("This is a circle:")
print("Circle radius = " + str(myCircle.radius))
print("Circle area = " + str(myCircle.area()))
print("Circle diameter = " + str(myCircle.diameter()))
print("Circle circumference = " + str(myCircle.circumference()))
print()

print("This is a rectangle: ")
print("Rectangle length = " + str(myRectangle.length))
print("Rectangle width = " + str(myRectangle.width))
print("Rectangle perimeter = " + str(myRectangle.perimeter()))
print("Rectangle diagonal = " + str(myRectangle.diagonal()))
print()

print("The assignments wants to compute \"The perimeter of a circle with a radius that's half of the diagonal of a rectangle with a length of 20 and width of 10.\" " )

theRectangle = Rectangle(20,10)
circleRadius = theRectangle.diagonal() / 2
theCircle = Circle(circleRadius)

print("The answer is....")
print(theCircle.circumference())