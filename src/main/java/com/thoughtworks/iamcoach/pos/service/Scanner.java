package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.util.ReadFileUlti;

import java.util.ArrayList;

public class Scanner {
    private String fileName;
    public Scanner(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> getInputs(){
        return ReadFileUlti.readFile(fileName);
    }
}
