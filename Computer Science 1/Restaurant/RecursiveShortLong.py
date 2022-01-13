#(Recursive) functions that return the shortest and the longest strings in a list of strings
#SOfia Rojas
#November 18, 2019

def shortestLongest(list):
    #put the shortest with the longest
    return shortest(list)+","+longest(list)

def shortest(list):
    #if there is only one object return the one object
    if len(list) == 1:
        return list[0]
    else:
        s = shortest(list[1:])
        #as you recursively go through the list, find what is shortest
        if s < list[0]:
            return s
        else:
            return list[0]

def longest(list):
    #if there is only one object return the one object
    if len(list) == 1:
        return list[0]
    else:
        l = longest(list[1:])
        #as you recursively go through the list, find what is longest
        if l > list[0]:
            return l
        else:
            return list[0]

#main section

strings = ["aaaa","a","aaa", "aaaaaaaaaaaa","aaaaaaaa","aa"]

print(shortestLongest(strings))
