package org.example.avro_second.generic;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;

import java.io.File;
import java.io.IOException;

public class GenericRecordExample {

    public static void main(String[] args) {
        // step 0: Define the schema
        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse("{\n" +
                "  \"namespace\": \"org.person.info\",\n" +
                "  \"name\": \"Person\",\n" +
                "  \"type\": \"record\",\n" +
                "  \"fields\": [\n" +
                "    { \"name\": \"name\", \"type\": \"string\", \"doc\": \"Name of the person.\" },\n" +
                "    { \"name\": \"age\", \"type\": \"int\", \"doc\": \"Age of the person.\" },\n" +
                "    { \"name\": \"bike_company\", \"type\": [\"null\",\"string\"], \"doc\": \"Name of company of the bike person have, if exists.\" },\n" +
                "    { \"name\": \"bike_info\", \"type\": [\"null\", \"string\"], \"doc\": \"Information about the bike that the person have.\" },\n" +
                "    { \"name\": \"laptop\", \"type\": \"string\", \"doc\": \"Laptop of the person.\" },\n" +
                "    { \"name\": \"phone\", \"type\": \"string\", \"doc\": \"Smartphone of the person.\" },\n" +
                "    { \"name\": \"favourite_place\", \"type\": \"string\", \"doc\": \"Favourite place of the person.\" },\n" +
                "    { \"name\": \"second_favourite_place\", \"type\": \"string\", \"doc\": \"Favourite place of the person.\" }\n" +
                "  ]\n" +
                "}");

        // Step 1: Creating a generic record.
        GenericRecordBuilder personBuilder = new GenericRecordBuilder(schema);
        personBuilder.set("name", "Aditya");
        personBuilder.set("age", 21);
        personBuilder.set("bike_company", "Royal Enfield");
        personBuilder.set("bike_info", "Classic 350 Chrome Bronze");
        personBuilder.set("laptop", "Apple Mac Book M3 pro 14 inches, 48 gb RAM");
        personBuilder.set("phone", "Samsung Galaxy Z flip Series");
        personBuilder.set("favourite_place", "Salasar, Rajasthan");
        personBuilder.set("second_favourite_place", "Kakrighat, Uttarakhand");

        GenericRecord person = personBuilder.build();
        System.out.println(person);

        // Step 2: Writing that generic record to the file:
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
        try (DataFileWriter<GenericRecord> fileWriter = new DataFileWriter<>(datumWriter)) {
            fileWriter.create(person.getSchema(), new File("src/main/resources/files/generic-person.avro"));
            fileWriter.append(person);
            System.out.println("Successfully written person info to file");
        } catch (IOException e) {
            System.out.println("Unable to write person record to file.");
            throw new RuntimeException(e);
        }

        // Step 3: Read the generic record from the file
        final File file = new File("src/main/resources/files/generic-person.avro");
        final DatumReader<GenericRecord> datumReader = new GenericDatumReader<>();
        GenericRecord personRead;
        try (DataFileReader<GenericRecord> fileReader = new DataFileReader<>(file, datumReader)) {
            personRead = fileReader.next();
            System.out.println("Successfully read record data from file.");
            System.out.println(personRead.toString());
        } catch (IOException e) {
            System.out.println("Unable to read from file");
            throw new RuntimeException(e);
        }


    }
}
