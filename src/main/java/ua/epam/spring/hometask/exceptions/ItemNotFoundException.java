package ua.epam.spring.hometask.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String no_users_found) {
        super(no_users_found);
    }
}
