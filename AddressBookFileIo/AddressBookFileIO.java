package AddressBookFileIo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import AddressBookSystem.Contact;

public class AddressBookFileIO 
{
    public void writeDataToFile(Map<String, ArrayList<Contact>> addressBook) 
    {
        File file = new File("C:\\Users\\Prakash Yadav\\Desktop\\Contacts.txt");
        List<Contact> myContactList = addressBook.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        for (Contact contact: myContactList) {
            ObjectOutputStream objectOutputStream =null;
            try
            {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                objectOutputStream.writeObject(contact);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void readDataFromFile()
    {
        File file = new File("C:\\Users\\Prakash Yadav\\Desktop\\Contacts.txt");
        ObjectInputStream objectInputStream = null;
        try 
        {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Object contact = objectInputStream.readObject();
            System.out.println(contact);
        } 
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
