package org.example.avro_first;

import example.avro.User;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.IOException;

public class GenericAvro {
    public static void main(String[] args) {
        try {
            Schema schema = new Schema.Parser().parse(new File("src/main/resources/avro/User.avsc"));
//            System.out.println(schema);

//            Analogus to User class, but it is not specific
            GenericRecord abhay = new GenericData.Record(schema);
            abhay.put("name", "Abhay");
            abhay.put("favourite_number", 1);

            GenericRecord aditi = new GenericData.Record(schema);
            aditi.put("name", "Aditi");
            aditi.put("favourite_number", 2);
            aditi.put("favourite_color", "blue");

            GenericRecord aditya = new GenericData.Record(schema);
            aditya.put("name", "Aditya");
            aditya.put("favourite_number", 3);
            aditya.put("favourite_color", "sky-blue");
//             If we try to set a non-existent field (e.g., user1.put("favorite_animal", "cat")),
//             we'll get an AvroRuntimeException when we run the program.

            serializeGenericUsers(abhay, aditi, aditya);
            deserializeGenericUsers(new File("src/main/java/org/files/generic-users.avro"), abhay.getSchema());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serializeGenericUsers(GenericRecord abhay, GenericRecord aditi, GenericRecord aditya) {
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(abhay.getSchema());
        try (DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter)) {
            dataFileWriter.create(abhay.getSchema(), new File("src/main/java/org/files/generic-users.avro"));
            dataFileWriter.append(abhay);
            dataFileWriter.append(aditi);
            dataFileWriter.append(aditya);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeGenericUsers(File path, Schema schema) {
        DatumReader<User> datumReader = new SpecificDatumReader<>(schema);
        try(DataFileReader<User> dataFileReader = new DataFileReader<>(path, datumReader)) {
            GenericRecord user = null;
            while (dataFileReader.hasNext()) {
                user = dataFileReader.next();
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
