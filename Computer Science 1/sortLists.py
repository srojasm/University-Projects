#this program will sort list and then randomally generated numbers will be created until one of the randomly generated numbers is in the list
#Sofia Rojas
#October 23, 2019

import random

def sorted(List):
    for index in range(1,len(List)):
        val = List[index]
        j = index - 1
        while (j >= 0) and (List[j] > val):
            List[j + 1] = List[j]
            j = j - 1
        List[j+1] = val
    return List

def binarySearch(List,target):
    lower = 0
    upper = len(List)
    found = False
    while lower < upper:
        mid = (lower + upper) // 2
        val = List[mid]
        if target == val:
            return True
        elif target < val:
            upper = mid - 1
            mid = (upper - lower)//2
        elif target > val:
            lower = mid + 1
            mid = (upper - lower)//2
    return False
        
#main section

originalList = []
while len(originalList) != 10:
    selection = random.randint(0,100)
    if selection not in originalList:
        originalList.append(selection)

print("Original List: ",originalList)
sortedList = sorted(originalList)
print("Sorted List: ",sortedList)

search = False
count = 0

while search != True:
    target = random.randint(0,100)
    print("Target = ",target)
    search = binarySearch(sortedList,target)
    count = count + 1
    
print("Count = ",count)
