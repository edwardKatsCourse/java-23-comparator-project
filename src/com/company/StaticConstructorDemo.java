package com.company;


import static java.util.Arrays.binarySearch;

public class StaticConstructorDemo {

    public static void main(String[] args) {
        String staticField = A.staticField;
        System.out.println("----");
        A a1 = new A();
        a1.setRegularField("field a1");
        a1.setStaticField("this is my changed static field");

        A a2 = new A();
        System.out.println(a2.regularField);
        System.out.println(a2.getStaticField());

    }
}

class A {
    //1
    static String staticField = "staticField";
    String regularField = "regularField";

    //2
    static {
//        System.out.println(staticField);
//        System.out.println("static constructor");
    }

    public void setStaticField(String newValue) {
        staticField = newValue;
    }

    public void setRegularField(String newValue) {
        this.regularField = newValue;
    }

    public String getStaticField() {
        return staticField;
    }

    //3 - контекст this
    public A() {
//        System.out.println("constructor");
//        System.out.println(staticField);
    }
}
