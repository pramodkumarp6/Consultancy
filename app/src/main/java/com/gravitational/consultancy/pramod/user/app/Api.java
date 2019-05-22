package com.gravitational.consultancy.pramod.user.app;

import com.gravitational.consultancy.pramod.user.model.DefaultResponse;
import com.gravitational.consultancy.pramod.user.model.ListItem;
import com.gravitational.consultancy.pramod.user.model.Result;


import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {


    @FormUrlEncoded
    @POST("register")
    Call<Result> createUser(
            @Field("email") String email,
            @Field("password") String password,
            @Field("name") String name,
            @Field("mobile") String mobile
    );

    @FormUrlEncoded
    @POST("login")
    Call<Result> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

   @GET("allusers")
    Call<ListItem> getUsers();




    @FormUrlEncoded
    @POST("doc/{id}")
    Call<ListItem> document_view(
            @Path("id") int id

    );






    @FormUrlEncoded
    @PUT("updateuser/{id}")
    Call<Result> updateUser(
            @Path("id") int id,
            @Field("email") String email,
            @Field("name") String name,
            @Field("mobile") String mobile
    );



    @DELETE("deleteuser/{id}")
    Call<DefaultResponse> deleteUser(@Path("id") int id);


    @FormUrlEncoded
    @POST("passwordupdate/{id}")
    Call<Result> password(
            @Path("id") int id,

            @Field("currentpass") String currentpass,
            @Field("newpass") String newpass
    );









    @FormUrlEncoded
    @POST("comment/{id}")
    Call<Result> feedback(
            @Path("id") int id,
            @Field("email") String email,

            @Field("name") String name,
            @Field("msg") String mobile
    );





}