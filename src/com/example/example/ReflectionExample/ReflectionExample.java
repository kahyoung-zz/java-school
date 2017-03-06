package com.example.example.ReflectionExample;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * This is an example of how you would use reflection
 *
 * One cool thing you could use reflection with is to determine whether a property has an annotation, and
 * handle that accordingly
 */
public class ReflectionExample {
    public static void main(String[] args) {
        Person sam = new Person("Sam", "Fisher", "sam@cia.gov");

        Map<String, Object> fields = new HashMap<>();

        try {
            for (Field field : sam.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                fields.put(field.getName(), field.get(sam));
                field.setAccessible(false);
            }
        } catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(fields);
    }

    private static class Person {
        private String firstName;
        private String lastName;
        private String email;

        Person(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
