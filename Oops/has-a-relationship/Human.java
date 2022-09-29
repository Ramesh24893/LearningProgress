package HasARelationship;

class Heart {
    int heartWeight;
    int heartBeatRate;
    public Heart(int heartWeight, int heartBeatRate) {
        this.heartWeight = heartWeight;
        this.heartBeatRate = heartBeatRate;
    }
}
public class Human{
    String name;
    int age;
    int weight;
    Heart heart=new Heart(500,80);
    public Human(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;

    }


    public static void main(String[] args) {
    Human human=new Human("Ram",21,61);
    }
}
