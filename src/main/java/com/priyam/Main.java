package com.priyam;

import java.lang.reflect.*;

/**
 * @author Tahniat Ashraf Priyam
 * @since 4/26/20
 */
public class Main {
    public static void main(String[] args) {


        try {

            //Three ways of creating an instance of class

            Class<?> aClass = Class.forName("com.priyam.Person");
            Person person = new Person(13, "Priyam");

            Class<? extends Person> aClass1 = person.getClass();
            var personClass = Person.class;

            //Super class
            System.out.println("Super Class");
            var interfaces = aClass.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                System.out.println("anInterface = " + anInterface.getSimpleName());
            }

            //Interface
            System.out.println("Interface");
            Class<?> superclass = aClass.getSuperclass();
            System.out.println("superclass.getSimpleName() = " + superclass.getSimpleName());//omly name
            System.out.println("superclass.getCanonicalName() = " + superclass.getCanonicalName());//name incl. package
            System.out.println("superclass.getName() = " + superclass.getName());//name incl package

            //Access field names
            System.out.println("Access fields");

            //getFields only gives public and inherited ones those are also public
            System.out.println("class.getFields()");
            var fields = aClass.getFields();
            for (Field field : fields) {
                System.out.println("field.getType().getSimpleName() = " + field.getType().getSimpleName());
                System.out.println("Modifier.toString(field.getModifiers()) = " + Modifier.toString(field.getModifiers()));
                System.out.println("field.getName() = " + field.getName());
            }

            //getDeclaredFields only gives all class variables
            System.out.println("class.getDeclaredFields()");
            var declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.println("field.getType().getSimpleName() = " + field.getType().getSimpleName());
                System.out.println("Modifier.toString(field.getModifiers()) = " + Modifier.toString(field.getModifiers()));
                System.out.println("field.getName() = " + field.getName());
            }

            //access single field details
            System.out.println("Age field details - try get/set");
            var age = personClass.getDeclaredField("age");
            System.out.println("age.getType().getSimpleName() = " + age.getType().getSimpleName());
            var accessModifier = Modifier.toString(age.getModifiers());
            if (accessModifier.equalsIgnoreCase("private")) {
                age.setAccessible(true);
            }

            var ageValue = (Integer) age.get(person);
            System.out.println("ageValue = " + ageValue);
            age.set(person, 66);
            ageValue = (Integer) age.get(person);
            System.out.println("ageValue = " + ageValue);


            //getMethods gives only the public + inherited public methods
            System.out.println("Exploring getMethods()");
            var methods = aClass.getMethods();
            for (Method method : methods) {
                System.out.println("method.getName() = " + method.getName());
                System.out.println("Modifier.toString(method.getModifiers()) = " + Modifier.toString(method.getModifiers()));
                var parameterTypes = method.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println("parameterType.getSimpleName() = " + parameterType.getSimpleName());
                }
            }


            //getDeclaredMethods gives only the class methods
            System.out.println("Exploring getDeclaredMethods()");
            var declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.println("method.getName() = " + method.getName());
                System.out.println("Modifier.toString(method.getModifiers()) = " + Modifier.toString(method.getModifiers()));
                var parameterTypes = method.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println("parameterType.getSimpleName() = " + parameterType.getSimpleName());
                }
            }

            //getConstructor - only public, no inheriteds
            System.out.println("Exploring getConstructors");
            var constructors = aClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("constructor.getName() = " + constructor.getName());

                var parameterTypes = constructor.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println("parameterType.getSimpleName() = " + parameterType.getSimpleName());
                }
            }


            //getDeclaredConstructors - only class methods  223456789
            System.out.println("Exploring getDeclaredConstructors");
            var declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("constructor.getName() = " + constructor.getName());

                var parameterTypes = constructor.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println("parameterType.getSimpleName() = " + parameterType.getSimpleName());
                }
            }

            //create object instance from class
            System.out.println("Create object instance from constructor");
            var constructor = personClass.getConstructor(int.class, String.class);
            var mukulAshraf = constructor.newInstance(65, "Mukul Ashraf");

            System.out.println("mukulAshraf.getAge() = " + mukulAshraf.getAge());
            System.out.println("mukulAshraf.getName() = " + mukulAshraf.getName());


        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

