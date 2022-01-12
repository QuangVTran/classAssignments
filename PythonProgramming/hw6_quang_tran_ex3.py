'''
Quang Tran
Homework 6 ex 3
Due 11-23-2021
Description:
    Create a python program that keeps track of multiple pieces of text, saving them to a clipboard under a keyword.

'''



print("Please type in the following options:")
print("\"save\" to save current clipboard contents under keyword ")
print("\"list\" to print out all saved keywords")
print("\"stop\" to stop the program")

clipboard = {}
currentClipboard = []

beginProgram = True

while beginProgram:
    print("\nPlease type in an input")
    currentInput = input()

    #here, the program will shut off if the user inputs stop
    if currentInput == "stop":
        beginProgram = False
        exit()

    #here the current list of inputs will be saved under a keyword in the main clipboard
    elif currentInput == "save":
        print("Type in the next keyword")
        nextKeyword = input()

        #concatenating the items from the current clipboard onto the main clipboard under a keyword
        bigString = " ".join(currentClipboard)
        currentClipboard.clear()
        clipboard[nextKeyword] = bigString
        print("Clipboard has been updated with keyword: " + nextKeyword)
        currentInput = ""

    #this just prints out the current main clipboard
    elif currentInput == "list":
        print(clipboard)
        currentInput = ""

    #if the user inputs anything besides the arguments: "save" "list" or "stop", that input will be taken and placed on the
    #clipboard
    else:
        currentClipboard.append(currentInput)
        print("Here is the current list:")
        print(currentClipboard)
        currentInput = ""