echo Generic Record preety print:
echo
java -jar avro-tools-1.8.2.jar tojson --pretty src/main/resources/files/generic-person.avro
echo
echo Specific Record pretty printing:
java -jar avro-tools-1.8.2.jar tojson --pretty src/main/resources/files/specific-person.avro
