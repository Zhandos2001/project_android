package com.example.wew;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MainInterface {

    @GET("api/characters")
    Call<String> STRING_CALL();
}
