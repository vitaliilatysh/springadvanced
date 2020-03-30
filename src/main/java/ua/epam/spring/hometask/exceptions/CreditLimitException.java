package ua.epam.spring.hometask.exceptions;

public class CreditLimitException extends RuntimeException {
    public CreditLimitException(String message) {
        super(message);
    }
}
