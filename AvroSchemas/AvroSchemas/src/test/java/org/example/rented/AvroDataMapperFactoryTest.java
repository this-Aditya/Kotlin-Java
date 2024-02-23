package org.example.rented;

import org.apache.avro.Schema;
import org.apache.avro.SchemaValidationException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

class AvroDataMapperFactoryTest {

    private static final Schema MEASUREMENT_KEY_SCHEMA = new Schema.Parser().parse("{" +
            "  \"namespace\": \"org.radarcns.key\"," +
            "  \"type\": \"record\"," +
            "  \"name\": \"MeasurementKey\"," +
            "  \"doc\": \"Measurement key in the RADAR-base project\"," +
            "  \"fields\": [" +
            "    {\"name\": \"userId\", \"type\": \"string\", \"doc\": \"user ID\"}," +
            "    {\"name\": \"sourceId\", \"type\": \"string\", \"doc\": \"device source ID\"}" +
            "  ]" +
            "}");

    private static final Schema INCOMPLETE_MEASUREMENT_KEY_SCHEMA = new Schema.Parser().parse("{"+
            "  \"namespace\": \"org.radarcns.key\","+
            "  \"type\": \"record\","+
            "  \"name\": \"MeasurementKey\","+
            "  \"doc\": \"Measurement key in the RADAR-base project\","+
            "  \"fields\": ["+
            "    {\"name\": \"sourceId\", \"type\": \"string\", \"doc\": \"device source ID\"}"+
            "  ]"+
            "}");

    private static final Schema SMALL_ENUM_SCHEMA = new Schema.Parser().parse(
            "{\"type\":\"record\",\"name\":\"E\",\"fields\":["
                    + "{\"name\": \"e\", \"type\": {\"type\": \"enum\", \"name\": \"Enum\", \"symbols\": [\"A\", \"B\"]}}"
                    + "]}");

    private static final Schema LARGE_ENUM_SCHEMA = new Schema.Parser().parse(
            "{\"type\":\"record\",\"name\":\"E\",\"fields\":["
                    +"{\"name\": \"e\", \"type\": {\"type\": \"enum\", \"name\": \"Enum\", \"symbols\": [\"A\", \"B\", \"C\"]}}"
                    + "]}");

    private static final Schema UNKNOWN_ENUM_SCHEMA = new Schema.Parser().parse(
            "{\"type\":\"record\",\"name\":\"E\",\"fields\":["
                    + "{\"name\": \"e\", \"type\": {\"type\": \"enum\", \"name\": \"Enum\", \"symbols\": [\"A\", \"B\", \"UNKNOWN\"]}}"
                    + "]}");

    private static final Schema DEFAULT_ENUM_SCHEMA = new Schema.Parser().parse(
            "{\"type\":\"record\",\"name\":\"E\",\"fields\":["
                    + "{\"name\": \"e\", \"type\": {\"type\": \"enum\", \"name\": \"Enum\", \"symbols\": [\"A\"]}, \"default\": \"A\"}"
                    + "]}");

