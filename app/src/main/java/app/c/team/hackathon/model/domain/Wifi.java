package app.c.team.hackathon.model.domain;

import com.google.gson.annotations.SerializedName;

class Wifi {
    @SerializedName("name")
    private String name;

    @SerializedName("login")
    private String login;

    @SerializedName("password")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
