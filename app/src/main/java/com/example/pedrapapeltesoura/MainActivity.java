package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imageEscolhaApp = findViewById(R.id.imageEscolhaApp);
        TextView textoResultado = findViewById(R.id.textResultado);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroRandom = new Random().nextInt(3); // 0 1 2
        String escolhaApp = opcoes[numeroRandom];

        switch ( escolhaApp ){
            case "pedra" :
                imageEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imageEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imageEscolhaApp.setImageResource(R.drawable.tesoura);
                break;
        }

        System.out.println(escolhaApp);
        System.out.println(escolhaUsuario);

        if(
            (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){
            textoResultado.setText("Você perdeu!");
        }else if(
            (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
            (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
            (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ){
            textoResultado.setText("Você ganhou!");
        }else{
            textoResultado.setText("Empate!");
        }
    }

}