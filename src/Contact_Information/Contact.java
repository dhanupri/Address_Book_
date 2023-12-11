package Contact_Information;
import java.util.Scanner;
class Contact {
    /*
    create a Contacts in Address
    Book with first and last names, address,
    city, state, zip, phone number and
    email...
     */
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone_number;
    private String email;
    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phone_number, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone_number = phone_number;
        this.email = email;
    }
    public String getfirstName() {
        return firstName;
    }
    public String getlastName() {
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
    static Scanner sc=new Scanner(System.in);
    /*
    Ability to add a new
    Contact to Address Book
     */
    public static void add_contact(){
        System.out.println("FirstName:");
        String FirstName= sc.nextLine();
        System.out.println("LastName:");
        String LastName= sc.nextLine();
        System.out.println("Address:");
        String Address = sc.nextLine();
        System.out.println("City:");
        String City = sc.nextLine();
        System.out.println("State:");
        String State = sc.nextLine();
        System.out.println("ZIP:");
        String ZIP = sc.nextLine();
        System.out.println("Phone_number:");
        String PhoneNumber = sc.nextLine();
        System.out.println("Email:");
        String Email = sc.nextLine();
        Contact contact = new Contact(FirstName, LastName, Address, City, State, ZIP, PhoneNumber, Email);
        AddressBook.Contact_Information(contact);
    }
    /*
     edit
    existing contact
    person using their
    name
     */
    public static void edit_contact()  {
        System.out.println("Enter the First name of contact you want to edit:");
        String contact_name= sc.nextLine();
        System.out.println("Enter the last name you want to edit:");
        String contact_last_name=sc.nextLine();
        Contact contact_existing=AddressBook.search_contact(contact_name,contact_last_name);
        if(contact_existing!=null) {
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
        }
    }
    /*
    to delete a person using
    person's name
     */
    public static void delete_contact(){
        System.out.println("Enter the name of contact you want to delete:");
        String contact_name= sc.nextLine();
        String contact_last_name=sc.nextLine();
        Contact contact_existing=AddressBook.search_contact(contact_name,contact_last_name);
        AddressBook.contact_Information.remove(contact_existing);
    }
    public static void main(String[] args){
        AddressBook addressBook=new AddressBook();
        System.out.println("Welcome to Address Book Program in AddressBookMain");
        System.out.println("1.Add Contact \n" +
                "2.Edit Contact \n" +
                "3.Delete Contact \n" +
                "4.exit ");
        int choice= sc.nextInt();
        sc.nextLine();
        while (choice>0 && choice <4){
            switch (choice){
                case 1:
                    add_contact();
                    break;
                case 2:
                    edit_contact();
                    break;
                case 3:
                    delete_contact();
                    break;
                default:
                    break;
            }
            System.out.println("AddressBookMain:");
            AddressBook.display();
            System.out.println("1.Add Contact \n" +
                    "2.Edit Contact \n" +
                    "3.Delete Contact \n" +
                    "4.exit ");
            choice=sc.nextInt();
            sc.nextLine();
        }
    }
}