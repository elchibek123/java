package java22.exception;

public class MyNotFoundException extends RuntimeException {

    public MyNotFoundException() {
    }

    public MyNotFoundException(String message) {
        super(message);
    }
}
