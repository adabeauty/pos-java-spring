package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.util.ReadFileUlti;

import java.util.ArrayList;

public class Scanner {
    public ArrayList<String> getInputs(){
        return ReadFileUlti.readFile("cart.txt");
    }
}
