package lab_2.desirialize;

import lab_2.serialize.JSONSerialize;

import java.io.IOException;

public class Person {

    public Person(String name){
        this.name=name;
    }

    public Person(){}

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
//        JSONSerialize<Person> p = new JSONSerialize<>();
//        Person person = new Person();
//        person.setName("Ynert");
//        try {
//            System.out.println(p.fromObject(person));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        String s = "{\"name\":\"Ynert\"}";
        JSONDeserialize<Person> des = new JSONDeserialize<>(Person.class);
        try {
            System.out.println(des.toObject(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
