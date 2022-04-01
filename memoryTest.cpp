#include <stdio.h>
#include <fstream>
#include <iostream>
#include "time.h"
#include "pbPlots.hpp"
#include "supportLib.hpp"

#define MAX_LEN 1000000

using namespace std;

ofstream output("memoryTest.txt");

int main()
{
	int* numbers;
	unsigned long long sum = 0;
	int nbRepetitions = 1000;
	int intermediaryResults[1000];

	RGBABitmapImageReference* imageRef = CreateRGBABitmapImageReference();
	vector<double> xAxis;
	vector<double> yAxis;

	clock_t executionTime = 0;

	for (int j = 0; j < nbRepetitions; j++)
	{
		xAxis.push_back(j + 1);
		clock_t start = clock();

		//allocating the memory
		numbers = new int[MAX_LEN];
		
		//writing the memory
		for (int i = 0; i < MAX_LEN; i++)
			numbers[i] = i;
		
		//using the data
		for (int i = 0; i < MAX_LEN; i++)
			sum += numbers[i];
		
		//deallocating the memory
		delete[] numbers;

		clock_t end = clock();
		intermediaryResults[j] = end - start;
		yAxis.push_back(intermediaryResults[j]);

		executionTime += intermediaryResults[j];
	}

	executionTime /= nbRepetitions;

	output << executionTime;
	cout << sum;

	DrawScatterPlot(imageRef, 1800, 1200, &xAxis, &yAxis);

	vector<double>* pngData = ConvertToPNG(imageRef->image);
	WriteToFile(pngData, "plot-memory.png");
	DeleteImage(imageRef->image);

	return 0;
}