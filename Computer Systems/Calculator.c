#include <stdio.h>
#include <stdbool.h>

bool takesNoArgs(char op);
double processOp(double amt, char op, double val);
double processPlus(double amt, double val);
double processMinus(double amt, double val);
double processTimes(double amt, double val);
double processDivide(double amt, double val);
double processPrint(double amt);
double processClear();


int main()
{
    double amt = 0.0;
    char op;
    double val;

    printf("CS 2271 Calculator \n");

    int d = getchar();

    while(true)
    {
        while (d != EOF)
        {
            scanf("%lf",&val);
            if (d < 48 || d > 57)
                op = d;

            amt = processOp(amt, op, val);
        }
    }

    printf("Thank you and goodbye! \n");

}

bool takesNoArgs(char op)
{
    return (op == 'C' || op == '=');
}

double processOp(double amt, char op, double val)
{
        if (op == '+')
            return processPlus(amt, val);
        else if (op == '-')
            return processMinus(amt, val);
        else if (op == '*')
            return processTimes(amt, val);
        else if (op == '/')
            return processDivide(amt, val);
        else if (op == '=')
            return processPrint(amt);
        else if (op == 'C')
            return processClear();
        else 
        {
            printf("Bad Operator \n");
            return amt;
        }
}

double processPlus(double amt, double val) 
{
    return amt + val;
}

double processMinus(double amt, double val) 
{
    return amt - val;
}

double processTimes(double amt, double val) 
{
    return amt * val;
}

double processDivide(double amt, double val) 
{
    return amt / val;
}
    
double processPrint(double amt) 
{
    printf("%f",amt);
    return amt;
}
    
double processClear() 
{
    return 0;
}