package br.unicamp.apiretrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dog implements Serializable {

    // pegar o objeto inteiro e passar pra outro lugar
    @SerializedName("id")
    private String id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("image")
    private String image;
    @SerializedName("raca")
    private String raca;

    public Dog (String id, String nome, String raca, String img){
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.image = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imagem) {
        this.image = imagem;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
