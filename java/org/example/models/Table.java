package org.example.models;

public class Table {
    private short id, capacity;
    private boolean reserved;
    private String firstName, secondName, phoneNumber, status;

    public Table(short id, short capacity, boolean reserved, String firstName, String secondName, String phoneNumber, String status) {
        this.id = id;
        this.capacity = capacity;
        this.reserved = reserved;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }


    public Table(short id, short capacity, boolean reserved) {
        setId(id);
        setCapacity(capacity);
        setReserved(reserved);
    }

    public Table(short id, short capacity, boolean reserved, String status) {
        setId(id);
        setCapacity(capacity);
        setReserved(reserved);
        setStatus(status);
    }

    // Новый конструктор для использования при создании объекта из результатов запроса
    public Table(short id, String firstName, String secondName, short capacity, boolean reserved, String phoneNumber, String status) {
        setId(id);
        setFirstName(firstName);
        setSecondName(secondName);
        setCapacity(capacity);
        setReserved(reserved);
        setPhoneNumber(phoneNumber);
        setStatus(status);
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", reserved=" + reserved +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
