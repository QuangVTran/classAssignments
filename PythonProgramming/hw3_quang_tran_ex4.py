'''
Homework 3, exercise 4
Quang Tran
Due 10-06-2021
Description:
    This program is a prototype of a tic-tac-toe board. This tic tac toe board will only
    simulate the placement of X's and O's, using a dictionary as the data structure. Because
    it's an incomplete prototype, the program cannot tell if there is a winner or tie.

'''

def printBoard(board):
    print(board[1] + '|' + board[2] + '|' + board[3])
    print("-----")
    print(board[4] + '|' + board[5] + '|' + board[6])
    print("-----")
    print(board[7] + '|' + board[8] + '|' + board[9])
    print()

def clearBoard(board):
    board = {1:' ',2:' ',3:' ',4:' ',5:' ',6:' ',7:' ',8:' ',9:' '}
    return board


myTicTacToe = {1:'1',2:'2',3:'3',4:'4',5:'5',6:'6',7:'7',8:'8',9:'9'}

print("Follow the example below to see which tic tac toe slots are which.")
printBoard(myTicTacToe)
print("......\n......\n")
myTicTacToe = clearBoard(myTicTacToe)

currentMove = 'X'
for i in range(9):
    print("Turn: " + str(i))
    print("It is " + currentMove + "\'s turn, select a slot from 1-9")
    printBoard(myTicTacToe)
    moveSelection = int(input())
    while moveSelection not in range(1,10):
        print("Invalid input, try again")
        moveSelection = int(input())
        if moveSelection in range(1,10):
            break

    myTicTacToe[moveSelection] = currentMove

    if currentMove == 'X':
        currentMove = 'O'
    else:
        currentMove = 'X'

print("Here is the resulting board:")
printBoard(myTicTacToe)