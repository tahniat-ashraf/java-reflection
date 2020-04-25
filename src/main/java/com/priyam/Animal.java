package com.priyam;

/**
 * @author Tahniat Ashraf Priyam
 * @since 4/26/20
 */
public class Animal {

    public String walk="I walk like an animal";
    private String animalPrivateVariable="Animal private variable";

    public Animal() {
    }

    public void eat() {
        System.out.println("Eat");
    }

    private void animalPrivateMethod(){
        System.out.println("Animal private method");
    }

    public static Animal of() {
        return new Animal();
    }
}
