package org.example.b.generics;

class ArrayCompareGenerics {

//    public static <T> int countGreaterThan(T[] arr, T element) {
//        int count = 0;
//        for (T elem: arr) {
/*
            Can't use this as '>' operator can not be used directly on type 'T'.
            '>' can only be applied on primitive types: short, int, double, long, float, byte and char

            if ( elem > element ) {
                count ++;
            }
*/
//        }
//    }

    public <Y extends Comparable<Y>> int countGreaterThan(Y[] arr, Y element) {
        int count = 0;
        for (Y elem: arr) {
            if (elem.compareTo(element) > 0) {
                count ++;
            }
        }
        return count;
    }
}

//interface Comparable<T> {
//    public int compare(T o);
//}

