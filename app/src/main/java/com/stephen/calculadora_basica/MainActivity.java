package com.stephen.calculadora_basica;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Declarar variables
    //v1 y v2: valor 1 y valor 2
    //tvResultado: resultado operación básica
    //Botones:btnsum,btnres, btnmulti, btndiv
    private EditText v1, v2;
    private TextView tvResultado;
    private Button btnsum, btnres, btnmulti, btndiv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Relación entre xml (pantalla) y variable
        v1 =(EditText)findViewById(R.id.v1);
        v2 =(EditText)findViewById(R.id.v2);
        tvResultado =(TextView)findViewById(R.id.tvResultado);
        btnsum =(Button)findViewById(R.id.button1);
        btnres =(Button)findViewById(R.id.button2);
        btnmulti =(Button)findViewById(R.id.button3);
        btndiv =(Button)findViewById(R.id.button4);


        //Validar nulos o campos en blanco
        v1.addTextChangedListener(validar_datos);
        v2.addTextChangedListener(validar_datos);
    }//onCreate

    //Regresar a la primera pantalla que aparece al iniciar aplicación
    public void anterior(View view) {
        Intent anterior =new Intent(this, MainActivity2.class);
        startActivity(anterior);

    }

    //Validación de si hay datos en ambos campos
private TextWatcher validar_datos = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        String v1_input =v1.getText().toString().trim();
        String v2_input =v2.getText().toString().trim();

        //Habilitación de botones según validación de nulos o en blanco
btnsum.setEnabled(!v1_input.isEmpty() && !v2_input.isEmpty());
btnres.setEnabled(!v1_input.isEmpty() && !v2_input.isEmpty());
btnmulti.setEnabled(!v1_input.isEmpty() && !v2_input.isEmpty());
btndiv.setEnabled(!v1_input.isEmpty() && !v2_input.isEmpty());

        }


        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    //Operaciones según botones

    //Suma
public void btnsuma(View view) {
double n1 = Double.parseDouble(v1.getText().toString());
double n2 = Double.parseDouble(v2.getText().toString());
double sum = n1 + n2;
tvResultado.setText(String.valueOf(sum));

}
    //Resta
    public void btnresta(View view) {
        double n1 = Double.parseDouble(v1.getText().toString());
        double n2 = Double.parseDouble(v2.getText().toString());
        double substract = n1 - n2;
        tvResultado.setText(String.valueOf(substract));

    }

    //Multiplicación
    public void btnmulti(View view) {
        double n1 = Double.parseDouble(v1.getText().toString());
        double n2 = Double.parseDouble(v2.getText().toString());
        double multiply = n1 * n2;
        tvResultado.setText(String.valueOf(multiply));

    }

    //División
    public void btndivision(View view) {
        double n1 = Double.parseDouble(v1.getText().toString());
        double n2 = Double.parseDouble(v2.getText().toString());


        //Validar división entre cero
if (n1 != 0 && n2 != 0) {
    double divide = n1 / n2;
    tvResultado.setText(String.valueOf(divide));

} else {
tvResultado.setText(String.valueOf("Número inválido"));
}
    }

}//class