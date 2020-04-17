package br.com.mariojp.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OutraActivity extends AppCompatActivity {

    private Button btnConfirmar;
    private Button btnCancelar;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnCancelar = findViewById(R.id.btnCancelar);
        editText = findViewById(R.id.editText);

        //if(getIntent().hasExtra("USUARIO")){
            editText.setText(getIntent().getStringExtra("USUARIO"));
        //}

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);
                String newName = editText.getText().toString();
                getIntent().putExtra("USUARIO", newName);
                setResult(200, getIntent());
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(500, null);
                finish();
            }
        });
    }
}
