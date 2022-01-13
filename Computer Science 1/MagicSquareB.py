#this program creates a magic square by using the mod operator
#Sofia Rojas
#November 7, 2019

print("This program creates an odd-sided Magic Square, where the sum of each row, column and diagonal adds up to the same number")
size = int(input("Enter the size of an n x n odd-sided square: "))

Magic_Square = [[0 for col in range(size)] for row in range(size)]

Magic_Square[0][size//2] = 1

row = 0
col = size//2

for num in range(2,size*size+1):
    row = (row-1) % size
    #modulo the row - 1 so that it is a positive number
    col = (col+1) % size
    #modulo the column so that it is within range
    if Magic_Square[row][col] == 0:
        Magic_Square[row][col] = num
    else:
        #if spot is filled, drop one
        row = (row + 2) % size
        col = (col - 1) % size
        Magic_Square[row][col] = num
        

for row in range(size):
    print("\n")
    for col in range(size):
        print("\t",Magic_Square[row][col],end="")