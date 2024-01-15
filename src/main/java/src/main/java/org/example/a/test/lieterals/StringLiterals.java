package org.example.a.test.lieterals;

public class StringLiterals {

    public static void main(String[] args) {
        String word = "Hello' my\n name\" is\\ Aditya\t Mishra. I am\f currently in third year";
//        System.out.println(word);
//        Hello' my
//        name" is\ Aditya	 Mishra. I am currently in third year

        String word2 = "Hello, " + '\'' + " My Name is: "+ '\t' + "Aditya Mishra." +'\n' + "I am currently " +
                "in third year of university!!";
//        System.out.println(word2);

//        Hello, ' My Name is: 	Aditya Mishra.
//        I am currently in third year of university!!

    }
}