    private static final Schema ALL_TYPES_SCHEMA = new Schema.Parser().parse(
            "{\"type\":\"record\",\"name\":\"R\",\"fields\":["
                    + "{\"name\": \"e\", \"type\": {\"type\": \"enum\", \"name\": \"Enum\", \"symbols\": [\"A\"]}, \"default\": \"A\"},"
                    + "{\"name\": \"i\", \"type\": \"int\"},"
                    + "{\"name\": \"l\", \"type\": \"long\"},"
                    + "{\"name\": \"d\", \"type\": \"double\"},"
                    + "{\"name\": \"f\", \"type\": \"float\"},"
                    + "{\"name\": \"sI\", \"type\": \"string\"},"
                    + "{\"name\": \"sD\", \"type\": \"string\"},"
                    + "{\"name\": \"sU\", \"type\": [\"null\", \"string\"]},"
                    + "{\"name\": \"sUi\", \"type\": [\"null\", \"string\"]},"
                    + "{\"name\": \"sUe\", \"type\": [\"null\", {\"name\": \"SE\", \"type\": \"enum\", \"symbols\": [\"A\"]}]},"
                    + "{\"name\": \"uS\", \"type\": \"string\"},"
                    + "{\"name\": \"se2\", \"type\": \"string\"},"
                    + "{\"name\": \"se3\", \"type\": \"string\"},"
                    + "{\"name\": \"a\", \"type\": {\"type\":\"array\", \"items\": {\"type\": \"int\"}}},"
                    + "{\"name\": \"m\", \"type\": {\"type\":\"map\", \"values\": {\"type\": \"int\"}}},"
                    + "{\"name\": \"fS\", \"type\": {\"name\": \"f1\", \"type\":\"fixed\", \"size\": 2}},"
                    + "{\"name\": \"bS\", \"type\": \"bytes\"},"
                    + "{\"name\": \"fb\", \"type\": {\"name\": \"f2\",\"type\": \"fixed\", \"size\": 2}},"
                    + "{\"name\": \"bf\", \"type\": \"bytes\"},"
                    + "{\"name\": \"bfd\", \"type\": \"bytes\"},"
                    + "{\"name\": \"unmapped\", \"type\": \"int\"}"
                    + "]}");

    private static final Schema ALL_TYPES_ALT_SCHEMA = new Schema.Parser().parse(
            "{\"type\":\"record\",\"name\":\"R\",\"fields\":["
                    + "{\"name\": \"e\", \"type\": {\"type\": \"enum\", \"name\": \"Enum\", \"symbols\": [\"A\", \"B\"]}, \"default\": \"A\"},"
                    + "{\"name\": \"i\", \"type\": \"long\"},"
                    + "{\"name\": \"l\", \"type\": \"double\"},"
                    + "{\"name\": \"d\", \"type\": \"float\"},"
                    + "{\"name\": \"f\", \"type\": \"double\"},"
                    + "{\"name\": \"sI\", \"type\": \"int\", \"default\": 0},"
                    + "{\"name\": \"sD\", \"type\": \"double\", \"default\": 0.0},"
                    + "{\"name\": \"sU\", \"type\": \"string\", \"default\": \"\"},"
                    + "{\"name\": \"sUi\", \"type\": [\"null\", \"int\"], \"default\":null},"
                    + "{\"name\": \"sUe\", \"type\": {\"name\": \"SE\", \"type\": \"enum\", \"symbols\": [\"A\"]}, \"default\": \"A\"},"
                    + "{\"name\": \"uS\", \"type\": [\"null\", \"string\"]},"
                    + "{\"name\": \"se2\", \"type\": {\"name\": \"SE2\", \"type\": \"enum\", \"symbols\": [\"A\", \"B\"]}, \"default\": \"A\"},"
                    + "{\"name\": \"se3\", \"type\": {\"name\": \"SE3\", \"type\": \"enum\", \"symbols\": [\"A\", \"B\"]}, \"default\": \"A\"},"
                    + "{\"name\": \"a\", \"type\": {\"type\":\"array\", \"items\": {\"type\": \"float\"}}},"
                    + "{\"name\": \"m\", \"type\": {\"type\":\"map\", \"values\": {\"type\": \"float\"}}},"
                    + "{\"name\": \"fS\", \"type\": \"string\"},"
                    + "{\"name\": \"bS\", \"type\": \"string\"},"
                    + "{\"name\": \"fb\", \"type\": \"bytes\"},"
                    + "{\"name\": \"bf\", \"type\": {\"name\": \"f3\",\"type\":\"fixed\", \"size\": 2}, \"default\": \"aa\"},"
                    + "{\"name\": \"bfd\", \"type\": {\"name\": \"f4\",\"type\":\"fixed\", \"size\": 2}, \"default\": \"aa\"}"
                    + "]}");

    private AvroDataMapperFactory factory;

    @Before
    public void setUp() {
        this.factory = new AvroDataMapperFactory();
    }

    @Test
    public void mapRecord() throws SchemaValidationException, IOException {
//        String actual = doMap(MEASUREMENT_KEY_SCHEMA)
    }

}