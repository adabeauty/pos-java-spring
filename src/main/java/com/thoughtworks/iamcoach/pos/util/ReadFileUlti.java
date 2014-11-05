package com.thoughtworks.iamcoach.pos.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class ReadFileUlti {
    public static ArrayList<String> readFile(String fileName){
        ArrayList<String> text = new ArrayList<String>();

        try {
            Path path = FileSystems.getDefault().getPath("src/main/resources/", fileName);
            text = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException ex) {
            System.out.println("fail read file!");
        }

        return text;
    }
}
