'''
Homework 3 - exercise 1
Quang Tran
Due 10-06-2021
Description:
    Using a given grid of nested lists, print out the design of a heart of 0's and .'s. Here, to traverse the grid, I
    implemented a double for loop. Then, I printed out the contents of the for loop and the heart is displayed on the console.

'''

#copied grid from homework assignment
grid = [['.', '.', '.', '.', '.', '.'],
        ['.', 'O', 'O', '.', '.', '.'],
        ['O', 'O', 'O', 'O', '.', '.'],
        ['O', 'O', 'O', 'O', 'O', '.'],
        ['.', 'O', 'O', 'O', 'O', 'O'],
        ['O', 'O', 'O', 'O', 'O', '.'],
        ['O', 'O', 'O','O', '.', '.'],
        ['.', 'O', 'O', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.']]

#in order to print out the heart, scan through and read the grid vertically, column by column

gridLength = len(grid[0])
gridHeight = len(grid)

#using a double for loop to traverse the grid, and print out individual cells of the grid
#the key take away here is to change the end of the string to an empty string, in order to prevent the
#for loop from adding a new line when we don't want it to.
for i in range(gridLength):
    for j in range(gridHeight):
        print(grid[j][i], end="")
    print()


