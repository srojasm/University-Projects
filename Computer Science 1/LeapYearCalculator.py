#program will take a year and determine whther the year is a leap year
#Rojas.Sofia
#September.5.2019

print("The progrma can tell you whether a year is a leap year or not")
year = int(input("Please enter a year: "))


if year%100 == 0:
    if year%400 == 0:
        print(year,"is a leap year!")
    else:
        print(year,"is NOT a leap year.")
elif year%4 == 0:
    print(year,"is a leap year!")
else:
    print(year,"is NOT a leap year.")
