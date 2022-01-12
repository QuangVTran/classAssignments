"""
Homework 3
Quang Tran
Due 10-06-2021
Description:
    This program will take an inventory of items, and place them into a dictionary, with the item being the keys and
    the quantity being the values. There are also functions that allow the user to add items to the inventory
    as well as remove items as well.
"""


def printInventory(inventory, leftWidth, rightWidth):
    print('Current Inventory'.center(leftWidth + rightWidth, '-'))
    for k, v in inventory.items():
        print(k.ljust(leftWidth, ' ') + str(v).rjust(rightWidth))

    print("")
def addItem(inventory, item):
    if item not in inventory:
        inventory[item] = 1
    else:
        inventory[item]+= 1



def deleteItem(inventory, item):
    #del inventory[item]
    if item not in inventory:
        print(str(item) + " is not in the inventory")
        return 0

    if inventory[item] == 0:
        print("There are no more " + str(item) + " items in the inventory")
        return 0

    if inventory[item] > 0:
        inventory[item] -= 1

def printMenu():
    print("Select an option below:")
    print("1: Print the current Inventory")
    print("2: Add an item to the inventory")
    print("3: Delete an item from the inventory")
    print("4: Finish and stop the program")


myInventory = {'Hand Sanitizer': 10, 'Soap': 6, 'Kleenex': 22, 'Lotion': 16, 'Razors': 12}

# print(myInventory)

finishProgram = False

# printInventory(myInventory,16,5)

while finishProgram is False:
    printMenu()
    userInput = int(input())

    if userInput == 1:
        printInventory(myInventory, 16, 5)
    elif userInput == 2:
        print("Please specify what item you want to add (case sensitive)")
        itemToAdd = input()
        addItem(myInventory,itemToAdd)
    elif userInput == 3:
        print("Please specify what item you want to remove (case sensitive)")
        itemToRemove = input()
        deleteItem(myInventory,itemToRemove)

    elif userInput == 4:
        print("Stopping the program...")
        print("")
        printInventory(myInventory, 16, 5)
        finishProgram = True
