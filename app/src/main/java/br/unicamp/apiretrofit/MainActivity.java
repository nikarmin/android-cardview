package br.unicamp.apiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private GridView dogGridView;
    private FloatingActionButton fab;
    private GridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar myProgressBar = findViewById(R.id.pbMyProgressBar);

        // rodando indeterminadamente
        myProgressBar.setIndeterminate(true);
        myProgressBar.setVisibility(View.VISIBLE);

        fab = findViewById(R.id.fab);


    }
}