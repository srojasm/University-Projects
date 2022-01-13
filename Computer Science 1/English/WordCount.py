#this program will count how many distinct words are in the novel David COpperfield and how many times each word appears
#Sofia Rojas
#December 4, 2019

def read_word_list():
    davidC = open("ENGLISH_LIT.txt","r")
    print("OPEN")
    book = davidC.read()
    print("DONE")
    return book.split()

def build_dictionary(word_list):
    davidDict = {}
    for word in word_list:
        if word not in davidDict:
            davidDict[word] = 1
        else:
            davidDict[word] = davidDict[word] + 1
    return davidDict

def most_frequent(dict_book,freq):
    tuples = []
    for key in dict_book:
        if dict_book.get(key) >= freq:
            item = (dict_book.get(key),key)
            tuples.append(item)
    tuples.sort(reverse=True)
    return tuples

#main section

print("\nThis program prints word occurences in a long list \n")
book = read_word_list()
print("FILE READ")

dict_book = build_dictionary(book)
print("DICTIONARY CREATED")
print(dict_book)

frequency_limit = int(input("Enter freqency: "))
tuple_list = most_frequent(dict_book,frequency_limit)
print("TUPLE LIST")
print(tuple_list)
