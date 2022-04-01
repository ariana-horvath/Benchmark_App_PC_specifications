#include "stdlib.h"
#include "time.h"
#include <windows.h>
#include <stdio.h>
#include <fstream>
#include <iostream>
#include "pbPlots.hpp"
#include "supportLib.hpp"

#define MAX_LEN 1000001

using namespace std;

ifstream input("randomText2.txt");
ofstream output("multithreadTest.txt");

unsigned long long *partialCount;
char text[MAX_LEN];

typedef struct MyData {
	unsigned int id;
	unsigned long start;
	unsigned long end;
} MY_DATA, * MY_DATA_PTR;

DWORD WINAPI MyThreadFunction(LPVOID parameter)
{
	MY_DATA_PTR pDataArray;
	pDataArray = (MY_DATA_PTR)parameter;

	int count = 0;

	for (int i = pDataArray->start; i <= pDataArray->end; i++)
	{
		if (text[i] == 'a' || text[i] == 'e' || text[i] == 'i' || text[i] == 'o' || text[i] == 'u' ||
			text[i] == 'A' || text[i] == 'E' || text[i] == 'I' || text[i] == 'O' || text[i] == 'U')
			count++;
	}

	partialCount[pDataArray->id] = count;

	return 0;
}

int main(int argc, char* argv[])
{
	unsigned long nbThreads;
	unsigned long i;
	HANDLE* threadsArray;
	DWORD* threadsIDs;
	MY_DATA_PTR* pDataArray;

	int nbRepetitions = 1000;
	int intermediaryResults[1000];

	RGBABitmapImageReference* imageRef = CreateRGBABitmapImageReference();
	vector<double> xAxis;
	vector<double> yAxis;
	string pngName = "plot";

	if (argc != 2)
	{
		nbThreads = 8;
	}
	else
	{
		nbThreads = atol(argv[1]);
	}

	cout << nbThreads;

	pngName += nbThreads + '0';
	pngName += ".png";

	//read text
	input.getline(text, MAX_LEN);

	int textLen = strlen(text);
	int len = textLen / nbThreads;

	threadsArray = new HANDLE[nbThreads];
	threadsIDs = new DWORD[nbThreads];
	pDataArray = new MY_DATA_PTR[nbThreads];
	partialCount = new unsigned long long[nbThreads];
	int count = 0;

	clock_t executionTime = 0;

	for (int j = 0; j < nbRepetitions; j++)
	{
		xAxis.push_back(j + 1);
		clock_t start = clock();

		count = 0;
		for (i = 0; i < nbThreads; i++)
		{

			pDataArray[i] = (MY_DATA_PTR)HeapAlloc(GetProcessHeap(), HEAP_ZERO_MEMORY, sizeof(MY_DATA));

			pDataArray[i]->id = i;
			pDataArray[i]->start = i * len + 1;
			pDataArray[i]->end = (i + 1) * len;

			if (i == nbThreads - 1)
				pDataArray[i]->end += textLen % nbThreads;

			threadsArray[i] = CreateThread(NULL, 0, MyThreadFunction, pDataArray[i], 0, &threadsIDs[i]);
		}

		WaitForMultipleObjects(nbThreads, threadsArray, TRUE, INFINITE);
		for (int i = 0; i < nbThreads; i++)
		{
			count += partialCount[i];
			CloseHandle(threadsArray[i]);
			if (pDataArray[i] != NULL)
			{
				HeapFree(GetProcessHeap(), 0, pDataArray[i]);
				pDataArray[i] = NULL;
			}
		}

		clock_t end = clock();
		intermediaryResults[j] = end - start;
		yAxis.push_back(intermediaryResults[j]);

		executionTime += intermediaryResults[j];
	}

	executionTime /= nbRepetitions;

	output << executionTime;

	delete[] threadsArray;
	delete[] threadsIDs;
	delete[] pDataArray;

	DrawScatterPlot(imageRef, 3000, 1600, &xAxis, &yAxis);

	vector<double>* pngData = ConvertToPNG(imageRef->image);
	WriteToFile(pngData, pngName);
	DeleteImage(imageRef->image);
	return 0;
}

