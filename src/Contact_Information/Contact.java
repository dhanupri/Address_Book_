package Contact_Information;
import java.util.Scanner;
public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone_number;
    private String email;
    public Contact(String firstName,String lastName,String address,String city,String state,String zip,String phone_number,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phone_number=phone_number;
        this.email=email;
    }
    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Address Book Program in AddressBookMain");
        Contact contact=new Contact(sc.nextLine(), sc.nextLine(), sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine() );
        System.out.println("Contact");
        System.out.println(contact);
    }
}
