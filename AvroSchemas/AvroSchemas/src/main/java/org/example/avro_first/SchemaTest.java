package org.example.avro_first;


import example.avro.User;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.specific.SpecificRecord;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class SchemaTest {
    public static void main(String[] args) {
//        Schema schema = Schema.create(Schema.Type.STRING);
//        testSchema();
        findSchemaUtils();
    }

    static void findSchemaUtils() {
        try {
            Class<User> schemaClass = (Class<User>) Class.forName("example.avro.User");
            Schema sch = (Schema) schemaClass
                    .getMethod("getClassSchema").invoke(null);
            System.out.println(sch);
//            System.out.println(User.getClassSchema());
            GenericRecord o = (User) SpecificData.newInstance(schemaClass, sch);
            System.out.println(o);
            o.put("name", "Aditya");
            System.out.println(o);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    static void testSchema() {
        try {
            Schema schema = new Schema.Parser().parse(new File("src/main/resources/avro/User.avsc"));
            Schema.Field field = schema.getFields().get(1);
            System.out.println(field);
            System.out.println(field.schema());
            System.out.println(field.schema().getType());
            System.out.println(field.schema().getName());
            System.out.println(schema.getFields());
            System.out.println(schema.getType());
            User user = new User();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
