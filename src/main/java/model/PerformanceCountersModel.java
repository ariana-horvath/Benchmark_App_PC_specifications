package model;

import java.util.List;

public class PerformanceCountersModel {
    private String nbProcessors;
    private String pageSize;
    private String processorType;
    private String processorTypeStr;
    private String processorArchitecture;
    private String minAppAddr;
    private String maxAppAddr;
    private String ramMemorySize;
    private List<String> currentFrequencies;
    private List<String> maxFrequencies;

    public PerformanceCountersModel(String nbProcessors, String pageSize, String processorType, String processorTypeStr,
                                    String processorArchitecture, String minAppAddr, String maxAppAddr, String ramMemorySize,
                                    List<String> currentFrequencies, List<String> maxFrequencies) {
        this.nbProcessors = nbProcessors;
        this.pageSize = pageSize;
        this.processorType = processorType;
        this.processorTypeStr = processorTypeStr;
        this.processorArchitecture = processorArchitecture;
        this.minAppAddr = minAppAddr;
        this.maxAppAddr = maxAppAddr;
        this.ramMemorySize = ramMemorySize;
        this.currentFrequencies = currentFrequencies;
        this.maxFrequencies = maxFrequencies;
    }

    public String getNbProcessors() {
        return nbProcessors;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getProcessorType() {
        return processorType;
    }

    public String getProcessorTypeStr() {
        return processorTypeStr;
    }

    public String getMinAppAddr() {
        return minAppAddr;
    }

    public String getMaxAppAddr() {
        return maxAppAddr;
    }

    public String getRamMemorySize() {
        return ramMemorySize;
    }

    public List<String> getCurrentFrequencies() {
        return currentFrequencies;
    }

    public List<String> getMaxFrequencies() {
        return maxFrequencies;
    }

    public String getProcessorArchitecture() {
        return processorArchitecture;
    }
}
