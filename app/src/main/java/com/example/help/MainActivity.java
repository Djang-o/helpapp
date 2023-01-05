package com.example.help;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
Spinner comboBox_Locais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myDados = database.getReference("mensagem");
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1; // o mês é indexado de 0 a 11
        int year = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);


        setContentView(R.layout.activity_main);
        comboBox_Locais = (Spinner) findViewById((R.id.comboBox));
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.localidades, android.R.layout.simple_spinner_item );
        comboBox_Locais.setAdapter(adapter);

        TextView text = findViewById(R.id.btnChamar);
        EditText matricula = findViewById(R.id.editTextMatricula);
        EditText nome = findViewById(R.id.editTextNome);
        EditText observacao = findViewById(R.id.editTextObs);

        Object selectedItem = comboBox_Locais.getSelectedItem();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (matricula.getText().toString().trim().isEmpty() || nome.getText().toString().trim().isEmpty() || selectedItem == null) {

                    matricula.setError("Campo Obrigatorio");
                    nome.setError("Campo Obrigatorio");
                    return;
                }
                String mensagem = "Nome:" +nome.getText() + "\nMatricula:"+matricula.getText() + "\nSecretaria:"+selectedItem + "\nObservacao:"+observacao.getText()+ "\n"+day+"/"+month+"/"+year+" "+hour+ ":"+minute+ "\n";
                myDados.setValue(mensagem);
                Intent intent = new Intent(MainActivity.this, Loading.class);


                startActivity(intent);
            }
        });
    }
}