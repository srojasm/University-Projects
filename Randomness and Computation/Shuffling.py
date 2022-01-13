import random
# GSR Shuffling


def gsr(l):
    # track the sequence of coin flip outcomes
    coin_flips = []
    heads = 0
    tails = 0
    for i in l:
        # let 0 be heads and 1 be tails
        flip = random.randint(0, 1)
        coin_flips.append(flip)
        if flip == 0:
            heads += 1
        if flip == 1:
            tails += 1

    # divide the deck into two separate packets
    left_packet = []
    right_packet = []

    # let the number of heads be the length of the left packet
    # and the number of tails be the length of the right packet
    for k in l:
        if len(left_packet) < heads:
            left_packet.append(k)
        else:
            right_packet.append(k)

    # create a new list for the shuffle
    new_l = []

    for i in coin_flips:
        # for every head in the coin flip sequence, add a card
        # from the left packet
        if i == 0:
            new_l.append(left_packet[0])
            left_packet.pop(0)

        # for every tail in the coin flip sequence, add a card
        # from the right packet
        if i == 1:
            new_l.append(right_packet[0])
            right_packet.pop(0)
    return new_l

# Top-To-Random Shuffling


def top_to_random(l):
    new_l = []

    # make the shuffled list the same as the original list to begin
    for i in l:
        new_l.append(i)

    # find a random position for the top card
    position = random.randint(0, len(l)-1)
    element = l[0]

    # move the top card from the front to the new position
    new_l.pop(0)
    new_l.insert(position, l[0])
    return new_l


def test_order(i, j, l):
    # if the index of the card i is smaller (above) the index of the
    # card j, then return True
    if l.index(i) < l.index(j):
        return True
    else:
        return False


def MonteCarloSim(l):
    # track the number of times that the order is correct
    prob_test_order = 0
    trials = 20000
    k = 0

    num_of_shuffles = int(input("Number of shuffles: "))
    i = int(input("What number above: "))
    j = int(input("What number below: "))
    method = input("GSR shuffling or top to random (TTR): ")

    while k < trials:
        m = 0
        # shuffle the cards but not the original list
        if method == "GSR":
            shuffle = gsr(l)
            while m < num_of_shuffles-1:
                shuffle = gsr(shuffle)
                m += 1
        elif method == "TTR":
            shuffle = top_to_random(l)
            while m < num_of_shuffles-1:
                shuffle = top_to_random(shuffle)
                m += 1

        # find if i is before j for this specific shuffle
        if test_order(i, j, shuffle) == True:
            prob_test_order += 1
        k += 1
    print("Probability: ", (prob_test_order/trials))


length = int(input("Length of list: "))
l = []
count = 0
while len(l) < length:
    l.append(count)
    count += 1

MonteCarloSim(l)
