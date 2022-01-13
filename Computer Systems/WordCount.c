#include <stdio.h>

int main()
{
    // create a variable for the character count, the word count, and the line count
    int c, w, l;

    // create a variable for getchar()
    int temp = getchar();

    // another temperary variable to represent if the characters are in a word
    int word = 0;

    // through the while loop get each character from the input
    while (temp != EOF)
    {
        // add 1 to the character count for each iteration
        c++;

        // if the character is a tab then add a line
        if (temp == '\n')
            l++;

        // if character is not a letter then we are not in a word
        if (temp < 33 || temp > 126)
            word = 0;

        // otherwise we are in a word and should add one to the word count
        else if (word == 0)
        {
            word = 1;
            w++;
        }
    }

    printf("Your text has %d chars, %d words, and %d lines.", c, w, l);
}