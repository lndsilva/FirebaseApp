package br.com.local.firebaseapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RecuperarContaActivity extends AppCompatActivity {

    MaterialButton recuperarConta;
    MaterialToolbar voltarLogin;
    AlertDialog alerta;
    TextInputEditText txtEmailRecuperaConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recuperar_conta_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recuperarConta = findViewById(R.id.btnRecuperaConta);
        voltarLogin = findViewById(R.id.idToolBarRecuperarConta);
        txtEmailRecuperaConta = findViewById(R.id.txtEmailRecuperarConta);

        recuperarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaAlerta();
            }

        });


        voltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });


    }

    public void telaAlerta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Recuperar conta");
        builder.setMessage("Deseja receber e-mail para recuperar sua senha?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Senha enviada para o e-mail cadastradao", Toast.LENGTH_SHORT).show();
                txtEmailRecuperaConta.setFocusable(true);
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                txtEmailRecuperaConta.setText("");
                txtEmailRecuperaConta.setFocusable(true);
            }
        });

        alerta = builder.create();
        alerta.show();
    }
}