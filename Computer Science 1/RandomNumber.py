#this program creates a 4 digit nonnegative integer and user must figure out the number
#Rojas.Sofia
#September.21.2019

import random

def getRandom():
    #creates the random number
    random_num = ""
    count = 0
    while count < 4:
        selection = str(random.randint(0,9))
        if selection not in random_num:
            random_num = random_num + selection
            count = count+1
    return random_num

#main section

random = str(getRandom())

print("Guess the 4-digit random nonnegative integer (there are no repeats).")
print("The program will tell you if a digit is in the number and if it is in the correct position.")
print("Good luck!")
print("")

guess = str(input("Enter a 4 digit number with no repeats: "))
#as a string, the guess can be sliced

while guess != random:
    try:
        assert len(guess)==4
        #any number longer than or shorter than 4 will be considered invalid

        for i in range(4):
            if random.find(guess[i]) != -1:
                print("YES",guess[i],"is present!")
                #is the number in both strings
                if guess[i] == random[i]:
                    print("and it is in the correct position")
                    #is the number in the correct location
            else:
                print("NO",guess[i],"is not present")
                
    except (AssertionError):
        print("Please enter a valid 4 digit number.")
        print("")
    print("")
    guess = str(input("Enter another number: "))
    
if guess == random:
    print("WINNER you've guessed the random number!")

