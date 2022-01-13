# We can import code from scipy to calculate binomial coefficients and
# factorials.
def binomialCoeff(n, k):

    if k > n:
        return 0
    if k == 0 or k == n:
        return 1

    # Recursive Call
    # binom(n, k) computes "n choose k":
    return binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k)


def recur_factorial(n):
    if n == 1:
        return n
    elif n < 1:
        return ("NA")
    else:
        return n*recur_factorial(n-1)
