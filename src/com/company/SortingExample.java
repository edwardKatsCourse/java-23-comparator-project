package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SortingExample {
    static Scanner scanner = new Scanner(System.in);

    static Person [] persons = new Person[] {
            new Person("Daniel", "Smith", 1),
            new Person("Anna", "Thomason", 1),
            new Person("Peter", "Dale", 1),
            new Person("Sarah", "Jason", 1),
            new Person("Margareth", "Smith", 1),
            new Person("Jane", "Doson", 1),
            new Person("Jane", "Doson", 1)
    };

    static {
        Arrays.sort(persons);
    }

    public static void main(String[] args) {

        String input = "";
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Print all persons");
            System.out.println("2. Add a new person");
            System.out.println("3. Exit");
            input = scanner.nextLine();
            if (input.equals("3")) {
                break;
            }

            if (input.equals("1")) {
                printPersons(persons);
            } else if (input.equals("2")) {
                Person person = readNewPerson();
                persons = addNewPerson(persons, person);
            }

            System.out.println("Run again? Y/N");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.println("Bye-bye!");

//        printPersons(persons);
//        Person person = readNewPerson();
//
//        persons = addNewPerson(persons, person);
//        System.out.println(" --- After adding --- ");
//        printPersons(persons);
    }

    private static Person readNewPerson() {
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String stringPhoneNumber = scanner.nextLine();
        Integer phoneNumber = Integer.parseInt(stringPhoneNumber);

        Person person = new Person(firstName, lastName, phoneNumber);
        return person;
    }

    private static Person [] addNewPerson(Person [] persons, Person person) {
        int index = Arrays.binarySearch(persons, person);

        Person[] copyAr = new Person[persons.length + 1];
        System.arraycopy(persons, 0, copyAr, 0, -index - 1);
        copyAr[-index - 1] = person;
        System.arraycopy(persons, -index - 1, copyAr, -index, persons.length - (-index-1));
        persons = copyAr;

        return persons;
    }

    private static void printPersons(Person [] persons) {
        int counter = 0;
        for (Person p : persons) {
            System.out.printf("%s - %s%n", counter++, p.toString());
        }
    }

    private static void intArrayCopy() {
        int[] digits = new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9};
        //int[] copy = new int[]{0, 0, 0, 0, 5, 6, 7, 8, 9};
        //-index-1
        int index = Arrays.binarySearch(digits, 2);
        System.out.println(index);

        System.out.println(Arrays.toString(digits));
        int[] copyAr = new int[digits.length + 1];
        System.arraycopy(digits, 0, copyAr, 0, -index - 1);
        copyAr[-index - 1] = 2;
        //                                2                 2                   9 - 2 (7)
        System.arraycopy(digits, -index - 1, copyAr, -index, digits.length - (-index-1));

        System.out.println(Arrays.toString(copyAr));
    }
}

class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private Integer phoneNumber;

    public Person(String firstName, String lastName, Integer phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Person o) {
        int lastNameResult = this.getLastName().compareTo(o.getLastName());
        if (lastNameResult == 0) {
            int firstNameResult = this.getFirstName().compareTo(o.getFirstName());
            if (firstNameResult == 0) {
                return this.getPhoneNumber().compareTo(o.getPhoneNumber());
            }
            return firstNameResult;
        }
        return lastNameResult;
    }

    @Override
    public String toString() {
        return String.format("Lastname: %s | Firstname: %s | Number: %s",
                this.getLastName(),
                this.getFirstName(),
                this.getPhoneNumber());
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
