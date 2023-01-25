package org.iesfm.build;

import java.util.List;
import java.util.Objects;

public class Apartment {
    private int number;
    private String door;
    private List<Owner> owners;

    public Apartment() {

    }

    public Apartment(int number, String door, List<Owner> owners) {
        this.number = number;
        this.door = door;
        this.owners = owners;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return number == apartment.number && Objects.equals(door, apartment.door) && Objects.equals(owners, apartment.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, door, owners);
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "number=" + number +
                ", door='" + door + '\'' +
                ", owners=" + owners +
                '}';
    }
}
