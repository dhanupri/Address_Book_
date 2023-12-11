package Contact_Information;

import java.util.*;
import java.util.stream.Collectors;

class AddressBook{
    public static  Set<Contact> contact_Information=new HashSet<>();
    //hash table to store multiple addressbook
    public static Hashtable<String,Set<Contact>> Multiple_address_Book=new Hashtable<>();
    public static Set Serach_Address(String s){
        for(Map.Entry<String,Set<Contact>> map:Multiple_address_Book.entrySet()){
            if(map.getKey().equals(s)){
                return map.getValue();
            }
        }
        return null;
    }
    public static void Contact_Information(Contact contact){
        contact_Information.add(contact);
    }
    public static void display(){
        for(Contact c:contact_Information){
            System.out.println(c);
        }
    }
    //search method
    public static Contact search_contact(Set<Contact> contacts, String name, String name1){
        for(Contact c:contact_Information){
            if(c.getfirstName().equals(name) &&  c.getlastName().equals(name1)){
                return c;
            }

        }
        return null;
    }
    //view Persons
    //by City or State
    public static List<List<Contact>> searchPersonInCityOrState(String search_city_or_state) {
        List<List<Contact>> search_result = new LinkedList<>();
        for(Map.Entry<String,Set<Contact>> map : Multiple_address_Book.entrySet()){
            search_result.add(map.getValue().stream()
                    .filter(person -> person.getCity().equalsIgnoreCase(search_city_or_state) || person.getState().equalsIgnoreCase(search_city_or_state)).collect(Collectors.toList()));
        }
        return search_result;
    }
}