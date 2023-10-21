package a.test;

public class SecondBase {
    public static void main(String[] args) {
        
    }

    public int convert(String age) throws StringNotToIntException {
        try {
            return Integer.parseInt(age);
        } catch (Exception ex) {
            throw new StringNotToIntException("Can't cast String "+ age +" to Integer.");
        }
    }
}


class StringNotToIntException extends  Exception {
    public StringNotToIntException(String message) {
        super(message);
    }
}