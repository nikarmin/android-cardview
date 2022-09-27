package br.unicamp.apiretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Service {

    @GET("/api/dog/get")
    Call<List<Dog>> getDog();           // retorna uma lista de cachorro

    @GET("/api/dog/getNome/{nome}")
    Call<Dog> selecionarNome(@Path("nome") String nome);        // retorna uma UNIDADE de cachorro, pelo NOME <<<<<<<<<<

    @POST("/api/dog/post")
    Call<Dog> incluirDog(@Body Dog dog);            // incluir cachorro

    @PUT("/api/dog/put/{id}")
    Call<Dog> alterarDog(@Path("id") String id, @Body Dog dog);          // alterar UMA UNIDADE DE CACHORRO

    @DELETE("/api/dog/delete/{id}")
    Call<Dog> excluirDog(@Path("id") String id);            // deletar UMA UNIDADE DE CACHORRO

}
