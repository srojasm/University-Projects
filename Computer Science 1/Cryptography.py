#Description: the program will encrypt a message for you
#Rojas.Sofia
#october.2.2019

def cleanup(org_input):
    #make all letters capital and get rid of any none letters
    org_input = org_input.upper()
    clean = ""
    for ltr in org_input:
        if ord(ltr) >= 65 and ord(ltr) <= 90:
            clean = clean + ltr
    return clean

def encrypt(message,key):
    #encrypt the message using a key
    encryption = ""
    for i in range(len(message)):
        Ei = chr((ord(message[i])+ord(key[i]))%26+65)
        encryption = encryption + Ei
    return encryption

def decrypt(message,key):
    #decrypt an encrypted message using a key
    decryption = ""
    for i in range(len(message)):
        Di = chr((ord(message[i])-ord(key[i])+26)%26+65)
        decryption = decryption + Di
    return decryption

#main section

print("This program uses the Vigenère Cipher  to encrypt and decrypt messages.")
message = input("Enter a message to be encrypted and then decrypted: ")
key = (input("Enter the encryption key: ")).upper()

#if the key is shorter than the message
if len(message)>len(key):
    key = key*((len(message)//len(key))+1)

clean_message = cleanup(message)
encrypted_message = encrypt(clean_message,key)
decrypted_message = decrypt(encrypted_message,key)

print(" The cleaned message: ",clean_message,"\n The encrypted message: ",encrypted_message,"\n The decrypted message: ",decrypted_message)
print("Ecryption/Decryption Complete")