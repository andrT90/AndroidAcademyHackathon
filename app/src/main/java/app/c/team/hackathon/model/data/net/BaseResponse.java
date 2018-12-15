package app.c.team.hackathon.model.data.net;

import com.google.gson.annotations.SerializedName;

class BaseResponse<T> {

    @SerializedName("result")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
