package br.unicamp.apiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private GridView dogGridView;
    private FloatingActionButton fab;
    private GridViewAdapter adapter;

    public void populateGridView(List<Dog> listaDog){
        dogGridView = findViewById(R.id.gbDog);
        adapter = new GridViewAdapter(this, listaDog);
        dogGridView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar myProgressBar = findViewById(R.id.pbMyProgressBar);

        // rodando indeterminadamente
        myProgressBar.setIndeterminate(true);
        myProgressBar.setVisibility(View.VISIBLE);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // chama a activity cadastro que ainda nao foi feita fml tmj
                Intent intent = new Intent(MainActivity.this, ActivityCadastro.class);

                startActivity(intent);
            }
        });

        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        Call<List<Dog>> call = service.getDog();        // pegar a rota no node
        call.enqueue(new Callback<List<Dog>>() {
            @Override
            public void onResponse(Call<List<Dog>> call, Response<List<Dog>> response) {

                if (response.isSuccessful()){
                    myProgressBar.setVisibility(View.GONE);
                    populateGridView(response.body());
                }
                else{
                    String errorMessage = response.errorBody().toString();
                    Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Dog>> call, Throwable t) {
                myProgressBar.setVisibility(View.GONE);
                String messageProblem = t.getMessage().toString();
                Toast.makeText(MainActivity.this, messageProblem, Toast.LENGTH_LONG).show();
            }
        });

    }
}