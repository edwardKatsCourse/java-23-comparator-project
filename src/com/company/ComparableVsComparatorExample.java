package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableVsComparatorExample {

    public static void main(String[] args) {
        //Comparable
        //Comparator
        int[] array = new int[]{0, 2, 1, 4, 3};
        int[] array_2 = new int[]{0, 1, 2, 3, 4};

        Comparator<User> userComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getBankAccount().compareTo(o1.getBankAccount());
            }
        };

        User [] users = new User[] {};

        Arrays.sort(users, userComparator);

    }
}

class User {
    private String bankAccount;
    private String socialSecurityNumber;
    private int agesOfEducation;

    public User(String bankAccount, String socialSecurityNumber, int agesOfEducation) {
        this.bankAccount = bankAccount;
        this.socialSecurityNumber = socialSecurityNumber;
        this.agesOfEducation = agesOfEducation;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public int getAgesOfEducation() {
        return agesOfEducation;
    }

    public void setAgesOfEducation(int agesOfEducation) {
        this.agesOfEducation = agesOfEducation;
    }
}