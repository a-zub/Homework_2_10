package pro.sky.homework_2_10.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homework_2_10.exception.IncorrectNameException;
import pro.sky.homework_2_10.exception.IncorrectSurnameException;

@Service
public class ValidatorService {

    public String validateName(String name) {
        if (StringUtils.isAlpha(name)) {
            return StringUtils.capitalize(name.toUpperCase());
        }
        throw new IncorrectNameException();
    }

    public String validateSurname(String surname) {
        String[] surnames = surname.split("-");
        for (int s = 0; s < surnames.length; s++) {
            if (StringUtils.isAlpha(surnames[s])) {
                surnames[s] = StringUtils.capitalize(surname.toUpperCase());
            } else {
                throw new IncorrectSurnameException();
            }
        }
        return String.join("-", surnames);
    }
}
