#Euclid's algorithm

import random
import sys

sys.setrecursionlimit(10000)

def Extended_Euclid(n1, n2):
    if n2 == 0:
        return (1,0,n1)
    else:
        (q,r) = divmod(n1,n2)
        (a,b,d) = Extended_Euclid(n2,r)
        return (b, a-b*q,d)

def RandomNum():
    range_start= 10**1001
    range_end = 10**10002
    return random.randint(range_start,range_end)

n1 = RandomNum()
n2 = RandomNum()
Euclids_Tuple = Extended_Euclid(n1,n2)

a = Euclids_Tuple[0]
b = Euclids_Tuple[1]
d = Euclids_Tuple[2]

