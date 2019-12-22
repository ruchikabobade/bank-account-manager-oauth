package com.hackerearth.esri.bank.model;

public class RequestParams {

    private int start = 0;
    private int size = 0;

    public void setStart(int start) {
        this.start = start;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public int getSize() {
        return size;
    }
}
