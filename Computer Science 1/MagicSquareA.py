#the program creates an odd-sided Magic Square, where the sum of each row, column and diagonal adds up to the same number
#Sofia Rojas
#October 31, 2019

import random

def PrintHelper(List):
    #print 2D list as a square
    for row in range(size):
        print("\n")
        for col in range(size):
            print("\t",List[row][col],end="")

def flatten(List):
    #flatten a 2D list to a 1D list
    if len(List) == 0:
        return []
    else:
        return List[0] + flatten(List[1:])

def RandomMatch(List):
    count = 0
    randomList = random.sample(range(1,10),9)
    #make a list of random numbers between 1 and 9
    while randomList != List:
        #add 1 to count everytime the list does not match the flattened list
        count = count + 1
        randomList = random.sample(range(1,10),9)
    return count

#main section

print("This program creates an odd-sided Magic Square, where the sum of each row, column and diagonal adds up to the same number")
size = int(input("Enter the size of an n x n odd-sided square: "))

Magic_Square = [[0 for row in range(size)] for col in range(size)]
#make a 2D list of zeros

Magic_Square[0][size//2] = 1
#the middle number of the first row is 1

incount = 0
blocked = 0
row_out = 0
col_out = 0
both = 0

row = 0
col = size//2

for num in range(2,size*size+1):
    row = row - 1
    col = col + 1
    if row > -1 and col <= size - 1:
        #if both the row and the column is in the square and within range
        if Magic_Square[row][col] == 0:
            #if the spot is empty
            Magic_Square[row][col] = num
            incount = incount + 1
        else:
            #if the sspot is already filled
            col = col - 1
            row = row + 2
            Magic_Square[row][col] = num
            blocked = blocked + 1

    elif row < 0 and col < size:
        #is row is out of range 
        row = (size - 1)
        Magic_Square[row][col] = num
        row_out = row_out + 1
        
    elif col > size - 1 and row > -1:
        #if the column is out of range
        col = 0
        Magic_Square[row][col] = num
        col_out = col_out + 1
        
    else:
        #if both the column and the row is out of range
        row = size - 1
        col = 0
        if Magic_Square[row][col] != 0:
            #if the spot is filled treat it like it's blocked
            row = 1
            col = size - 1
            Magic_Square[row][col] = num
        else:
            Magic_Square[row][col] = num
        both = both + 1

PrintHelper(Magic_Square)

sum = (Magic_Square[size//2][size//2])*size
print("\nThe sum of each row, column, and diagonal is",sum)
print("Incount: ",incount)
print("Blocked: ",blocked)
print("Row out: ",row_out)
print("Column out: ",col_out)
print("Both: ",both)

if size == 3:
    Magic_SQ = flatten(Magic_Square)
    count = RandomMatch(Magic_SQ)
            
    print("It took ",count,"tries to create a random square to match the Magic Square.")


