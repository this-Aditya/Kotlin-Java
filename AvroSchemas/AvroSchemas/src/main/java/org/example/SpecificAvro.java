package org.example;

import example.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class SpecificAvro {
    public static void main(String[] args) {
        User.Builder firstBuilder = User.newBuilder()
                .setName("Abhay")
//                .setFavouriteColor(null)
                .setFavouriteNumber(1);

        User abhay = firstBuilder.build();

        User aditi = new User("Aditi", 2, "Green");
        User aditya = new User("Aditya", 3, "Sky-Blue");

        serializeUsers(abhay, aditi, aditya);
        deserializeUsers(new File("src/main/java/org/files/users.avro"));
    }

    /**
     * Serializing users to the disk!!
     */
    private static void serializeUsers(User abhay, User aditi, User aditya) {
        //
        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<>(userDatumWriter);
        try {
            dataFileWriter.create(abhay.getSchema(), new File("src/main/java/org/files/users.avro"));
            dataFileWriter.append(abhay);
            dataFileWriter.append(aditi);
            dataFileWriter.append(aditya);
            dataFileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deserializeUsers(File file) {
        DatumReader<User> userDatumReader = new SpecificDatumReader<>(User.class);
        try(DataFileReader<User> dataFileReader = new DataFileReader<>(file, userDatumReader)) {
            User user = null;
            while (dataFileReader.hasNext()) {
                user = dataFileReader.next();
                System.out.println(user);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
