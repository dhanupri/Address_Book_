package Contact_Information;

import java.util.*;
import java.util.stream.Collectors;
class AddressBook{
    public static  Set<Contact> contact_Information=new HashSet<>();
    //hash table to store multiple addressbook
    public static Hashtable<String,Set<Contact>> Multiple_address_Book=new Hashtable<>();
    //city dictonary
    public static Map<String, List<Contact>> cityDictionary = new HashMap<>();
    //sattae dictonary
    public static Map<String, List<Contact>> stateDictionary = new HashMap<>();
    public static Set Serach_Address(String s){
        for(Map.Entry<String,Set<Contact>> map:Multiple_address_Book.entrySet()){
            if(map.getKey().equals(s)){
                return map.getValue();
            }
        }
        return null;
    }
    // add city or state
    public static void addCity_State(Contact contact) {
        cityDictionary.computeIfAbsent(contact.getCity(), k -> new ArrayList<>()).add(contact);
        stateDictionary.computeIfAbsent(contact.getState(), k -> new ArrayList<>()).add(contact);
    }
    //view person by City
    public static List<Contact> getPersonsByCity(String city) {
        return cityDictionary.getOrDefault(city, new ArrayList<>());
    }
    //view person by state
    public static List<Contact> getPersonsByState(String state) {
        return stateDictionary.getOrDefault(state, new ArrayList<>());
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
    //number of contact persons i.e count by city
    public static Map<String, Long> getContactCountByCity() {
        return cityDictionary.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (long) e.getValue().size()));
    }
    //number of contact persons i.e count by state
    public static Map<String, Long> getContactCountByState() {
        return stateDictionary.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (long) e.getValue().size()));
    }
    //sort contact by name
    public static void sort_by_Name(){
        Multiple_address_Book.entrySet().stream().forEach(contact_list ->{
            List<Contact> person=contact_list.getValue().stream()
                    .sorted((contact1,contact2)-> contact1.getfirstName().compareTo(contact2.getfirstName()))
                    .collect(Collectors.toList());
            person.forEach(System.out::println);
        });
    }
    //sort by city
    public static void sort_by_City(){
        Multiple_address_Book.entrySet().stream().forEach(contact_list ->{

            List<Contact> person=contact_list.getValue().stream()
                    .sorted((contact1,contact2)-> contact1.getCity().compareTo(contact2.getCity()))
                    .collect(Collectors.toList());
            person.forEach(System.out::println);
        });
    }
    //sort by state
    public static void sort_by_State(){
        Multiple_address_Book.entrySet().stream().forEach(contact_list ->{
            List<Contact> person=contact_list.getValue().stream()
                    .sorted((contact1,contact2)-> contact1.getState().compareTo(contact2.getState()))
                    .collect(Collectors.toList());
            person.forEach(System.out::println);
        });
    }
    //sort by Zip
    public static void sort_by_Zip(){
        Multiple_address_Book.entrySet().stream().forEach(contact_list ->{
            List<Contact> person=contact_list.getValue().stream()
                    .sorted((contact1,contact2)-> contact1.getZip().compareTo(contact2.getZip()))
                    .collect(Collectors.toList());
            person.forEach(System.out::println);
        });
    }
}