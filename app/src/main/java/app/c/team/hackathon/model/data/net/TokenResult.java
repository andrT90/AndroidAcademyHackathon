package app.c.team.hackathon.model.data.net;

import com.google.gson.annotations.SerializedName;

public class TokenResult {
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }
}
