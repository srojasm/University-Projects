#this program will calculate the fee on a speeding ticket
#Rojas.Sofia
#september.11.2019

def fine(speed,limit):
    if speed < limit + 10:
        standard_fine = 50
    else:
        standard_fine = 50 + 10*(speed - (limit + 10))
        #an additional $10 for every mile that's more than the posted speed limit plus 10
        if standard_fine > 500:
            standard_fine = 500
            #the standard fine cannot be more than $500
        else:
            standard_fine = standard_fine
    return standard_fine

def con_zone(fine):
    begins = int(input("Enter the start of the construction zone times in 24 hour format: "))
    ends = int(input("Enter the end of the contrction zone times in 24 hour format: "))
    time = int(input("Enter the time of the day in 24 hour format: "))
    if ends < begins:
        #in the case that the end of construction zone is the early morning while the beginning is in the late night
        if time < ends or time > begins:
            fine = fine*3
        else:
            fine = fine*2
    else:
        if time > begins and time < ends:
            fine = fine*3
        else:
            fine = fine*2
    return fine
        

#main section

print("This program computes the fine for speeding on the Massachusetts Turnpike.")
speed = int(input("Enter the speed of the car in MPH: "))
limit = int(input("Enter the speed limit in MPH: "))

if speed < limit:
    #this is within the limit
    print("No fine.")
else:
    fine = fine(speed,limit)
    construction = input("Is it in a construction zone? Enter yes or no: ")
    if construction.lower() == "yes" or construction.lower() in "yes":
        zone_fine = con_zone(fine)
    else:
        zone_fine = fine
    cost_of_fine = zone_fine + 50
    #add $50 donation to the head injury fund
    print("The fine is $",cost_of_fine,"which includes a $50 donation to the head injury fund.")


