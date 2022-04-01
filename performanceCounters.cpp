#include <windows.h>
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <sysinfoapi.h>
#include <NTstatus.h>
#include <Powrprof.h>
#pragma comment(lib, "user32.lib")
#pragma comment(lib, "Powrprof.lib")
using namespace std;

ofstream output("performanceCountersOutput.txt"); //open the output file

typedef struct _PROCESSOR_POWER_INFORMATION {
    ULONG  Number;
    ULONG  MaxMhz;
    ULONG  CurrentMhz;
    ULONG  MhzLimit;
    ULONG  MaxIdleState;
    ULONG  CurrentIdleState;
} PROCESSOR_POWER_INFORMATION, * PPROCESSOR_POWER_INFORMATION;

void main()
{
    SYSTEM_INFO siSysInfo, sysInfo;
    unsigned long long physicalMemory = 0;

    // Copy the hardware information to the SYSTEM_INFO. 
    GetSystemInfo(&siSysInfo);
   
    GetPhysicallyInstalledSystemMemory(&physicalMemory);
    
    //Display the contents of the SYSTEM_INFO structure. 

    output << siSysInfo.dwNumberOfProcessors << ',';
   
    output << siSysInfo.dwPageSize << ',';
    
    output << siSysInfo.dwProcessorType << ',';
    
    switch (siSysInfo.dwProcessorType)
    {
    case 386:
        output << "PROCESSOR_INTEL_386" << ',';
        break;
    case 486:
        output << "PROCESSOR_INTEL_486" << ',';
        break;
    case 586:
        output << "PROCESSOR_INTEL_CORE" << ',';
        break;
    case 2200:
        output << "PROCESSOR_INTEL_IA64" << ',';
        break;
    case 8664:
        output << "PROCESSOR_AMD_X8664" << ',';
        break;
    default:
        output << "Other type of processor" << ',';
    }

    switch (siSysInfo.wProcessorArchitecture)
    {
        case PROCESSOR_ARCHITECTURE_AMD64:
            output << "x64(AMD or Intel)" << ",";
            break;
        case PROCESSOR_ARCHITECTURE_ARM:
            output << "ARM" << ",";
            break;
        case PROCESSOR_ARCHITECTURE_ARM64:
            output << "AMR64" << ",";
            break;
        case PROCESSOR_ARCHITECTURE_IA64:
            output << "Intel Itanium-based" << ",";
            break;
        case PROCESSOR_ARCHITECTURE_INTEL:
            output << "x86" << ",";
            break;
        case PROCESSOR_ARCHITECTURE_UNKNOWN:
            output << "Unknown achitecture" << ",";
            break;
        default:
            output << "Other architecture" << ",";
            break;
    }

    output << siSysInfo.lpMinimumApplicationAddress << ',';
 
    output << siSysInfo.lpMaximumApplicationAddress << ',';

    output << physicalMemory << ',';

    const int size = siSysInfo.dwNumberOfProcessors * sizeof(PROCESSOR_POWER_INFORMATION);
    LPBYTE pBuffer = new BYTE[size];
    
    if (CallNtPowerInformation(ProcessorInformation, NULL, 0, pBuffer, size) == STATUS_SUCCESS)
    {
        // list each processor frequency 
        PPROCESSOR_POWER_INFORMATION ppi = (PPROCESSOR_POWER_INFORMATION)pBuffer;
        for (DWORD nIndex = 0; nIndex < siSysInfo.dwNumberOfProcessors; nIndex++)
        {
            output << ppi->CurrentMhz << ',' << ppi->MaxMhz << ',';
            ppi++;
        }
    }
    else
    {
        cout << "CallNtPowerInformation failed." << '\n';
    }

    delete[]pBuffer;
    output.close();
}