package com.company;

/**
 * represents a contact in a mobile phone
 */
public class Contact {

  private String name;
  private int number;

  public Contact(String name, int number) {
    this.name = name;
    this.number = number;
  }

  public void updateContact(String name, int number) {
    this.number = number;
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public int getNumber() {
    return this.number;
  }

}
