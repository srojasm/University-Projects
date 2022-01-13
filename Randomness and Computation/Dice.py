# Sofia Rojas

import numpy

# user input number of dice
d = input("How many dice? ")
d = int(d)

# user input options for sums
print("Pick two numbers to compare the likelihood of them being the sum of a roll of", d, "dice")
a = input("First number: ")
a = int(a)
b = input("Second number: ")
b = int(b)

# keep track of how many times A is the sum or B
proportion_of_winsA = 0
proportion_of_winsB = 0

# track the number of trials
total_trials = 0

# make the initial sum of the dice 0
diceSum = 0

i = 0
while i < 100000:
    # keep a counter of how many rolls have happened
    count = 0
    while (count < d):
        # add random rolls to the sum
        diceSum = diceSum + numpy.random.randint(1, 7)
        count += 1
    # keep track of when a comes up as the sum
    if diceSum == a:
        proportion_of_winsA += 1
    # keep track of when a comes up as the sum
    elif diceSum == b:
        proportion_of_winsB += 1
    i += 1
    diceSum = 0
    total_trials += 1

# print the probability of each of the numbers
print("Proportion of", a, ":", proportion_of_winsA/total_trials)
print("Proportion of", b, ":", proportion_of_winsB/total_trials)
