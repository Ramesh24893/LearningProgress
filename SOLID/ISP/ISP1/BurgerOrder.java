// The below program violates ISP
// Because OrderService interface have fries and combo methods
//When BurgerOrderService class implements OrderService, Customer who only want burger are forced to know about other functionalities
//which are not required for customer

package ISP;
class BurgerOrderService implements OrderService {
    @Override
    public void orderBurger(int quantity) {
        System.out.println("Received order of "+quantity+" burgers");
    }

    @Override
    public void orderFries(int fries) {
        throw new UnsupportedOperationException("No fries in burger only order");
    }

    @Override
    public void orderCombo(int quantity, int fries) {
        throw new UnsupportedOperationException("No combo in burger only order");
    }
}
