package Polymorphism;

class IphoneThirteenPro{
    public String cameraSetUp(){
        return "Triple camera setup";
    }
    public int storage(){
        return 120;
    }
    public int ram(){
        return 8;
    }
    final void software(){

    }
}
class Iphone14 extends IphoneThirteenPro{

        public int ram(){
            return 12;
        }
        public String cameraSetUp(){
            return "Double Camera Setup";
        }
   //   void software(){  // Cant override final method
     //   }
}
public class Phone{
    public static void main(String[] args) {
        IphoneThirteenPro mobileone=new IphoneThirteenPro();
        System.out.println(mobileone.cameraSetUp());
        System.out.println(mobileone.ram());
        System.out.println(mobileone.storage());
        Iphone14 mobiletwo =new Iphone14();
        System.out.println(mobiletwo.cameraSetUp());
        System.out.println(mobiletwo.ram());
        System.out.println(mobiletwo.storage());
        IphoneThirteenPro mobilethree=new Iphone14();
        System.out.println(mobilethree.storage());
        System.out.println(mobilethree.ram());
        System.out.println(mobilethree.cameraSetUp());
    }
}

