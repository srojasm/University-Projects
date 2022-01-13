#include <stdio.h>

int main()
{
    // create the variables
    int m, d, i, v;

    // have user input the number of days in the month and save it in the variable m
    printf("Enter the number of days in the month: ");
    scanf("%d", &m);

    // have user input which day of the week the first lands on and save it in the variable d
    printf("Enter starting day of the week (1=Sun, 7=Sat): ");
    scanf("%d", &d);

    // for the first line of the calender put empty spaces for every day of the week
    // except for the first of the month
    v = 1;
    for (v; v < d; v++)
        printf("\t");

    // print the days of the month
    i = 1;
    for (i = 1; i <= m; i++)
        // when there have been 7 days in the week, skip a line
        if ((i + d - 1) % 7 == 0)
            printf("%d \t \n", i);
        else
            printf("%d \t", i);

    printf("\n:");
    return 0;
}
