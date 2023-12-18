package Contact_Information;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Read_Write {
    String filepath="E:\\Address_Book\\src\\Contact_Information\\input1.csv";
    public static Contact readCSV(String filepath){
        Contact contact=new Contact();
//        AddressBook addressBook=new AddressBook();
        List<Contact> details=new ArrayList<>();
        try (BufferedReader reader=new BufferedReader(new FileReader(filepath))){
            String line;
            line=reader.readLine();
            while (line!=null){
                String[] data=line.split(",");
                Contact contact1=new Contact(data[0], data[1],data[2],data[3],data[4],data[5],data[6],data[7]);
                details.add(contact1);

            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        contact.setContacts(details);
        return contact;



    }
}
