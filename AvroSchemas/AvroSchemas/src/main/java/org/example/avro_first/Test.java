package org.example.avro_first;

import example.avro.User;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificData;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
//        User aditya = new User("Aditya", 3, "Sky-Blue");
//        Schema schema = aditya.getSchema();
//        System.out.println(schema);

        Schema schema = new Schema.Parser().parse(new File("src/main/resources/avro/User.avsc"));
//        testGenericSchemas(schema);
//        testUtils(schema);
        newSpecificInstance(schema);
//          testArray();
//        testClass();
    }

    private static void testClass() {
        try {
            Class<?> test = Class.forName("org.example.avro_first.Test");
            System.out.println(test);
            Test test1 = new Test();
            Method testArray = test.getMethod("testArray");
            System.out.println(testArray);
            testArray.invoke(null);

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void testArray() {
        System.out.println("Invoked");
        String[] strs = new String[7];
        strs[0] = "Hello";
        strs[1] = "Hello";
        strs[2] = "Hello";
        strs[3] = "Hello";
        System.out.println(Arrays.toString(strs));
        System.out.println(Arrays.toString(Arrays.copyOf(strs, strs.length)));
    }

    private static void newSpecificInstance(Schema schema) {
        User o = (User) SpecificData.newInstance(User.class, schema);
        System.out.println(o);
//        System.out.println(o.getSchema());;
//        Class<String> cls  = (Class<String>) "ell0".getClass();
//        System.out.println("hgdasv".getClass());
    }

    private static void testUtils(Schema schema) {
//        System.out.println(
        System.out.println(schema.getType());
        for (Schema.Field field : schema.getFields()) {
            System.out.println(field.schema().getType());
        }

//        ;);
    }

    static void testGenericSchemas(Schema schema) {
        GenericRecord aditya = new GenericData.Record(schema);
        aditya.put("name", "Aditya");
        aditya.put("favourite_number", 3);
        aditya.put("favourite_color", "sky-blue");
        System.out.println(aditya.getSchema());
    }
}
