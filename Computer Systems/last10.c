#include <stdio.h>

int main()
{

    int A[10], *current, k, num;
    current = A;
    k = 0;
    num = 0;

    while (k < 10)
    {
        scanf("%d", &num);
        if (num == 0)
        {
            break;
        }
        else
        {
            *current = num;
            current++;
            k++;
            if (k == 10)
            {
                current = &A[0];
                k = 0;
            }
        }
    }

    current = &A[0];
    for (int i = 0; i < 10; i++)
    {
        if (current == 0)
        {
            continue;
        }
        printf("%d \n", *current);
        current++;
    }
    return 0;
}
