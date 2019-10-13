package com.hackmusk.apphelpme.model;

public class Publication {

    private int id;
    private int idUser;
    private String urlPhoto;
    private String direction;
    private String desc;
    private String date;
    private String city;

    public Publication() {
    }

    public Publication(int id, int idUser, String urlPhoto, String direction, String desc, String date, String city) {
        this.id = id;
        this.idUser = idUser;
        this.urlPhoto = urlPhoto;
        this.direction = direction;
        this.desc = desc;
        this.date = date;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
