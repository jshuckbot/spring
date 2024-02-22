package ru.gb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Lesson 1
 */

public class App {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", "Gorutskii", 32);
        Person person2 = new Person("Yaroslav", "Pushnin", 19);
        
        System.out.println("Equals person: " + person1.equals(person2));
        System.out.println("Person: " + person1);
        
        Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new PersonSerializer()).create();
        String json = gson.toJson(person1);
        System.out.println(json);
        
        Person fromJsonPerson = new Gson().fromJson(json, Person.class);
        System.out.println(fromJsonPerson);
    }
}

