'''
Quang Tran
Homework 7: Files and Threading, Example 1
Due 12-8-2019
Description:
    Here, we go through a simulation where my boss emails me a bunch of files, ending in American style dates
    (MM-DD-YYYY), and using regex and file directories, search through and find every file that ends in
     an American style date and change its date style to Asian style dates (YYYY-MM-DD).

'''

import re
import os
import shutil

americanStyleDateRegex = re.compile(r'(\d{2})-(\d{2})-(\d{4})')
asianStyleDateRegex = re.compile(r'(\d{4})-(\d{2})-(\d{2})')

#also need regex for everything else in the file that's not the date


fileNameAmericanDate = re.compile(r'.*[^(\d{2})\-(\d{2})\-(\d{4})].*?')
fileNameAsianDate = re.compile(r'.*[^(\d{4})\-(\d{2})\-(\d{2})].*?')

#testing the regex
'''
mo = fileNameAsianDate.search("The date is 2021-12-08")
mo2 = fileNameAmericanDate.search("The date is 12-08-2021")

print(mo.group())
print(mo2.group())

#print(os.listdir())
'''

currDirectory = os.getcwd()

for f in os.listdir(currDirectory):
    currentFile = os.path.join(currDirectory,f)
    matching = americanStyleDateRegex.search(currentFile)
    if matching is not None:
        dateFromFile = americanStyleDateRegex.search(currentFile)
        fileNameWithoutDate = fileNameAmericanDate.search(currentFile)

        #testing to see what prints out
        #print(currentFile)
        #print(dateFromFile.groups())
        #print(fileNameWithoutDate.group())

        #the regex finds the american style date, and separates the 3 as month,day, and year
        month = dateFromFile.group((1))

        day = dateFromFile.group((2))

        year = dateFromFile.group((3))

        #converts the american style date to an asian style date
        asianDateString = year + "-" + month + "-" + day;

        finalFileName = fileNameWithoutDate.group() + asianDateString

        shutil.move(currentFile,finalFileName)