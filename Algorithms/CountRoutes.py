# count routes to (n, m) where m is the west-east distance from start to destination and n is the north-south distance from start to destination

def countRoutes(n, m):
    grid = [[0 for i in range(0, n)] for j in range(0, m)]

    for j in range(0, m):
        grid[j][0] = 1

    for i in range(0, n):
        grid[0][i] = 1

    for j in range(1, m):
        for i in range(1, n):
            grid[j][i] = grid[j-1][i] + grid[j][i-1]

    for p in range(len(grid)):
        print("\n")
        for q in range(len(grid[p])):
            print(grid[p][q], end=' ')

    return print("\nTotal routes to destination: ", grid[m-1][n-1])
