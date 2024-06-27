package com.ex.data;

import java.util.List;

public class Records {
    public DownloadIdentifier downloadIdentifier;
    public List<Opportunity> opportunities;
    public int agency;
    public String deviceType;
    public String country;
    public String city;
    public String listenerId;

    public DownloadIdentifier getDownloadIdentifier() {
        return downloadIdentifier;
    }

    public void setDownloadIdentifier(DownloadIdentifier downloadIdentifier) {
        this.downloadIdentifier = downloadIdentifier;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getListenerId() {
        return listenerId;
    }

    public void setListenerId(String listenerId) {
        this.listenerId = listenerId;
    }
}