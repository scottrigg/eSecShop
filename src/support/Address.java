package support;

import java.io.Serializable;

/**
 * Created by mac on 16/6/26.
 */
public class Address implements Serializable {
    private String name;
    private String addLine1;
    private String addLine2;
    private String city;
    private String state;
    private int zipCode;
    private String deliverInstruction;

    public Address(String name, String addLine1, String addLine2, String city, String state, int zipCode, String deliverInstruction) {
        this.name = name;
        this.addLine1 = addLine1;
        this.addLine2 = addLine2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.deliverInstruction = deliverInstruction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddLine1() {
        return addLine1;
    }

    public void setAddLine1(String addLine1) {
        this.addLine1 = addLine1;
    }

    public String getAddLine2() {
        return addLine2;
    }

    public void setAddLine2(String addLine2) {
        this.addLine2 = addLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getDeliverInstruction() {
        return deliverInstruction;
    }

    public void setDeliverInstruction(String deliverInstruction) {
        this.deliverInstruction = deliverInstruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        if (zipCode != address.zipCode) return false;
        if (!name.equals(address.name)) return false;
        if (!addLine1.equals(address.addLine1)) return false;
        if (!addLine2.equals(address.addLine2)) return false;
        if (!city.equals(address.city)) return false;
        if (!state.equals(address.state)) return false;
        return deliverInstruction != null ? deliverInstruction.equals(address.deliverInstruction) : address.deliverInstruction == null;
    }

    @Override
    public String toString() {
        return name + ","
                + addLine1 + ","
                + addLine2 + ","
                + city + ","
                + state + ","
                + zipCode + ","
                + deliverInstruction + '\n';
    }
}
