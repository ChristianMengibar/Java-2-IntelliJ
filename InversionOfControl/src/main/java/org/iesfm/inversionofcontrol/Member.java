package org.iesfm.inversionofcontrol;

import java.util.Objects;

public class Member {
    private String nif;
    private String nombre;
    private String apellido;
    private int codigoPostal;

    public Member(String nif, String nombre, String apellido, int codigoPostal) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return codigoPostal == member.codigoPostal && Objects.equals(nif, member.nif) && Objects.equals(nombre, member.nombre) && Objects.equals(apellido, member.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, nombre, apellido, codigoPostal);
    }

    @Override
    public String toString() {
        return "Member{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", codigoPostal=" + codigoPostal +
                '}';
    }
}
