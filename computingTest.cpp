#include<iostream>
#include<stdlib.h>
#include<math.h>
#include<string.h>
#include<fstream>
#include "time.h"
#include "pbPlots.hpp"
#include "supportLib.hpp"

#define MAX_LEN 10001

using namespace std;

ifstream input("randomText.txt");
ofstream output("computingTest.txt");

int x, y, n, totient, i, flag;
long int e[MAX_LEN]; //public key exponent used for encription
long int d[MAX_LEN]; //multiplicative inverse of e in mod ø(n)
long int temp[MAX_LEN], j;
char en[MAX_LEN];
char message[MAX_LEN];

int prime(long int number)
{
    int i;
    j = sqrt(number);
    for (i = 2; i <= j; i++)
    {
        if (number % i == 0)
            return 0;
    }
    return 1;
}

long int choose_d(long int number)
{
    long int k = 1;
    while (1)
    {
        k = k + totient;
        if (k % number == 0)
            return(k / number);
    }
}

int main()
{
    int nbRepetitions = 10;
    int intermediaryResults[10];

    RGBABitmapImageReference* imageRef = CreateRGBABitmapImageReference();
    vector<double> xAxis;
    vector<double> yAxis;

    //first prime number
    input >> x;
   
    //checking whether is prime or not
    if (prime(x) == 0)
    {
        output << "\nINVALID INPUT\n";
        exit(0);
    }
    
    //second prime number
    input >> y;
  
    if (prime(y) == 0 || x == y)
    {
        output << "\nINVALID INPUT\n";
        exit(0);
    }

    //read message to encrypt
    input.getline(message, MAX_LEN);

    int messageLength = strlen(message);

    clock_t executionTime = 0;

    for (int z = 0; z < nbRepetitions; z++)
    {
        xAxis.push_back(z+1);
        clock_t start = clock();
        n = x * y;
        totient = (x - 1) * (y - 1);

        //encryption key
        long int k;
        k = 0;

        for (i = 2; i < totient; i++)
        {
            if (totient % i == 0)
                continue;

            if (prime(i) == 1 && i != x && i != y)
            {
                e[k] = i;
                flag = choose_d(e[k]);
                if (flag > 0)
                {
                    d[k] = flag;
                    k++;
                }
                if (k == messageLength)
                    break;
            }
        }

        //encrypt
        long int pt, ct, key = e[0];
        i = 0;

        while (i != messageLength)
        {
            pt = message[i];
            pt = pt - 96;
            k = 1;
            for (j = 0; j < key; j++)
            {
                k = k * pt;
                k = k % n;
            }
            temp[i] = k;
            ct = k + 96;
            en[i] = ct;
            i++;
        }
        en[i] = '\0';

        //decrypt
        key = d[0];
        i = 0;
        while (en[i] != '\0')
        {
            ct = temp[i];
            k = 1;
            for (j = 0; j < key; j++)
            {
                k = k * ct;
                k = k % n;
            }
            pt = k + 96;
            message[i] = pt;
            i++;
        }
        message[i] = '\0';

        clock_t end = clock();
        intermediaryResults[z] = end - start;
        yAxis.push_back(intermediaryResults[z]);

        executionTime += intermediaryResults[z];
    }

    executionTime /= nbRepetitions;

    output << executionTime;
    
    DrawScatterPlot(imageRef, 600, 400, &xAxis, &yAxis);

    vector<double>* pngData = ConvertToPNG(imageRef->image);
    WriteToFile(pngData, "plot-computing.png");
    DeleteImage(imageRef->image);
    
    return 0;
}



