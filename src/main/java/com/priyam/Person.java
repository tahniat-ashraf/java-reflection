package com.priyam;

/**
 * @author Tahniat Ashraf Priyam
 * @since 4/26/20
 */
public class Person extends Animal implements Mammal{

    @PrimaryKey
    private int age;
    @ColumnKey
    private String name;
    @ColumnKey
    private String sex;

    public static final String PERSON_CONSTANT="COMPLAIN";

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static Person of(int age, String name) {
        return getNewPerson(age,name);
    }

    private static Person getNewPerson(int age, String name){
        return new Person(age, name);
    }

    private void personPrivateMethod(){
        System.out.println("Person private method");
    }
}
