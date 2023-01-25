package org.iesfm.build;

import java.util.List;
import java.util.Objects;

public class Build {
    private String direction;
    private String municipality;
    private List<Apartment> apartments;

    public Build() {

    }

    public Build(String direction, String municipality, List<Apartment> apartments) {
        this.direction = direction;
        this.municipality = municipality;
        this.apartments = apartments;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Build build = (Build) o;
        return Objects.equals(direction, build.direction) && Objects.equals(municipality, build.municipality) && Objects.equals(apartments, build.apartments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, municipality, apartments);
    }

    @Override
    public String toString() {
        return "Build{" +
                "direction='" + direction + '\'' +
                ", municipality='" + municipality + '\'' +
                ", apartments=" + apartments +
                '}';
    }
}
