package com.example.library.demo.Utils;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
    private String email;
    private Integer quantity;
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidQuantity(Integer quantity){
        return quantity > 0;
    }

    public static String generateISBN() {
        // Prefix for ISBN-13
        String prefix = "978";

        // Generate 9 random digits
        StringBuilder sb = new StringBuilder(prefix);
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10));
        }

        // Calculate the check digit
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(sb.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
        int checkDigit = (10 - (sum % 10)) % 10;

        // Append the check digit
        sb.append(checkDigit);

        return sb.toString();
    }

}
