package com.ex.data;

import java.util.Map;

public class Opportunity {
    private long originalEventTime;
    private int maxDuration;
    private Map<String, Zone> zones;
    private Map<String, String[]> positionUrlSegments;
    private int insertionRate;

    public long getOriginalEventTime() {
        return originalEventTime;
    }

    public void setOriginalEventTime(long originalEventTime) {
        this.originalEventTime = originalEventTime;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Map<String, Zone> getZones() {
        return zones;
    }

    public void setZones(Map<String, Zone> zones) {
        this.zones = zones;
    }

    public Map<String, String[]> getPositionUrlSegments() {
        return positionUrlSegments;
    }

    public void setPositionUrlSegments(Map<String, String[]> positionUrlSegments) {
        this.positionUrlSegments = positionUrlSegments;
    }

    public int getInsertionRate() {
        return insertionRate;
    }

    public void setInsertionRate(int insertionRate) {
        this.insertionRate = insertionRate;
    }
}