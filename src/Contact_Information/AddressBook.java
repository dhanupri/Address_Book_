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
    public static List<List<Contact>> searchPersonInCityOrState(String search_city_or_state) {
        List<List<Contact>> search_result = new LinkedList<>();
        for(Map.Entry<String,Set<Contact>> map : Multiple_address_Book.entrySet()){
            search_result.add(map.getValue().stream()
                    .filter(person -> person.getCity().equalsIgnoreCase(search_city_or_state) || person.getState().equalsIgnoreCase(search_city_or_state)).collect(Collectors.toList()));
        }
        return search_result;
    }
}