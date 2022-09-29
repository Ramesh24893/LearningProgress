//AGGREGATION
package HasARelationship;

class Address {
    String city,state,country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

}
public class Emp {
    int id;
    String name;
    Address address;

    public Emp(int id, String name,Address address) {
        this.id = id;
        this.name = name;
        this.address=address;
    }

    void display(){
        System.out.println(id+" "+name);
        System.out.println(address.city+" "+address.state+" "+address.country);
    }

    public static void main(String[] args) {
        Address address1=new Address("Chennai","TamilNadu","india");
        Address address2=new Address("Tirunelveli","TamilNadu","india");

        Emp varun=new Emp(111,"varun",address1);
        Emp arun=new Emp(112,"arun",address2);

        varun.display();
        arun.display();

    }
}
