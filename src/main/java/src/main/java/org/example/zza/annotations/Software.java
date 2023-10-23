package org.example.zza.annotations;

@DeveloperInfo(
        name = "Aditya Mishra",
        language = "Kotlin",
        software = "Hibernate",
        releaseVersion = 56,
        branches = 9
)
public class Software {
    String application;

    public static void main(String[] args) {
        Software swr = new Software();
    }

}


