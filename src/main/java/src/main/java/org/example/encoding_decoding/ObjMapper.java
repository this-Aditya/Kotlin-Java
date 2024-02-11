package org.example.encoding_decoding;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class ObjMapper {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        serializeJava(mapper);
        deserializeJava(mapper);
    }

    private static void deserializeJava(ObjectMapper mapper) {
        String jsonString = "{\"d_name\":\"John\",\"d_age\":30}";
        try {
            // Deserialize JSON string to Java object
            Person person = mapper.readValue(jsonString, Person.class);
            System.out.println("Person: " + person);
//            System.out.println("Age: " + person.getAge());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    private static void serializeJava(ObjectMapper mapper) {
        Person p = new Person("Aditya", 21);
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(jsonString);
    }


}

class Person implements Serializable {
    String name;
    int age;

    @JsonCreator
    public Person(@JsonProperty("d_name") String name, @JsonProperty("d_age") int age) {
        this.name = name;
        this.age = age;
    }

    @JsonProperty("s_name")
    public String getName() {
        return name;
    }

    @JsonProperty("s_age")
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
