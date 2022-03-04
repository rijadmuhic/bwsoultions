package com.example.bestwebsolutions.model;

public class Photo {
    private String owner;
    private String id;
    private String secret;
    private String server;
    private String farm;
    private String title;
    private Boolean ispublic;
    private Boolean isfriend;
    private Boolean isfamily;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Boolean getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(Boolean isfriend) {
        this.isfriend = isfriend;
    }

    public Boolean getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(Boolean isfamily) {
        this.isfamily = isfamily;
    }

    public Boolean getIspublic() {
        return ispublic;
    }

    public void setIspublic(Boolean ispublic) {
        this.ispublic = ispublic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }
}
