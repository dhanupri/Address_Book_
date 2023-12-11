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
    // serach if the contact present or not
    public static Contact search_contact(String name){
        for(Contact c:contact_Information){
            if(c.getfirstName().equals(name) || c.getlastName().equals(name)){
                return c;
            }
        }
        return null;
    }
}
