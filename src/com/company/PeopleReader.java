package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class PeopleReader {

    public Person[] readPeople(File f){

        Person[] people = null;

        try {
            Scanner scanner = new Scanner(f);

            boolean personFound = false;
            String personInfo = "";
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if(personFound){
                    if(line.startsWith("}")){
                        personFound = false;
                        if(people == null)
                            people = new Person[1];
                        else {
                            Person[] temp = people;
                            people = new Person[people.length + 1];
                            for (int i = 0; i <temp.length ; i++) {
                                people[i] = temp[i];
                            }
                        }
                        people[people.length-1] = buildPerson(personInfo);
                        personInfo = "";
                    }else {
                        personInfo += line + "\n";
                    }
                }else {
                    if (line.startsWith("{")){
                        personFound = true;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return people;
    }

    public Person buildPerson(String personInfo){

        Person result = new Person();

        personInfo = personInfo.replaceAll("\t", "");
        personInfo = personInfo.replaceAll(" ", "");

        Scanner scanner = new Scanner(personInfo);
        while (scanner.hasNext()){
            String s = scanner.nextLine();

            if(s.startsWith("Name=")){
                s = s.replaceAll("Name=", "");
                result.setName(s);
            }else if(s.startsWith("Age=")){
                s = s.replaceAll("Age=", "");
                result.setAge(Integer.parseInt(s));
            }else if(s.startsWith("Nat=")){
                s = s.replaceAll("Nat=", "");
                result.setNat(s);
            }
        }

        return result;
    }

}
