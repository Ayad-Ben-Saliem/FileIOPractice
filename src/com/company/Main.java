package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File f = new File("People");

        Person p1 = new Person();
        Person p2 = new Person("Hesham");
        Person p3 = new Person("Ahmed", 13);
        Person p4 = new Person(null, 10, "LY");

        savePerson(p1, f);
        savePerson(p2, f);
        savePerson(p3, f);
        savePerson(p4);
    }

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
