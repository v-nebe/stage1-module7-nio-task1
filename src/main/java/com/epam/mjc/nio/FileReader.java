package com.epam.mjc.nio;

import java.nio.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


public class FileReader {

    public Profile getDataFromFile(File file) throws IOException {
        Path filePath = Paths.get(file.getPath());
        BufferedReader reader = Files.newBufferedReader(filePath);

        String name = null;
        int age = 0;
        String email = null;
        Long phone = null;

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Name:")) {
                name = line.substring(line.indexOf(":") + 1).trim();
            } else if (line.startsWith("Age:")) {
                age = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
            } else if (line.startsWith("Email:")) {
                email = line.substring(line.indexOf(":") + 1).trim();
            } else if (line.startsWith("Phone:")) {
                phone = Long.parseLong(line.substring(line.indexOf(":") + 1).trim());
            }
        }

        reader.close();
        return new Profile(name, age, email, phone);
    }
}

