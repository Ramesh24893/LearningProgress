package LSP3;

public class Discount {
    public static void main(String[] args) {
        Item it=new Item();
        System.out.println(it.discountPrice(100));
        Item ite=new SpecItem();
        System.out.println(ite.discountPrice(100));
    }
}
