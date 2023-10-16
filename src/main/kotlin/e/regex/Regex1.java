package e.regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
//    static Matcher matcher = null;
//    static Pattern pattern = null;
//
//    static Boolean isMatching = null;
//    static Matcher getMatcher() {
//        return matcher;
//    }
//    static Pattern getPattern() {
//        return pattern;
//    }
//
//    static Boolean getIsMatching() {
//        return isMatching;
//    }

    public static void main(String[] args) {
//        Pattern p = Pattern.compile("a*b");
//        Matcher m = p.matcher("aaaaab");
//        boolean b = m.matches();
//        System.out.println(b);   true
// Here is the simple way to do this
//        Boolean isMatching = Pattern.matches("a*b", "aaaaab");
//        System.out.println(isMatching);
//__________________________________________________________________________________________________________
//----------------------------------------------------------------------------------------------------------

//        a, b, or c (simple class)
        performRegexOp("[abc]", "a");  //true
        performRegexOp("[abc]", "abc"); // false

//        Any character except a, b, or c (negation)
        performRegexOp("[^abc]", "f"); //true

//        a through z or A through Z, inclusive (range)
        performRegexOp("[a-zA_Z]", "h");      // true
        performRegexOp("[a-zA_Z]", "hh");     // true
        performRegexOp("[a-zA_Z]", "AFD");    // true

//        a through d, or m through p: [a-dm-p] (union)
        performRegexOp("[a-d[m-p]]", "d");  // true
        performRegexOp("[a-d[m-p]]", "cc");   //false
        performRegexOp("[a-d[m-p]]", "z");    //false
        performRegexOp("[a-d[m-p]]", "dn");   //false

//        d, e, or f (intersection)
        performRegexOp("[a-z&&def]", "d"); //true
        performRegexOp("[a-z&&def]", "de");   //false
        performRegexOp("[a-z&&def]", "g"); //false

//        a through z, except for b and c: [ad-z] (subtraction)
        performRegexOp("[a-z&&[^bc]]", "b"); //false
        performRegexOp("[a-z&&[^bc]]", "z");  //true
        performRegexOp("[a-z&&[^bc]]", "ac"); //false

//        a through z, and not m through p: [a-lq-z](subtraction)
        performRegexOp("[a-z&&[^m-p]]", "l"); //true
        performRegexOp("[a-z&&[^m-p]]", "m"); //false
        performRegexOp("[a-z&&[^m-p]]", "q"); //true

//        X occurs one or not at all
        performRegexOp("X?", ""); //true
        performRegexOp("X?", "x");    //false
        performRegexOp("X?", "X");    //true

//        X occurs once or more times
        performRegexOp("a+", "a");    //true
        performRegexOp("a+", "aa");   //true
        performRegexOp("a+", "aaa");  //true

//        a occurs zero or more times
        performRegexOp("a*", "");  //true
        performRegexOp("a*", "aaaa"); //true
//         Also can be written as
        performRegexOp("a?|a+", "");  //true
        performRegexOp("a?|a+", "aaaa"); //true
        performRegexOp("a?|a+", "ba"); //false

//        X occurs n times only
        performRegexOp("a{2}", "aa"); //true
//        X{n,}	X occurs n or more times
//        X{y,z}	X occurs at least y times but less than z times

// Some operations on position of a character
        performRegexOp(".s", "aas"); // false
        performRegexOp(".s", "s");  // false
        performRegexOp(".s", "fs"); // true
        performRegexOp("...s", "susi"); // false
        performRegexOp("...s", "swiss");    // false
        performRegexOp("...s", "swis");    // true
        performRegexOp("...s.", "swiss");    // true

//        ? quantifier ....
        System.out.println(Pattern.matches("[abc]?", "")); // true
        System.out.println(Pattern.matches("[abc]?", "a")); // true
        System.out.println(Pattern.matches("[amn]?", "a"));//true (a or m or n comes one time)
        System.out.println(Pattern.matches("[amn]?", "aaa"));//false (a comes more than one time)
        System.out.println(Pattern.matches("[amn]?", "aammmnn"));//false (a, m and n comes more than one time)
        System.out.println(Pattern.matches("[amn]?", "aazzta"));//false (a comes more than one time)
        System.out.println(Pattern.matches("[amn]?", "am"));//false (a or m or n must come one time)


//        + quantifier
        System.out.println(Pattern.matches("[amn]+", "a"));//true (a or m or n once or more times)
        System.out.println(Pattern.matches("[amn]+", "aaa"));//true (a comes more than one time)
        System.out.println(Pattern.matches("[amn]+", "aammmnn"));//true (a or m or n comes more than once)
        System.out.println(Pattern.matches("[amn]+", "aazzta"));//false (z and t are not matching pattern)

//        * quantifier
        System.out.println(Pattern.matches("[amn]*", "ammmna"));//true (a or m or n may come zero or more times)

//        .Any character (may or may not match terminator)
//        \d Any digits,short of[ 0 - 9]
//        \D Any non - digit,short for [^0 - 9]
//        \s Any whitespace character, short for [\t\n\x0B\f\r]
//        \S Any non - whitespace character,short for [^\s]
//        \w Any word character, short for [a - zA - Z_0 - 9]
//        \W Any non - word character,short for [^\w]
//        \b A word boundary
//        \B A non word boundary


        System.out.println(Pattern.matches("\\d", "abc"));//false (non-digit)
        System.out.println(Pattern.matches("\\d", "1"));//true (digit and comes once)
        System.out.println(Pattern.matches("\\d", "4443"));//false (digit but comes more than once)
        System.out.println(Pattern.matches("\\d", "323abc"));//false (digit and char)

        System.out.println("metacharacters D....");//D means non-digit

        System.out.println(Pattern.matches("\\D", "abc"));//false (non-digit but comes more than once)
        System.out.println(Pattern.matches("\\D", "1"));//false (digit)
        System.out.println(Pattern.matches("\\D", "4443"));//false (digit)
        System.out.println(Pattern.matches("\\D", "323abc"));//false (digit and char)
        System.out.println(Pattern.matches("\\D", "m"));//true (non-digit and comes once)

        System.out.println("metacharacters D with quantifier....");
        System.out.println(Pattern.matches("\\D*", "mak"));//true (non-digit and may come 0 or more times)



        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "kkvarun32"));//false (more than 6 char)
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun$2"));//false ($ is not matched)



        System.out.println("by character classes and quantifiers ...");
        System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9953038949"));//true
        System.out.println(Pattern.matches("[789][0-9]{9}", "9953038949"));//true

        System.out.println(Pattern.matches("[789][0-9]{9}", "99530389490"));//false (11 characters)
        System.out.println(Pattern.matches("[789][0-9]{9}", "6953038949"));//false (starts from 6)
        System.out.println(Pattern.matches("[789][0-9]{9}", "8853038949"));//true

        System.out.println("by metacharacters ...");
        System.out.println(Pattern.matches("[789]{1}\\d{9}", "8853038949"));//true
        System.out.println(Pattern.matches("[789]{1}\\d{9}", "3853038949"));//false (starts from 3)
    }

    static void performRegexOp(String regex, String word) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(word);
        Boolean isMatching = matcher.matches();
        System.out.println(isMatching);
    }
}














