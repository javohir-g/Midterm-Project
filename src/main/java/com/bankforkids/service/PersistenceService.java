package com.bankforkids.service;

import com.bankforkids.model.Child;
import java.io.*;

public class PersistenceService {
    private static final String DATA_DIR = "resources/data/";

    public void saveChild(Child child) {
        try {
            File dir = new File(DATA_DIR);
            if (!dir.exists()) dir.mkdirs();

            FileOutputStream fileOut = new FileOutputStream(DATA_DIR + child.getName() + ".dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(child);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Child loadChild(String name) {
        Child child = null;
        try {
            File file = new File(DATA_DIR + name + ".dat");
            if (!file.exists()) return null;

            FileInputStream fileIn = new FileInputStream(DATA_DIR + name + ".dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            child = (Child) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            // If error, return null to create new
            return null;
        }
        return child;
    }
}
