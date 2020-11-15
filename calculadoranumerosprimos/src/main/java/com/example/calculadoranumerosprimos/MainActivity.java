package com.example.calculadoranumerosprimos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
//La aplicacion funciona de la siguiente manera. pides una posicion. Te da un numero. Si el siguiente numero que pides es inferior al anterior,
//La aplicaion no necesitara calcular los numero otra vez, ya estara calculado.
//Si pudes un 3º numero superior a los otros 2 anteriores, te volvera a calcular todos los numeros poniendo como numero maximo el 3º numero introducido
//si se intoduce desde un principio el numero maximo 9999, no se necesitaran volver a calcular los numeros
public class MainActivity extends AppCompatActivity {
    //Se definen los atributos que van a ser usados en nuestra aplicación
    private TextView TVPosicion;
    private EditText ETNumero;
    private EditText ETPrimos;
    private Button BTCalcular;
    //Almacenara los valores ya calculados
    private ArrayList<Integer>numerosprimos;
    private int posicionprimo = 0;
    private int segundoCalculo = 0;

    //  Estos atributos seran usados para saber si es necesario volver a calcular los numeros
    private int num1 = 0;
    private int num2 = 0;

    private CalculaNumero calculaNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pone el icono en el Action bar11
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //Se conecta la parte XML con la parte visual, para poder interactuar con los elementos.
        TVPosicion = findViewById(R.id.TVPosicion);
        ETNumero = findViewById(R.id.ETNumero);
        ETPrimos = findViewById(R.id.ETPrimos);
        numerosprimos = new ArrayList<Integer>();
        calculaNumero = new CalculaNumero();
        BTCalcular = findViewById(R.id.BTCalcular);
        BTCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sirve para verificar que se halla puesto un numero que se encuentre en el valor que pide el enunciado
                if(ETNumero.getText().length() > 0 && ETNumero.getText().length() < 5 && Integer.parseInt(ETNumero.getText().toString()) != 0 ){
                    //Cambia el color del texto a negro (Investigacion)
                    ETPrimos.setTextColor(Color.BLACK);
                    num1 = Integer.parseInt(String.valueOf(ETNumero.getText()));
                    if(numerosprimos.size() == 0 || num2<num1 ){
                        numerosprimos = calculaNumero.calcularPrimos(num1);
                        ETPrimos.setText((numerosprimos.get(numerosprimos.size()-1).toString()));
                        num2=num1;
                    }else {
                        ETPrimos.setText(numerosprimos.get(Integer.parseInt(ETNumero.getText().toString())-1).toString());
                    }
                }else{
                    ETPrimos.setText("Inserte un numero valido");
                    //Cambia el color del texto a rojo (Investigacion)
                    ETPrimos.setTextColor(Color.RED);
                }
            }
        });
    }
}
