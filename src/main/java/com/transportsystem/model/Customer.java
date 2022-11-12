package com.transportsystem.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;

@NamedQueries({
    @NamedQuery(name = Customer.FIND_ALL, query = "SELECT c FROM Customer c"),
    @NamedQuery(name = Customer.FIND_WITH_ID, query = "SELECT c FROM Customer c WHERE c.id=:Id"),
    @NamedQuery(name = Customer.FIND_WITH_FIRST_NAME, query = "SELECT c FROM Customer c WHERE c.firstName=:FirstName")
})
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    public static final String FIND_ALL = "Customer.findAll";
    public static final String FIND_WITH_ID = "Customer.findWithId";
    public static final String FIND_WITH_FIRST_NAME = "Customer.findWithFirstName";
    @Embedded
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }




    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String email;
    @Column
    String phone;

    @OneToOne
	private Address address;
    @Formula("(select count(c.id) from customers c where c.firstName='mercy')")
    private int countName;


    @Override
    public String toString() {
        return "Customer{ firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", phone=" + phone + '\'' + '}';
    }
public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCountName() {
        return countName;
    }

    public void setCountName(int countName) {
        this.countName = countName;
    }


}
