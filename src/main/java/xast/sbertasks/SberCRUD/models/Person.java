package xast.sbertasks.SberCRUD.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "surname")
    @NotEmpty(message = "Enter your surname!")
    @Size(min = 1, max = 60, message = "Your surname should be between 1 and 60!")
    private String surname;

    @Column(name = "name")
    @NotEmpty(message = "Enter your name!")
    @Size(min = 1, max = 60, message = "Your name should be between 1 and 60!")
    private String name;

    @Column(name = "age")
    @Min(value = 16, message = "Your age should be between 16 and 100")
    private int age;

    public Person(String surname, String name, Integer age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    public Person() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
