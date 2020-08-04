package com.twu.biblioteca;

import java.util.*;

public class AccountManage {
    private List<Users> users = new ArrayList<>(Arrays.asList(new Users("273-5438", "1111111",
            "Pikachu", "pikachu@pokemon.com", "13708521111"),
            new Users("273-5439", "2222222",
            "Bulbasaur", "bulbasaur@pokemon.com", "13708521122"),
            new Users("273-5440", "3333333",
            "Squirtle", "squirtle@pokemon.com", "13708521133"),
            new Users("admin", "admin",
                    "admin", "admin@biblioteca.com", "00000000000")));

    public List<Users> getUsers() { return users; }

    public String showUserInfo(String libraryNumber) {
        StringBuilder result = new StringBuilder();
        for (Users user: users) {
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
