package Polymorphism;
class Shape{
    void draw(){
        System.out.println("drawing...");
    }
}
class Rectangle extends Shape{
    void draw(){
        System.out.println("drawing rectangle...");
    }
}
class Circle extends Shape{
    void draw(){
        System.out.println("drawing circle...");
    }
}
class Triangle extends Shape{
    void draw(){
        System.out.println("drawing triangle...");
    }
}
class DrawShapes{
    public static void main(String args[]){
        Shape shape=new Rectangle();
        shape.draw();
        Shape circle=new Circle();
        circle.draw();
        Shape triangle=new Triangle();
        triangle.draw();
    }
}

