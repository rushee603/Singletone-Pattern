package org.example;

public class Main {

    public static void main(String[] args) {

        User user= User.getUser();
        User user1= User.getUser();

        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
    }

}