package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PersonSaver {

    public static void savePerson(Person p){
        savePerson(p, new File("Demo"));
    }

    public static void savePerson(Person p, File f){

        try {
            FileWriter writer = new FileWriter(f, true);
            String s = "\n" +
                    "{\n" +
                    "\tName = " + p.getName() + "\n" +
                    "\tAge = "  + p.getAge()  + "\n" +
                    "\tNat = "  + p.getNat()  + "\n" +
                    "}\n";
            writer.append(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
