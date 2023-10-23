package org.example.zza.annotations;

import org.example.b.generics.*;

public class Annotations {

    public static void main(String[] args) {
        BookInfo book = new @EBook(pages = 200) BookInfo();

        //Using deprecated Method
        Annotations an = new Annotations();
        an.deprecatedMethod();
    }

    @SuppressWarnings("rawtypes unchecked")
    void myMethod() {
        Box<Integer> bi = new Box();
    }

    /**
     * @deprecated This method is deprecated because I want to know how the deprecation works,
     * Otherwise I have no personal problems with this function to deprecate this :) ;
     */
    @Deprecated(since = "JDK-7")
    void deprecatedMethod() {
        String deprecatedString = "Deprecate This :)";
    }
}


@Author("Aditya Mishra")
@EBook(pages = 156)
class BookInfo {
String bookName = "Open Source Universe!!";

}