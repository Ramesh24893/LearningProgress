// In the below each layer is dependent on another layer,
// So if one layer is changed it will affect the another
//Each layer holds the object of another layer

package IDP;

public class MechanismLayer {
    UtilityLayer ul;
    public MechanismLayer() {
        this.ul=new UtilityLayer();
    }
}
