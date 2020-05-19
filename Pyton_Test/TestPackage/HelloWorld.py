'''
Created on May 14, 2017

@author: Matthew
'''
from warnings import catch_warnings
'''
#Tkinter stuff (GUI)
import tkinter as tk

class Application(tk.Frame):
    def __init__(self, master=None):
        super().__init__(master)
        self.pack()
        self.create_widgets()

    def create_widgets(self):
        self.hi_there = tk.Button(self)
        self.hi_there["text"] = "Hello World\n(click me)"
        self.hi_there["command"] = self.say_hi
        self.hi_there.pack(side="top")

        self.bye = tk.Button(self)
        self.bye["text"] = "Say Goodbye\n(click me)"
        self.bye["command"] = self.say_bye
        self.bye.pack(side="top")
        
        self.quit = tk.Button(self, text="QUIT", fg="red",
                              command=root.destroy)
        self.quit.pack(side="bottom")

    def say_hi(self):
        print("hi there, everyone!")
        
    def say_bye(self):
        print("that's all she wrote!")

root = tk.Tk()
root.minsize(250, 250)
app = Application(master=root)
app.master.title("TESTTTTTTT")
app.mainloop()
'''
#Practice Stuff
def character_input():
    name = input("Please enter your name: ")
    year = int(input("Please enter your birth year: "))
    year += 100
    result = (name + " will turn 100 in the year " + str(year))
    print(result)
    repeat = int(input("Enter a number: "))
    for i in range(repeat):
        print(result)

def evenOrOdd():
    choice = int(input("Single input or double input?\n"))
    if (choice == 1):
        query = int(input("Please enter a number: "))
        if query % 2 == 0:
            print("Your number is even!")    
        elif query % 4 == 0:
            print("Your number is a multiple of 4!")
        else:
            print("Your number is odd!")
    else:
        num = int(input("Enter a number: "))
        div = int(input("Enter a divisor: "))
        
        if num % div == 0:
            print(str(num) + " divided by " + str(div) + " is even!")
        else:
            print(str(num) + " divided by " + str(div) + " is odd!")

def newList(lst):
    newLst = []
    for i in range (0, len(lst)):
        if lst[i] < 5:
            newLst.append(lst[i])
    return newLst

def divisors():
    num = int(input("Enter a number: "))
    
    divList = []
    for i in range (1, num + 1):
        if num % i == 0:
            divList.append(i)
    return divList

def compareLists(list1, list2):
    longest = []
    shortest = []
    compList = []
    if len(list1) > len(list2):
        longest = list1
        shortest = list2
    else:
        longest = list2
        shortest = list1
    for i in range (0, len(longest)):
        try:
            if shortest.index(longest[i]) >= 0:
                compList.append(longest[i])
        except:
            continue
    return compList

def isPalindrome():
    strng = input("Enter a word or phrase: ")
    strng = strng.lower()
    print(strng)
    strng = strng.strip()
    print(strng)
    strng = strng.replace(' ', '')
    print(strng)
    reverse = []
    
    #you can use reverse = strng[::-1] instead
    i = len(strng) - 1
    while i >= 0:
        reverse.append(strng[i])
        i -= 1
    print(reverse)
    #if reverse == strng
    for i in range (0, len(strng)):
        if not strng[i] == reverse[i]:
            return False
    return True

def listComprehension(lst):
    b = [element for element in lst if element % 2 == 0]
    return b

def rockPaperScissor():
    plays = ["rock", "paper", "scissor"]
    while (True):
        player1 = input("Player 1's turn (type rock, paper, or scissor): ")
        player2 = input("Player 2's turn (type rock, paper, or scissor): ")
        
        if (not player1 == "rock") and (not player1 == "paper") and (not player1 == "scissor"):
            print("Invalid move!\n")
            continue
        elif (not player2 == "rock") and (not player2 == "paper") and (not player2 == "scissor"):
            print("Invalid move!\n")
            continue
        
        if player1 == player2:
            print("It's a tie!")
        elif player1 == "rock":
            if player2 == "paper":
                print("Player 2 wins!")
            else:
               print("Player 1 wins!") 
        elif player1 == "paper":
            if player2 == "scissor":
                print("Player 2 wins!") 
            else:
                print("Player 1 wins!")      
        elif player1 == "scissor":
            if player2 == "rock":
                print("Player 2 wins!") 
            else:
                print("Player 1 wins!")        
                
        state = input("Play again (Y/N)? ")
        if not state == "Y":
            print("\nThanks for playing!")
            break       
    
import random            
def guessMyNumber():
    guesses = 0
    
    while True:
        num = random.randint(1, 9)
        print("I'm thinking of a number between 1 and 9 (inclusive)")
        
        while True:
            guess = int(input("Enter your guess: "))
            
            if guess == num:
                print("You got it!")
                guesses += 1
                break
            elif guess > num:
                print("Nope, too big")
                guesses += 1
            else:
                print("Nope, too small")
                guesses += 1
            
        state = input("Play again (type exit to quit)?")
        if state == "exit" or state == "Exit":
            break       
    
    print("You guessed " + str(guesses) + " times!")

import math
def isPrime():
    num = int(input("Please enter an integer: "))
    sqr = int(math.sqrt(num))
    for i in range (1, sqr + 1):
        if num % i == 0 and i != 1:
            return False
    return True

def tailAndHead(lst):
    newList = [lst[0], lst[len(lst) - 1]]
    return newList

def removeDuplicates(lst):
    newLst = []
    
    for i in lst:
        if i not in newLst:
            newLst.append(i)
    return newLst

def reversePhrase():
    phrase = input("Please enter a phrase: ")
    broken = phrase.split(" ")
    
    newPhrase = ""
    i = len(broken) - 1
    while(i >= 0):
        newPhrase += broken[i] + " "
        i -= 1
    return newPhrase

import random
def passwordGenerator():
    options = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    
    password = ""
    
    for i in range(0, 8):
        index = random.randint(0, len(options) - 1)
        password += options[index]
    return password

def cowAndBull():
    num = random.randint(1000, 9999)
    num = str(num)
    
    print("A random four-digit number has been generated, try to guess it")
    won = False
    while(not won):
        cows = 0
        bulls = 0
        
        guess = input("Enter a four digit guess: ")
        
        for i in range(0, 4):
            if num[i] == guess[i]:
                cows += 1
            elif num.count(guess[i]) > 0:
                bulls += num.count(guess[i])
        if cows == 4:
            print("You win!")
            won = True
        else:
            cows = str(cows)
            bulls = str(bulls)
            print(cows + "cows, " + bulls + "bulls")
     
def binarySearch(lst, key):
    left = 1
    right = len(lst) - 1
    
    while left <= right:
        mid = int((right - left)/2)
        
        if lst[mid] == key:
            return True
        elif key > lst[mid]:
            left = mid
        else:
            right = mid
    return False

lst = [1,2,3,4,5,6,7,8,9]
print (binarySearch(lst, 9))
