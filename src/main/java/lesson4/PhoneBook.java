package lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public PhoneBook(HashMap<String, ArrayList<String>> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void add(String surname, String phoneNumber) {
        ArrayList<String> phonesForSurname = phoneBook.getOrDefault(surname, new ArrayList<>());
        phonesForSurname.add(phoneNumber);
        phoneBook.put(surname, phonesForSurname);
    }

    public ArrayList<String> get(String surname) {
        return phoneBook.get(surname);
    }
}
