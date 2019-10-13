package com.hackmusk.apphelpme.model;

public class Publication {

    private int id;
    private String idUser;
    private String urlPhoto;
    private String direction;
    private String desc;
    private String date;
    private int city;

    public Publication() {
    }

    public Publication(int id, String idUser, String urlPhoto, String direction, String desc, String date, int city) {
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
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

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }
}
