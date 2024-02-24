package org.example.avro_second.generic;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.person.info.Person;

import java.io.File;
import java.io.IOException;

public class SpecificRecordExample {
    public static void main(String[] args) {
        Person.Builder personBuilder = Person.newBuilder()
                .setName("Aditya")
                .setAge(21)
                .setBikeCompany("Royal Enfield")
                .setBikeInfo("Classic 350 Chrome Bronze")
                .setLaptop("Apple MacBook M3 pro 14 inches")
                .setPhone("Samsung Galaxy Z flip series");

        Person person = personBuilder.build();

        // Writing to the file
        DatumWriter<Person> personDatumWriter = new SpecificDatumWriter<>(Person.class);
        try(DataFileWriter<Person> dataWriter = new DataFileWriter<>(personDatumWriter)) {
            dataWriter.create(person.getSchema(), new File("src/main/resources/files/specific-person.avro"));
            dataWriter.append(person);
            System.out.println("Successfully written data to file");
        } catch (IOException e) {
            System.out.println("Error while writing data to file");
            throw new RuntimeException(e);
        }

        // Reading from file
        DatumReader<Person> personDatumReader = new SpecificDatumReader<>();
        try(DataFileReader<Person> personFileReader = new DataFileReader<>(new File("src/main/resources/files/specific-person.avro"), personDatumReader)) {
            Person readedPerson = personFileReader.next();
            System.out.println("Successfully readed the record");
            System.out.println(readedPerson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
