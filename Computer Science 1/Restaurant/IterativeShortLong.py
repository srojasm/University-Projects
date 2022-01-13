#(iteration) functions that return the shortest and the longest strings in a list of strings
#Sofia Rojas
#November 17, 2019

def shortestLongest(list):
    shortest = list[0]
    longest = list[0]
    for i in range(len(list)):
        #if the item is shorter than shortest then it replaces shortest
        if len(list[i]) < len(shortest):
            shortest = list[i]
        #if the item is longer than longest then it replaces longest
        if len(list[i]) > len(longest):
            longest = list[i]
    return shortest,longest
        
        

#main section

strings = ["aaaa","a","aaa", "aaaaaaaaaaaa","aaaaaaaa","aa"]

print(shortestLongest(strings))
