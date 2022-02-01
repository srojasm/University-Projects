
from random import shuffle, choice


def CatDoors():
    doors = [0, 1, 0]
    shuffle(doors)

    choice_door = choice([0, 1, 2])

    wrong_door = list()
    for i, l in enumerate(doors):
        if l == 0 and i != choice_door:
            wrong_door.append(i)

    door_opened = choice(wrong_door)

    stay_success = True if doors[choice_door] == 1 else False

    last_door = set([0, 1, 2]).difference([choice_door, door_opened])
    last_door = last_door.pop()

    switch_success = True if doors[last_door] == 1 else False

    return stay_success, switch_success


def MonteCarlo(num):
    stay_success_count = 0
    switch_success_count = 0

    for i in range(num):
        stay_success, switch_success = CatDoors()
        stay_success_count += stay_success
        switch_success_count += switch_success

    print("Number of plays:", num)
    print("Probability of success without a switch:", (stay_success_count/num))
    print("Probability of success with a switch:", (switch_success_count/num))
