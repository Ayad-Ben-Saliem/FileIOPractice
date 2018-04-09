package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //saveDemo();
        readDemo();
    }

    public static void saveDemo(){
        PersonSaver saver = new PersonSaver();
        File f = new File("People");

        Person p1 = new Person();
        Person p2 = new Person("Hesham");
        Person p3 = new Person("Ahmed", 13);
        Person p4 = new Person(null, 10, "LY");

        saver.savePerson(p1, f);
        saver.savePerson(p2, f);
        saver.savePerson(p3, f);
        saver.savePerson(p4);
    }

    public static void readDemo(){
        File f1 = new File("People");

        PeopleReader reader = new PeopleReader();
        Person[] persons = reader.readPeople(f1);

        for(Person person : persons){
            System.out.println(person.getName());
        }

    }

}
