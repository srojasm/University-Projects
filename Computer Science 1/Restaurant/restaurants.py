#creates a 2D list of the list of restaurants
#Sofia Rojas
#November 13, 2019

print("This program will compare different restaurants in the greater Boston area.")
restFile = open('restaurants.HW9.txt','r')

lines = restFile.readlines()
print(lines)

for r in lines:
    print(r)

rest2DList = [[s.lstrip().rstrip() for s in x.split(",")] for x in lines]
print(rest2DList)

for i in range(len(rest2DList)):
    print(rest2DList[i],"\n")

print()
print()
print("Some Sample Output - Name and Rating")
for i in range(len(rest2DList)):
    print(rest2DList[i][0],"",rest2DList[i][4])

print()
print()

cuisines = []
for rest in range(len(rest2DList)):
    if [rest2DList[rest][2]] not in cuisines:
        #add each cuisine to a list of all the cuisines without repeats
        cuisines.append([rest2DList[rest][2]])
        
for c in range(len(cuisines)):
    for r in range(len(rest2DList)):
        #if the restaurant has the same cuisine, add the rating to the list in the cuisines list with the same type of cuisine
        if rest2DList[r][2] == cuisines[c][0]:
            cuisines[c] = cuisines[c] + [float(rest2DList[r][4])]

for c in range(len(cuisines)):
    #add all the rates in each list then divide by the amount of items in the list
    avg = (sum(cuisines[c][1:]))/(len(cuisines[c])-1)
    #delete everything from the list except the name of the cuisine
    del cuisines[c][1:]
    cuisines[c].append(avg)

avg_highest = -1
avg_high_cuisine = ""
for c in range(len(cuisines)):
    if cuisines[c][1] > avg_highest:
        #if the average rating is more than the previous highest rating then that one becomes the highest
        avg_highest = round(cuisines[c][1],2)
        avg_high_cuisine = cuisines[c][0]
print("The cuisine with the highest average rating and the rating: ")
print(avg_high_cuisine,"cuisine has the highest average of",avg_highest)


avg_lowest = 10
avg_low_cuisine = ""
for c in range(len(cuisines)):
    if cuisines[c][1] < avg_lowest:
        #if the average rating is less than the previous lowest rating then that one becomes the lowest
        avg_lowest = round(cuisines[c][1],2)
        avg_low_cuisine = cuisines[c][0]
print("\nThe cuisine with the lowest average rating and the rating: ")
print(avg_low_cuisine,"cuisine has the lowest average of",avg_lowest)


highest = -1
highest_rest = ""
for rest in range(len(rest2DList)):
    if float(rest2DList[rest][4]) > highest:
        #if the rating is more than the highest than that one becomes the highest
        highest = float(rest2DList[rest][4])
        highest_rest = rest2DList[rest][0]
print("\nThe restaurant with the highest rating and the rating: ")
print(highest_rest,"and",highest)


expensive = ""
exp_rest = ""
for rating in range(len(rest2DList)):
    for rest in range(len(rest2DList)):
        #if the amount of $ is more than the assigned string for expensive than 
        if len(rest2DList[rest][3]) > len(expensive):
            expensive = rest2DList[rest][3]
    if rest2DList[rating][3] == expensive:
        #add all the restaurants with the same dollar rating to the string
        exp_rest = exp_rest + rest2DList[rating][0] + " and "
print("\nThe most expensive restaurant(s) with the dollar rating: ")
print(exp_rest[:-5],"all have a",expensive,"rating")



low_rating = 10
low_rest = ""
for rest in range(len(rest2DList)):
    #only look at the restaurants that are in Boston
    if rest2DList[rest][1] == "Boston":
        #if the rating is less than the lowest rating than that one becomes th elowest
        if float(rest2DList[rest][4]) < low_rating:
            low_rating = float(rest2DList[rest][4])
            low_rest = rest2DList[rest][0]
print("\nThe restaurant in Boston with the lowest rating: ")
print(low_rest,"has the lowest rating of",low_rating)
