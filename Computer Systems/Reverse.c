#include <stdio.h>
#include <ctype.h>
#include <string.h>

int getLine(char *line);
void changeCap(char *line, int size);
void reverseText(char *line, int size);

int main()
{

    // instantiate the array with max size of 80
    char m[80];
    int size = 0;
    printf("Enter the text: \n");
    size = getLine(m);
    printf("\n****************\n");
    changeCap(m, size);
    printf("\n****************\n");
    reverseText(m, size);
    return 0;
}

int getLine(char *line)
{

    // this will be the size of the array
    int s = 0;
    // the index that points to each element of the array
    int index = 0;
    char c;
    // go through the user input character by character and add 1 to s
    // make the element in the array the same as the c that was just read
    // increment c and s by one
    c = getchar();
    while (c != EOF)
    {

        *(line + index) = c;
        index++;
        s++;
        c = getchar();
        if (index == 80)
        {
            break;
        }
    }
    return s;
}

void changeCap(char *line, int size)
{

    // make the first letter capital
    *line = toupper(*line);
    // make your way through the array
    for (int i = 1; i < size; i++)
    {
        // for whichever element that comes after a space and is a letter
        // make that letter uppercase
        if ((*(line + i - 1) == ' ') && (isalpha(*(line + i))))
        {
            *(line + i) = toupper(*(line + i));
        }
    }
    printf("%s \n", line);
}

void reverseText(char *line, int size)
{

    // create a temporary array
    char newLine[size];
    // go through the original array and add the elements into the new array backwards
    for (int i = size - 1; i >= 0; i--)
    {
        newLine[i] = *(line + size - 1 - i);
    }
    // make the original array equal to the new temporary one
    for (int i = 0; i < size; i++)
    {
        *(line + i) = newLine[i];
    }
    printf("%s \n", line);
}
