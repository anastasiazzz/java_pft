package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String email;
  private String group;

  public ContactData(String firstName, String middleName, String lastName, String nickName, String company, String address, String homePhone, String email, String group) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.email = email;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() { return group;  }
}
