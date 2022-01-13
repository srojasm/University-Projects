import random

def fermatTest(n, ntrials):
    a = random.randint(1, n-1)
    if (ntrials == 0):
        return True
    elif (pow(a,(n-1),n) != 1):
        return False
    elif (pow(a,(n-1),n) == 1):
        return fermatTest(n, ntrials-1)

def fermatPrime(max, ntrials):
    n = random.randint(2, max)
    if (fermatTest(n, ntrials) == True):
        return n
    else:
        while (fermatTest(n, ntrials) == False):
            fermatPrime(max, ntrials)
