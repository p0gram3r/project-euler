package org.p0gram3r.codingdojo;

public class HelloWorld {

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().getGreeting());
    }

}
