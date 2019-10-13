package com.hackmusk.apphelpme.model;

public class User {

    private int id;
    private String nombre;
    private String telefono;
    private int id_ciudad;
    private String userName;
    private String password;

    public User() {
    }

    public User(int id, String nombre, String telefono, int id_ciudad, String userName, String password) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.id_ciudad = id_ciudad;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
