public class InvalidEmailAddressException extends Exception {
    public InvalidEmailAddressException(String email, String message)
    {
        super("\nEmail:" + email + '\n'+ "Issue:" + message);

    }
}
