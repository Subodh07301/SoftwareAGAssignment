package com.main.assigment1;

import java.util.Objects;

/**
 * hashCode() / equals() problem Consider these two simple classes
 * public class Person {
 * private final int age; private final String name;
 * public Person(String name, int age) { this.name = name;
 * this.age = age; }
 * }
 * public class Employee extends Person { private final String role;
 * public Employee(String name, int age, String role) { super(name, age);
 * this.role = role; }
 * }
 * The task is to write appropriate hashCode() and equals()methods for both classes.
 * Nothing from the above source should be modified but additional fields and methods can be
 * added. Instances of Person and Employee should never be equal to one another.
 * An Employee is equal to another Employee if the role, age, and name are all equal between instances.
 * A Person is equal to another Person instance if the age and name are both equal between instances.
 */

public class AssignemntOneSolution {
    public void driverSample(){
        //Test 1.tesing of person1 and person2 are equal or not
        Person p1=new Person("Abc",23);
        Person p2=new Person("Abc",23);
        if (p1.equals(p2)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        Person p3=p2;
        if (p2.equals(p3)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        //Test2: com.main.assigment1.Employee 1 is equal to Employee2 or not
        Employee e1=new Employee("Abc",23,"Developer");
        Employee e2=new Employee("Abc",23,"Developer");
        if (e1.equals(e2)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        Employee e3=e2;
        if (e2.equals(e3)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}

class Person {
    private final int age; private final String name;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
class Employee extends Person { private final String role;
    public Employee(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return super.equals(employee) &&
                Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role);
    }
}
