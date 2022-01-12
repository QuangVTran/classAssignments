"""
Quang Tran
Homework 7 exercise 2
Due 12-08-2021
Description:
    Here, this exercise makes use of import os and import shutil to create a new folder, and
    search through the local directory to find every pdf file and create a copy into this new folder.
    While we copy them into the new folder, we will use os methods to find out the size of each file.

"""

import os
import shutil

print(os.getcwd())

# /Users/quangtran/PycharmProjects/CS3080

#create a new folder to copy these files into

try:
    os.makedirs(os.path.join(".","hw7Folder"))
except FileExistsError:
    pass

#here, the path can either be /Users/quangtran/PycharmProjects/CS3080 or ../CS3080
# x is folderName, y is subFolders, z is File names
# https://stackoverflow.com/questions/3964681/find-all-files-in-a-directory-with-extension-txt-in-python
for x, y, z in os.walk('../CS3080'):
    for i in z: #for indexFile in files
        if i.endswith(".pdf"):
            #print(os.path.join(x,i))
            absPath = os.path.abspath(i)
            fileSize = os.path.getsize(i)
            print("File's absolute path is: " + absPath + " and it's size in bytes is :"+ str(fileSize))
            #print(os.path.isabs(absPath)) #verifying if the path is absolute
            #copying them over to the new folder
            shutil.copy(absPath,"hw7Folder")



#NOTE: THIS PROGRAM WILL FAIL IF YOU RUN IT MULTIPLE TIMES, since the program cannot create a new folder that already
#exists, which in this case, is hw7Folder (FileExistsError)
    #Follow up note: I placed in a try except block to get around this error.
