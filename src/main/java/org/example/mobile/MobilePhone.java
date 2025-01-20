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
        if (!myContacts.contains(oldContact)) { // Burada eski kişi kontrol edilmeli
            System.out.println(oldContact.getName() + " bulunamadı.");
            return false;
        }
        int foundPosition = myContacts.indexOf(oldContact); // indexOf ile pozisyon bulma
        myContacts.set(foundPosition, newContact);
        return true;
    }


    public boolean removeContact(Contact contact) {
        if (!myContacts.contains(contact)) {
            System.out.println(contact.getName() + " bulunamadı.");
            return false;
        }
        myContacts.remove(contact);
        return true;
    }

    // Mevcut findContact metodu (String parametre alır)
    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equalsIgnoreCase(name)) {
                return i; // İlgili Contact'ın indeksini döner
            }
        }
        return -1; // Bulunamadıysa -1 döner
    }

    // Yeni findContact metodu (Contact parametre alır)
      public int findContact(Contact contact) {
          if (contact == null) {
              return -1; // Geçersiz bir Contact nesnesi verilirse -1 döner
          }
          return findContact(contact.getName()); // Mevcut findContact(String) metodunu çağırır

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