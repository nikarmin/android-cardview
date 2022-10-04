package br.unicamp.apiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    }

    private void alterarDog() {
    }

    private void incluirDog() {
    }

    private void consultarDogNome() {
        
    }

    private void limpar(){
        edtId.setText("");
        edtImagem.setText("");
        edtNome.setText("");
        edtRaca.setText("");
    }
}