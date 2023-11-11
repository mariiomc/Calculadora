package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String operacion [] = new String[10];
    public int i = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Establecer un manejador de excepciones global
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                // Registra la excepción en el log
                throwable.printStackTrace();
            }
        });
        for (int j = 0; j < operacion.length; j++) {
            operacion[j] = "";
        }
        textView = (TextView) findViewById(R.id.pantalla);
    }
    private void actualizarPantalla() {
        // Concatenar los elementos del array de operación y mostrarlos en el TextView
        StringBuilder operacionStr = new StringBuilder();
        for (int j = 0; j < operacion.length; j++) {
            operacionStr.append(operacion[j]);
        }
        textView.setText(operacionStr.toString());
    }
    public void seno(View view){
        for (int j = 0; j < operacion.length; j++) {
            operacion[j] = "";
        }
        i = 0;
        operacion[i] = "sin";
        i++;
        actualizarPantalla();
    }
    public void coseno(View view){
        for (int j = 0; j < operacion.length; j++) {
            operacion[j] = "";
        }
        i = 0;
        operacion[i] = "cos";
        i++;
        actualizarPantalla();
    }
    public void tangente(View view){
        for (int j = 0; j < operacion.length; j++) {
            operacion[j] = "";
        }
        i = 0;
        operacion[i] = "tan";
        i++;
        actualizarPantalla();
    }
    public void clear_pantalla(View view){
        for (int j = 0; j < operacion.length; j++) {
            operacion[j] = "";
        }
        i = 0;
        actualizarPantalla();
    }
    public void numero0(View view) {
        operacion[i] = "0";
        i++;
        actualizarPantalla();
    }
    public void numero1 (View view){
        operacion[i] = "1";
        i++;
        actualizarPantalla();
    }
    public void numero2 (View view){
        operacion[i] = "2";
        i++;
        actualizarPantalla();
    }
    public void numero3 (View view){
        operacion[i] = "3";
        i++;
        actualizarPantalla();
    }
    public void numero4 (View view){
        operacion[i] = "4";
        i++;
        actualizarPantalla();
    }
    public void numero5 (View view){
        operacion[i] = "5";
        i++;
        actualizarPantalla();
    }
    public void numero6 (View view){
        operacion[i] = "6";
        i++;
        actualizarPantalla();
    }
    public void numero7 (View view ){
        operacion[i] = "7";
        i++;
        actualizarPantalla();
    }
    public void numero8 (View view){
        operacion[i] = "8";
        i++;
        actualizarPantalla();
    }
    public void numero9 (View view){
        operacion[i] = "9";
        i++;
        actualizarPantalla();
    }
    public void sumar(View view){
        operacion[i] = "+";
        i++;
        actualizarPantalla();
    }
    public void restar(View view){
        operacion[i] = "-";
        i++;
        actualizarPantalla();
    }
    public void multiplicar(View view){
        operacion[i] = "*";
        i++;
        actualizarPantalla();
    }
    public void dividir(View view){
        operacion[i] = "/";
        i++;
        actualizarPantalla();
    }
    public void igualar(View view) {
        // Variables para realizar el cálculo
        double resultado = 0.0;
        double num_actual = 0.0;
        String operador_actual = "";
        String SinCosTan = "";
        if ((operacion[0] == "sin") || (operacion[0] == "cos") || (operacion[0] == "tan")){
            SinCosTan = operacion[0];
        }

        for (int u =0; u<i;u++) {
            if (SinCosTan != "") {
                int numero_actual = 0;
                for(int a=1; a<operacion.length; a++){
                    if(operacion[a+1] != ""){
                        numero_actual *= 10;
                    }
                   numero_actual += Double.parseDouble(operacion[a]);
                }
                if(SinCosTan == "cos"){
                    resultado = Math.cos(numero_actual);
                }
                else if(SinCosTan == "sin"){
                    resultado = Math.sin(numero_actual);
                }
                else if(SinCosTan == "tan"){
                    resultado = Math.tan(numero_actual);
                }

            }
            else if ((operacion[u] != "+") &&(operacion[u] != "-") &&(operacion[u]!="*" ) && (operacion[u]!="/")) {
                // Si el elemento es un número, conviértelo a double
                num_actual = Double.parseDouble(operacion[u]);
                    // Realiza la operación apropiada con el número y el operador actual
                    if (operador_actual.equals("+")) {
                        resultado += num_actual;
                    } else if (operador_actual.equals("-")) {
                        resultado -= num_actual;
                    } else if (operador_actual.equals("*")) {
                        resultado *= num_actual;
                    } else if (operador_actual.equals("/")) {
                        resultado /= num_actual;
                    } else {
                        resultado *= 10;
                        resultado += num_actual;
                    }
            } else {
                // Si el elemento no es un número, actualiza el operador actual
                operador_actual = operacion[u];
            }
        }
        System.out.println("Resultado final: " + resultado);
        textView.setText(String.valueOf(resultado));
        for (int j = 0; j < operacion.length; j++) {
            operacion[j] = "";
        }
        operacion[0] = String.valueOf(resultado);
        System.out.println("Resultado final 2: " + operacion[0]);
        i = 1;
    }

}

