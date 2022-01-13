# Sofia Rojas
# PS6
# Maximum Consecutive Subsequence Sum Algorithm

def MCSS(a):
    n = len(a)

    if n == 1:
        return a[0], 0, 0
    if n == 0:
        return 0, 0, 0

    lower_S, L_i1, L_i2 = MCSS(a[0:(n//2)])
    upper_S, U_i1, U_i2 = MCSS(a[(n//2):n])

    U_i1 = U_i1 + (n//2)
    U_i2 = U_i2 + (n//2)

    S, i1, i2 = Glue(a, lower_S, L_i1, L_i2, upper_S, U_i1, U_i2)
    return S, i1, i2


def Glue(a, lower_S, L_i1, L_i2, upper_S, U_i1, U_i2):
    S = lower_S + upper_S
    for j in range(L_i2+1, U_i1):
        S += a[j]

    if S > lower_S and S > upper_S:
        return S, L_i1, U_i2
    elif lower_S < upper_S:
        return upper_S, U_i1, U_i2
    else:
        return lower_S, L_i1, L_i2


test = [0, 38, 48, 73, 47, 3, -32, -18, 74, -28, 81, 0, 89, 90, -24]

print(MCSS(test))
