package Contact_Information;

import java.util.ArrayList;
class AddressBook{
    //Arraylist to store multiple contact information
    public static final ArrayList<Contact> contact_Information=new ArrayList<Contact>();
    public static void Contact_Information(Contact contact){
        contact_Information.add(contact);
    }
    public static void display(){
        for(Contact c:contact_Information){
            System.out.println(c);
        }
    }
}
