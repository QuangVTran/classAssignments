"""
Homework 4
Quang Tran
10-24-2021
Description:
    Using Regex, I searched through a string to find phone numbers and email addresses.

"""

import re

#i filled a string by pressing buttons on my keyboard, and hid some phone numbers and emails in there
stringOfStuff = 'vdfjk nvjknasnd719-123-1234dasjkns dhjnjc719-321-3213vdfn ciuncweiunc qtran2@uccs.edu nhjcsdnh__j vd ' \
                ' nhfvjd-4353-454-353-4543-5-3423 yyzhuang@uccs.edu413432-35 asddfbdfvf 243424edFSS kKardashian@gmail.comdFefw' \
                'sadmsdfd gWashington@AOL.com msvmjdkv j'

phoneNumberRegex = re.compile(r'\d\d\d-\d\d\d-\d\d\d\d')

print(phoneNumberRegex.findall(stringOfStuff))

emailRegex = re.compile(r'\S+.@uccs.edu|\S+.@gmail.com|\S+.@\S+')

print(emailRegex.findall(stringOfStuff))