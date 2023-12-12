package Contact_Information;
import java.util.*;
import java.util.stream.Collectors;
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
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
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
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }
        Contact contact=(Contact) obj;
        return (firstName.equals(contact.firstName) )&&(lastName.equals(contact.lastName));
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
   to add a new
    Contact to Address Book
     */
    public static void add_contact(Set <Contact> contacts){
        System.out.println("FirstName:");
        String FirstName= sc.nextLine();
        System.out.println("LastName:");
        String LastName= sc.nextLine();
        //streams to search
        boolean unique = contacts.stream().noneMatch(p -> (p.getfirstName().equals(FirstName)) && p.getlastName().equals(LastName));
        if(unique) {
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
            contacts.add(contact);
            AddressBook.addCity_State(contact);
            System.out.println("Added to address book");
        }
        else{
            System.out.println("Name already exist .");

        }
    }
    /*
     edit existing contact
    person using their name
     */
    public static void edit_contact(Set<Contact> contacts)  {
        System.out.println("Enter the First name of contact you want to edit:");
        String contact_name= sc.nextLine();
        System.out.println("Enter the last name you want to edit:");
        String contact_last_name=sc.nextLine();
        Contact contact_existing=AddressBook.search_contact(contacts,contact_name,contact_last_name);
        if(contact_existing!=null) {
            System.out.println("Existing Contact Details:");
            System.out.println(contact_existing);
            System.out.println("Enter the new details:");
            while(true) {
                System.out.println("FirstName:");
                String FirstName = sc.nextLine();
                contact_existing.setFirstName(FirstName);
                System.out.println("LastName:");
                String LastName = sc.nextLine();
                contact_existing.setLastName(LastName);
                boolean unique = contacts.stream().anyMatch(p -> (p.getfirstName().equals(FirstName)) && p.getlastName().equals(LastName));
                if (!unique) {
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
                    AddressBook.addCity_State(contact_existing);
                    System.out.println(contact_existing);
                    break;
                } else {
                    System.out.println("name already exist...");
                }
            }
        }
        else{
            System.out.println("No Contact found ....");
        }
    }
    /*
    to delete a person using
    person's name
     */
    public static void delete_contact(Set<Contact> contacts
    ){
        System.out.println("Enter the name of contact you want to delete:");
        String contact_name= sc.nextLine();
        String contact_last_name=sc.nextLine();
        Contact contact_existing=AddressBook.search_contact(contacts,contact_name,contact_last_name);
        AddressBook.contact_Information.remove(contact_existing);

    }
    public static void main(String[] args){
        AddressBook addressBook=new AddressBook();
        System.out.println("Welcome to Address Book Program in AddressBookMain");
        int choice = 1;
        while (choice>0 && choice <4){
            System.out.println("Enter name of address book you need to update");
            String address_book_name=sc.nextLine();
            Set<Contact> address_book=AddressBook.Serach_Address(address_book_name);
            if(address_book==null){
                address_book=new HashSet<>() ;
                AddressBook.Multiple_address_Book.put(address_book_name,address_book);
            }
            System.out.println("1.Add Contact \n" +
                    "2.Edit Contact \n" +
                    "3.Delete Contact \n" +
                    "4.exit ");
            choice= sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    add_contact(address_book);
                    break;
                case 2:
                    edit_contact(address_book);
                    break;
                case 3:
                    delete_contact(address_book);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Search contact by city or state");
        System.out.println("Enter city to view");
        String city = sc.nextLine();
        List<Contact> peopleInCity = AddressBook.getPersonsByCity(city);
        System.out.println("People in"+city);
        peopleInCity.forEach(person -> System.out.println(person.getfirstName() + " " + person.getlastName()));
        System.out.println("Enter state to view");
        String state = sc.nextLine();
        List<Contact> peopleInState = AddressBook.getPersonsByState(state);
        System.out.println("\nPeople in"+state);
        peopleInState.forEach(person -> System.out.println(person.getfirstName() + " " + person.getlastName()));
    }
}