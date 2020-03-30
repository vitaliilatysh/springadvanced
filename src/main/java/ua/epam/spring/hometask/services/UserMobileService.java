package ua.epam.spring.hometask.services;

public interface UserMobileService {
    void changeMobileOperator(Long userId, String number, String companyName);
}
