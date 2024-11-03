package br.com.bankaccountmanager.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String document;
    private LocalDate birthDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return LocalDateTime.now().getYear() - this.birthDate.getYear();
    }

    public Person(int id, String firstName, String lastName, String document, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document='" + document + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
