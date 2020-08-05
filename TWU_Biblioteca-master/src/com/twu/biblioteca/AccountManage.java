package com.twu.biblioteca;

import java.util.*;

public class AccountManage {
    private List<User> users = new ArrayList<>(Arrays.asList(new User("273-5438", "1111111",
            "Pikachu", "pikachu@pokemon.com", "13708521111"),
            new User("273-5439", "2222222",
            "Bulbasaur", "bulbasaur@pokemon.com", "13708521122"),
            new User("273-5440", "3333333",
            "Squirtle", "squirtle@pokemon.com", "13708521133"),
            new User("admin", "admin",
                    "admin", "admin@biblioteca.com", "00000000000")));

    public List<User> getUsers() { return users; }

    public String showUserInfo(String libraryNumber) {
        StringBuilder result = new StringBuilder();
        for (User user: users) {
            if (libraryNumber.equals(user.getLibraryNumber())) {
                result.append("name: ").append(user.getName()).
                        append(" email: ").append(user.getEmail()).
                        append(" phone number: ").append(user.getPhoneNumber());
            }
        }
        System.out.println(result.toString());
        return result.toString();
    }

}
