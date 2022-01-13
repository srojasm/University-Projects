import random

counter = 0


def SetCounterToZero():
    global counter
    counter = 0
    return


def quickselect(l, k):
    length = len(l)

    # make changes to the global variable counter
    global counter
    counter += 1

    # Pick a random pivot element from the list, each
    # equally likely
    pivot = random.randint(0, len(l)-1)
    l_small = []
    l_big = []

    # Put all elements smaller than pivot into l_small, and all
    # larger elements into l_big.

    for i in l:
        if i < l[pivot]:
            l_small.append(i)
        if i > l[pivot]:
            l_big.append(i)

    # We assume all elements are distinct, so (besides the pivot) every element
    # should go into l_small or l_big
    assert(length == len(l_small) + len(l_big) + 1)

    if k <= len(l_big):
        # kth largest must be in l_big
        res = quickselect(l_big, k)
        return res

    elif k > len(l_big) + 1:
        # kth largest must be in l_small
        res = quickselect(l_small, k - len(l_big) - 1)
        return res

    else:
        # otherwise return the pivot
        return l[pivot]


def quickselect_2(l, k):
    length = len(l)

    # make changes to the global variable counter_2 (for two pivots)
    global counter
    counter += 1

    # Pick 2 random pivot elements from the list, each
    # equally likely
    pivot_1 = random.randint(0, len(l)-1)
    pivot_2 = pivot_1

    if len(l) > 1:
        # make sure the two pivots are different
        while pivot_2 == pivot_1:
            pivot_2 = random.randint(0, len(l)-1)

        # make pivot_1 always greater than pivot_2
        if l[pivot_1] < l[pivot_2]:
            temp = pivot_1
            pivot_1 = pivot_2
            pivot_2 = temp

    l_small = []
    l_mid = []
    l_big = []

    for i in l:
        # if i is less than smaller pivot, small list
        if i < l[pivot_2] and i != l[pivot_1]:
            l_small.append(i)
        # if i is more than larger pivot, big list
        elif i > l[pivot_1] and i != l[pivot_2]:
            l_big.append(i)
        # if i is less than the larger pivot and greater than the
        # smaller pivot, mid list
        elif i < l[pivot_1] and i > l[pivot_2]:
            l_mid.append(i)

    if len(l) > 1:
        assert(length == len(l_small) + len(l_big) + len(l_mid) + 2)
    else:
        assert(length == len(l_small) + len(l_big) + len(l_mid) + 1)

    if k <= len(l_big):
        res = quickselect_2(l_big, k)
        return res

    elif k > len(l_big) + len(l_mid) + 2:
        if k > len(l_big) + 1 and k <= (len(l_big) + len(l_mid) + 1):
            res = quickselect_2(l_mid, k - len(l_big) - 1)
            return res
        elif k > (len(l_big) + len(l_mid) + 2):
            res = quickselect_2(l_small, k - len(l_big) - len(l_mid) - 2)
            return res
        else:
            return l[pivot_1]

    else:
        return l[pivot_2]


def MonteCarlo(trials):
    # make a variable to count the number of recursions
    number_of_calls = 0

    for i in range(trials):
        SetCounterToZero()
        quickselect(l, k)
#        quickselect_2(l,k)
        number_of_calls += counter

    print("Average number of trials: ", number_of_calls/trials)


l = []
k = 30
list_length = 200
trials = 20000

while len(l) <= list_length:
    randnum = random.randint(0, 1000)
    if randnum not in l:
        l.append(randnum)

MonteCarlo(trials)
