#this program determines your Bosy Mass Index and determines whether you are overweight, underweight, or normal
#Rojas.Sofia
#September.6.2019

def computeBMI(weight,height):
    new_weight = weight/2.205
    new_height = (height/39.37)**2
    BMI = new_weight/new_height
    return (round(BMI,1))

    
#main code

print("This program will determine your BMI")
height_ft = int(input("Please enter your height in feet: "))
height_in = int(input("Enter inches: "))
weight_lbs = float(input("Please enter your weight in pounds: "))

real_height = height_ft*12+height_in
print("You are",real_height,"inches tall.")

BodyMassIndex = computeBMI(weight_lbs,real_height)

if BodyMassIndex < 18.5:
    print("Your BMI is",BodyMassIndex,"and you are underweight.")
elif BodyMassIndex > 24.9:
    print("Your BMI is",BodyMassIndex,"and you are overweight.")
else:
    print("Your BMI is",BodyMassIndex,"and you are normal weight.")



