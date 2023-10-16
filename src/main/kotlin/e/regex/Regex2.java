package e.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The regex \bcat\b would match "cat" in "The cat is here," but not in "category" or "scatter."
 * The regex \Bcat\B would match "category" but not "cat" in "The cat is here" or "scatter."
 *
 */

public class Regex2 {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("a..b", "a56b"));
        String input = "Hello, my name is John and my email is john@example.com.";

        // Define a regex pattern with a named-capturing group
        String regex = "My name is (?<name>\\w+).*?email is (?<email>[A-Za-z@.]+)";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(input);

        // Find the first match
        if (matcher.find()) {
            // Access the captured text using the named group "name"
            String name = matcher.group("name");
            String email = matcher.group("email");

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }
    }
}
