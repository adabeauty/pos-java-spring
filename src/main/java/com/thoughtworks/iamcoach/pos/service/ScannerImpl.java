package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.util.ReadFileUlti;

import java.util.ArrayList;

public class ScannerImpl implements Scanner {
    private String fileName;
    public ScannerImpl(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> getInputs(){
        return ReadFileUlti.readFile(fileName);
    }
}
