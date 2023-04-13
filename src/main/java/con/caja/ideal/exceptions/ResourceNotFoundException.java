package con.caja.ideal.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    String message;

    public ResourceNotFoundException(String message) {
        this.message = message;
    }
}
