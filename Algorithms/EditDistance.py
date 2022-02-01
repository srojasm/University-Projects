def dpEditDistance(a, b):
    n = len(a)
    m = len(b)

    D = [[0 for j in range(0, m+1)] for i in range(0, n+1)]

    for j in range(0, m+1):
        D[0][j] = j

    for i in range(0, n+1):
        D[i][0] = i

    for i in range(1, n+1):
        for j in range(1, m+1):
            if a[i-1] == b[j-1]:
                D[i][j] = D[i-1][j-1]
            else:
                D[i][j] = 1 + min(D[i-1][j], D[i-1][j-1], D[i][j-1])

    for p in range(len(D)):
        print("\n")
        for q in range(len(D[p])):
            print(D[p][q], end=' ')

    totalEdit = D[n][m]
    print("\n")

    while n > 0 and m > 0:
        if a[n-1] == b[m-1]:
            print(n, "", m, "match ",  a[n-1])
            n -= 1
            m -= 1
        else:
            if D[n][m] == (D[n-1][m-1]+1):
                print(n, "", m, "subst ", a[n-1], "->", b[m-1])
                n -= 1
                m -= 1
            if D[n][m] == (D[n][m-1]+1):
                print(n, "", m, "insert", b[m-1])
                m -= 1
            if D[n][m] == (D[n-1][m]+1):
                print(n, "", m, "delete ",  a[n-1])
                n -= 1

    return totalEdit
