package com.example.pesoideal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

        double altura;
        double resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etAltura = findViewById(R.id.etAltura);
        Button btnCalc = findViewById(R.id.btnCalc);
        final TextView tvResp = findViewById(R.id.tvResp);

        // Botão para calcular
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    double imc = calcIMC( Double.parseDouble(etAltura.getText().toString()));
                    imcString(imc, tvResp);
                }
                catch (Exception e) {
                    Log.d("Erro:",e.toString());
                    tvResp.setText(getText(R.string.err));
                }
                hideKeyBoard();
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbMasculino:
                if (checked) {


                }
                     break;
            case R.id.rbFeminino:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    // Cálculo do IMC
    private double calcIMC( double altura){
        double resp = (72.7*altura)-58;
        return resp;
    }



    // Obtem cálculo e formula resposta
    private void imcString(double calc,TextView tv){
        DecimalFormat df = new DecimalFormat("#.00");
        String resp = "Seu peso ideal é: "+df.format(calc)+"\n";

        tv.setText(resp);
    }
    // Esconde o teclado
    public void hideKeyBoard() {
        View view = this.getCurrentFocus();
        if(view!= null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}