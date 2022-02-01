# A graph, G, is represented as an ordered tuple (V,S), where
# V is an alphabetized list of the vertices of G (as strings),
# and S is a dictionary that provides, for each v in V, an
# alphabetized list S[v] of the neighboring vertices of v in G

# global clock and dictionary variables
clock = 1
pre = {}
post = {}
visited = {}

# returns an alphabetized list of the vertices of G


def vertices(G):
    return G[0]

# returns an alphabetized list of the neighboring vertices of v in G


def successors(v, G):
    return G[1][v]

# performs depth-first search on the graph G


def dfs(G):
    for v in G[0]:
        visited[v] = False

    for v in G[0]:
        if visited[v] == False:
            explore(v, G)

# previsits vertex v, updates clock and pre accordingly


def previsit(v):
    global clock
    pre[v] = clock
    clock += 1

# postvisits vertex v, updates clock and post accordingly


def postvisit(v):
    global clock
    post[v] = clock
    clock += 1

# recursively explores the set of vertices of G that are
# connected to v via a path in G


def explore(v, G):
    S = G[1]
    visited[v] = True
    previsit(v)
    for u in S[v]:
        if not visited[u]:
            explore(u, G)
    postvisit(v)
    print(v, ": ", "pre: ", pre[v], "\tpost: ", post[v])


V = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]

S = {
    "A": ["C"],
    "B": ["C"],
    "C": ["A", "B", "D"],
    "D": ["C", "E", "J"],
    "E": ["D", "F", "G"],
    "F": ["E"],
    "G": ["E"],
    "H": ["J"],
    "I": ["J"],
    "J": ["D", "H", "I"]
}

G = (V, S)

dfs(G)
