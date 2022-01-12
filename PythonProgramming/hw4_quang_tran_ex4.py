"""
Homework 4
Quang Tran
10-24-2021
Description:
    Using regex, I will sort through a list of potential passwords, and determine whether or not they are secure passwords.


"""

import re

aWeakPassword = "qwerty"

aWeakPassword2 = "Qwerty"

aWeakPassword3 = "qwerty1"

aWeakPassword3 = "1234567890"

aStrongPassword = "cOllEge1sAScamSoExP3nS1ve"

aListOfPasswords = [aWeakPassword,aWeakPassword2,aWeakPassword3,aStrongPassword]

print("This is a list of random passwords: " + str(aListOfPasswords) + "\n")

print("First password test:")


for x in aListOfPasswords:
    passwordCheck = re.match(r'[A-Za-z0-9]{8,}',x)
    if passwordCheck:
        print("Has enough characters: " + str(x))
    else:
        print("Doesn't have enough characters: " + str(x))


print()
print("Second password test:")

for x in aListOfPasswords:
    passwordCheck2 = re.compile(r'[A-Z]')
    goodPW2 = passwordCheck2.search(x)
    if goodPW2 :
        print("Contains upper case letters: " + str(x))
    else:
        print("No uppercase letters: " + str(x))

print()
print("Third password test:")

for x in aListOfPasswords:
    passwordCheck3 = re.compile(r'[1-9]')
    goodPW3 = passwordCheck3.search(x)
    if goodPW3 :
        print("Contains at least one number: " + str(x))
    else:
        print("Missing numbers: " + str(x))

print()
print("Final test:")

for x in aListOfPasswords:
    passwordCheck = re.match(r'[A-Za-z0-9]{8,}', x)
    passwordCheck2 = re.compile(r'[A-Z]').search(x)
    passwordCheck3 = re.compile(r'[1-9]').search(x)

    if passwordCheck and passwordCheck2 and passwordCheck3:
        print("This is a good password: " + str(x))
    else:
        print("This is a bad password: " + str(x))