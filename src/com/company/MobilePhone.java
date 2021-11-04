package com.company;

import java.util.ArrayList;

/**
 * represents a mobile phone
 */
public class MobilePhone {

  ArrayList<Contact> contacts = new ArrayList<Contact>();

  /**
   * Determines if a person exists within a contact list
   * @param name String -- name of the person being searched for in the list
   * @return true if person exists within contacts
   */
  public int hasContact(String name) {
      for(int i = 0; i < contacts.size(); i++) {
        if (contacts.get(i).getName().equals(name)) {
          return i;
        }
      }
      return -1;
  }

  /**
   * Adds a contact to the contacts list
   * @param name adds a name to the contact
   * @param number adds a number to the contact
   */
  public void addContact(String name, int number) {
    if (hasContact(name) < 0) {
      Contact contact = new Contact(name, number);
      contacts.add(contact);
    } else {
      System.out.println("Contact already exists");
    }
  }

  /**
   * removes a contact
   * @param name name of the person to be removed from contact
   */
  public void removeContact(String name) {
    if (hasContact(name) >= 0) {
      contacts.remove(contacts.get(hasContact(name)));
    } else {
      System.out.println("No contact exists to remove");
    }
  }

  /**
   * updates the contact with new information
   * @param name the name of the person to be updated
   * @param updatedName their new name
   * @param number their new number
   */
  public void updateContact(String name, String updatedName, int number) {
    if (hasContact(name) >= 0) {
      contacts.get(hasContact(name)).updateContact(updatedName, number);
    } else {
      System.out.println("No such contact exists to update");
    }
  }

  public ArrayList<Contact> getContacts() {
    return new ArrayList<Contact>(contacts);
  }

  public void printContacts() {
    for (Contact contact : contacts) {
        System.out.println(contact.getName() + " -- " + contact.getNumber());
      }
    }

}
