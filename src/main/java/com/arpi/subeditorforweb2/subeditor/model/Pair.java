package com.arpi.subeditorforweb2.subeditor.model;

public class Pair<DATATYPE> {
    private DATATYPE first;
    private DATATYPE second;

    public DATATYPE getFirst() {
        return first;
    }

    public void setFirst(DATATYPE first) {
        this.first = first;
    }

    public DATATYPE getSecond() {
        return second;
    }

    public void setSecond(DATATYPE second) {
        this.second = second;
    }
}
