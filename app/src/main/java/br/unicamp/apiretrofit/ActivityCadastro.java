package br.unicamp.apiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityCadastro extends AppCompatActivity {

    EditText edtId, edtNome, edtRaca, edtImagem;
    Button btnConsultar, btnInserir, btnAlterar, btnExcluir, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtId = findViewById(R.id.edtId);
        edtNome = findViewById(R.id.edtNome);
        edtRaca = findViewById(R.id.edtRaca);
        edtImagem = findViewById(R.id.edtImg);

        btnConsultar = findViewById(R.id.btnConsultar);
        btnAlterar = findViewById(R.id.btnAlterar);
        btnExcluir = findViewById(R.id.btnExcluir);
        btnInserir = findViewById(R.id.btnInserir);
        btnLimpar = findViewById(R.id.btnLimpar);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultarDogNome();
            }
        });

        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incluirDog();
            }
        });

        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alterarDog();
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excluirDog();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });
    }

    private void excluirDog() {

        String id = edtId.getText().toString();

        if (id != null) {
            Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
            Call<Dog> call = service.excluirDog(id);

            call.enqueue(new Callback<Dog>() {
                @Override
                public void onResponse(Call<Dog> call, Response<Dog> response) {
                    if (response.isSuccessful()){
                        Dog dogResponse = response.body();

                        dogResponse.getId().toString();
                        dogResponse.getNome().toString();
                        dogResponse.getRaca().toString();
                        dogResponse.getImage().toString();

                        Gson gson = new GsonBuilder().create();

                        String jsonResponse = gson.toJson(dogResponse);

                        TextView tvJson = findViewById(R.id.tvJson);
                        tvJson.setText(jsonResponse);

                        TextView tvObj = findViewById(R.id.tvObj);

                        tvObj.setText("");

                        tvObj.append(dogResponse.getId().toString() + "\n");
                        tvObj.append(dogResponse.getNome().toString() + "\n");
                        tvObj.append(dogResponse.getRaca().toString() + "\n");
                        tvObj.append(dogResponse.getImage().toString());
                    }
                    else {
                        Toast.makeText(ActivityCadastro.this, "Erro na exclusão!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Dog> call, Throwable t) {
                    Toast.makeText(ActivityCadastro.this, "Ocorreu erro de requisição no NODE : " + t.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void alterarDog() {

        String id = edtId.getText().toString();
        String nome = edtNome.getText().toString();
        String raca = edtRaca.getText().toString();
        String url = edtImagem.getText().toString();

        if (id != null && nome != null && raca != null && url != null){
            Dog dog = new Dog (id, nome, raca, url);

            Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
            Call<Dog> call = service.alterarDog(id, dog);
            call.enqueue(new Callback<Dog>() {
                @Override
                public void onResponse(Call<Dog> call, Response<Dog> response) {

                    if (response.isSuccessful()){
                        Dog dogResponse = response.body();

                        dogResponse.getId().toString();
                        dogResponse.getNome().toString();
                        dogResponse.getRaca().toString();
                        dogResponse.getImage().toString();

                        Gson gson = new GsonBuilder().create();

                        String jsonResponse = gson.toJson(dogResponse);

                        TextView tvJson = findViewById(R.id.tvJson);
                        tvJson.setText(jsonResponse);

                        TextView tvObj = findViewById(R.id.tvObj);

                        tvObj.setText("");

                        tvObj.append(dogResponse.getId().toString() + "\n");
                        tvObj.append(dogResponse.getNome().toString() + "\n");
                        tvObj.append(dogResponse.getRaca().toString() + "\n");
                        tvObj.append(dogResponse.getImage().toString());
                    }
                    else {
                        Toast.makeText(ActivityCadastro.this, "Erro na alteração!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Dog> call, Throwable t) {
                    Toast.makeText(ActivityCadastro.this, "Ocorreu erro de requisição no NODE : " + t.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void incluirDog() {

        String id = edtId.getText().toString();
        String nome = edtNome.getText().toString();
        String raca = edtRaca.getText().toString();
        String url = edtImagem.getText().toString();

        if (id != null && nome != null && raca != null && url != null){
            Dog dog = new Dog (id, nome, raca, url);

            Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
            Call<Dog> call = service.incluirDog(dog);
            call.enqueue(new Callback<Dog>() {
                @Override
                public void onResponse(Call<Dog> call, Response<Dog> response) {

                    if (response.isSuccessful()){
                        Dog dogResponse = response.body();

                        dogResponse.getId().toString();
                        dogResponse.getNome().toString();
                        dogResponse.getRaca().toString();
                        dogResponse.getImage().toString();

                        Gson gson = new GsonBuilder().create();

                        String jsonResponse = gson.toJson(dogResponse);

                        TextView tvJson = findViewById(R.id.tvJson);
                        tvJson.setText(jsonResponse);

                        TextView tvObj = findViewById(R.id.tvObj);

                        tvObj.setText("");

                        tvObj.append(dogResponse.getId().toString() + "\n");
                        tvObj.append(dogResponse.getNome().toString() + "\n");
                        tvObj.append(dogResponse.getRaca().toString() + "\n");
                        tvObj.append(dogResponse.getImage().toString());
                    }
                    else {
                        Toast.makeText(ActivityCadastro.this, "Erro na inclusão!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Dog> call, Throwable t) {
                    Toast.makeText(ActivityCadastro.this, "Ocorreu erro de requisição no NODE : " + t.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }


    private void consultarDogNome() {
        String nome = edtNome.getText().toString();

        if (nome != null){
            Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
            Call<Dog> call = service.selecionarNome(nome);
            call.enqueue(new Callback<Dog>() {
                @Override
                public void onResponse(Call<Dog> call, Response<Dog> response) {

                    if (response.isSuccessful()){
                        Dog dogResponse = response.body();

                        edtId.setText(dogResponse.getId().toString());
                        edtNome.setText(dogResponse.getNome().toString());
                        edtRaca.setText(dogResponse.getRaca().toString());
                        edtImagem.setText(dogResponse.getImage().toString());
                    }
                    else {
                        Toast.makeText(ActivityCadastro.this, "Erro na consulta!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Dog> call, Throwable t) {
                    Toast.makeText(ActivityCadastro.this, "Ocorreu erro de requisição no NODE : " + t.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void limpar(){
        edtId.setText("");
        edtImagem.setText("");
        edtNome.setText("");
        edtRaca.setText("");
    }
}