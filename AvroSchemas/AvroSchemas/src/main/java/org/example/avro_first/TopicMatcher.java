package org.example.avro_first;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopicMatcher {
    public static void main(String[] args) {
        final Pattern TOPIC_NAME_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*");
        System.out.println(TOPIC_NAME_PATTERN.matcher("hello_name").matches());
    }
}
