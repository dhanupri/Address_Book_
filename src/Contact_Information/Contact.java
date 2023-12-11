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
    }public String getfirstName() {
        return firstName;
    }public String getlastName(){
        return lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public void setEmail(String email) {
        this.email = email;
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
        AddressBook addressBook=new AddressBook();
        System.out.println("Welcome to Address Book Program in AddressBookMain");
        System.out.println("Want to add new contact yes/no");
        String res=sc.nextLine();
        while(res.equals("yes")){
            //create a contact
            Contact contact=new Contact(sc.nextLine(), sc.nextLine(), sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine() );
            AddressBook.Contact_Information(contact);
            System.out.println("Want to add new contact yes/no");
            res=sc.nextLine();
        }
        if(res.equals("no")) {
            AddressBook.display();
        }
        System.out.println("Enter the name of contact you want to edit:");
        String contact_name= sc.nextLine();
        //edit a contact
        Contact contact_existing=AddressBook.search_contact(contact_name);
        if(contact_existing!=null){
            System.out.println("Existing Contact Details:");
            System.out.println(contact_existing);
            System.out.println("Enter the new details:");
            System.out.println("FirstName:");
            contact_existing.setFirstName(sc.nextLine());
            System.out.println("LastName:");
            contact_existing.setLastName(sc.nextLine());
            System.out.println("Address:");
            contact_existing.setAddress(sc.nextLine());
            System.out.println("City:");
            contact_existing.setCity(sc.nextLine());
            System.out.println("State:");
            contact_existing.setState(sc.nextLine());
            System.out.println("ZIP:");
            contact_existing.setZip(sc.nextLine());
            System.out.println("Phone_number:");
            contact_existing.setPhone_number(sc.nextLine());
            System.out.println("Email:");
            contact_existing.setEmail(sc.nextLine());
            System.out.println("Updated Contact Details");
            System.out.println(contact_existing);
            System.out.println("AddressBookMain:");
            AddressBook.display();
        }
        else{
            System.out.println("Contact not found");
        }
        //delete a contact
        System.out.println("Want to delete new contact yes/no");
        String res_delete=sc.nextLine();
        if(res_delete.equals("yes")){
            System.out.println("Enter the name of contact you want to delete:");
            String contact_name1= sc.nextLine();
            Contact contact_existing1=AddressBook.search_contact(contact_name1);
            AddressBook.contact_Information.remove(contact_existing1);
            System.out.println("AddressBook after deletion:");
            AddressBook.display();
        }
    }
}
