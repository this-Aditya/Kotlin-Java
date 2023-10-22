package org.example.a.test;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstBase {

    private static final Pattern URL_PATTERN = Pattern.compile("(?:(?<protocol>\\w+)://)?(?<host>[^:/]+)(?::(?<port>\\d+))?(?<path>/.*)?");

    public static void main(String[] args) {
    String url = "https://chat.openai.com/c/0e5ecc61-e917-44d4-bf11-56d83353bde0";
    checkMatch(url);
    }

    public static void checkMatch(String url) {
        Matcher matcher = URL_PATTERN.matcher(url);
        if (!matcher.matches()) {
            System.out.println("URL didn't matched the pattern");
        } else  {
            int port = -1;
            String protocol = matcher.group("protocol");
            String host = matcher.group("host");
            String portString = matcher.group("port");
            if (portString!=null && !portString.isEmpty()) {
                port = Integer.parseInt(portString);
            }
            String path = cleanPath(matcher.group("path"));
            System.out.println("protocol: "+protocol+" \nhost: "+host+"\nport: "+port+"\npath: "+path);
        }
    }

    private static String cleanPath(String path) {
        if (path == null) {
            return null;
        }
        if (path.contains("?") || path.contains("#")) {
            throw new IllegalArgumentException("Cannot set server path with query string");
        }
        String newPath = path.trim();
        if (newPath.isEmpty()) {
            return "/";
        }
        if (newPath.charAt(0) != '/') {
            newPath = '/' + newPath;
        }
        if (newPath.charAt(newPath.length() - 1) != '/') {
            newPath += '/';
        }
        return newPath;
    }

}
