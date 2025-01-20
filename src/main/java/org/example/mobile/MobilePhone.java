package org.example.mobile;


import java.util.List;

public class MobilePhone {

    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public boolean addNewContact(Contact contact) {
        if (myContacts.contains(contact)) {
            return true;
        }
        myContacts.add(contact);
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact.getName()); // oldContact'ın ismiyle arama yap
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " bulunamadı.");
            return false;
        }
        myContacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact.getName()); // contact'ın ismiyle arama yap
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " bulunamadı.");
            return false;
        }
        myContacts.remove(foundPosition);
        return true;
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equalsIgnoreCase(name)) {
                return i; // İlgili Contact'ın indeksini döner
            }
        }
        return -1; // Bulunamadıysa -1 döner
    }

    public Contact queryContact(String name) {
        for (Contact contact : myContacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                // equalsIgnoreCase stringleri büyük/küçük harf farkı olmaksızın karşılaştırır.
                return contact;
            }
        }
        return null;
    }

    public void printContact() {
        if (myContacts.isEmpty()) {
            System.out.println("Contact bulunamadı");
        } else {
            for (Contact contact : myContacts) {
                System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
            }
        }
    }
}