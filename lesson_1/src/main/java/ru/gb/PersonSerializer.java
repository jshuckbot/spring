package ru.gb;

import com.google.gson.*;

import java.lang.reflect.Type;

public class PersonSerializer implements JsonSerializer<Person> {

    @Override
    public JsonElement serialize(Person person, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.add("firstName", new JsonPrimitive(person.getFirstName()));
        result.add("lastName", new JsonPrimitive(person.getLastName()));
        result.add("age", new JsonPrimitive(person.getAge()));
        
        return result;
    }
}

