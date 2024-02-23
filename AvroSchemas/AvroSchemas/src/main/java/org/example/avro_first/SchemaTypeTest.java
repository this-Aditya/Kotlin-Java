package org.example.avro_first;

import org.apache.avro.Schema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SchemaTypeTest {

    public static void main(String[] args) {
        Schema schema = null;
        try {
            schema = Schema.parse(new File("src/main/resources/avro/User.avsc"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert schema != null;
        doSomeOperations(schema);

    }

    private static void doSomeOperations(Schema schema) {
        List<Schema.Field> fields = schema.getFields();
        for (Schema.Field field : fields) {
            System.out.println(field);
        }
    }

}
