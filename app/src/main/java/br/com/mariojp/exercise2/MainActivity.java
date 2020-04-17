package br.com.mariojp.exercise2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnTrocarUsuario;
    private String usuario = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        btnTrocarUsuario = findViewById(R.id.btnTrocar);

        setInitialMessage(savedInstanceState);


        btnTrocarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, OutraActivity.class);
                in.putExtra("USUARIO", usuario);
                startActivityForResult(in, 200);
            }
        });
    }

    private void setInitialMessage(Bundle savedInstanceState){
        if(savedInstanceState != null){
            usuario = savedInstanceState.getString("USUARIO", "");
        }
        setFinalMessage();
    }

    private void setFinalMessage(){
        if(!usuario.isEmpty()){
            textView.setText("Oi, "+usuario+"!");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("USUARIO", usuario);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 500){
            usuario = "";
        }else{
            if(data.getStringExtra("USUARIO").trim().isEmpty()){
                usuario="";
                textView.setText("Oi!");
            }else{
                usuario=data.getStringExtra("USUARIO");
                textView.setText("Oi, "+usuario+"!");
            }
        }
       setFinalMessage();
    }
}
