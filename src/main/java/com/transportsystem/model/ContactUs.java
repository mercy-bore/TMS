package com.transportsystem.model;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;


    @Entity
    @Table(name = "contact_us")
    public class ContactUs extends BaseEntity{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "contact_email")
        private String contactEmail;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column
        private String message;

        @Transient
        private boolean messageAvailable;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMessageAvailable() {
        return StringUtils.isNotBlank(getMessage());
    }

    public void setMessageAvailable(boolean messageAvailable) {
    }
}
