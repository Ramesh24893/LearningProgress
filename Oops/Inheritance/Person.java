package Inheritance;

class Person{
    String name;
    int age;
    String city;
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
    public String walk(){
        return "Walking";
    }
    public String speak(){
        return "Speaking";
    }

}
