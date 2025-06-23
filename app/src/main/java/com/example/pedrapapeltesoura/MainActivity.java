package com.example.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textoResultado, placarJogador, placarComputador, jogadaComputador;
    private int pontosJogador = 0;
    private int pontosComputador = 0;
    private Random random = new Random();

    private String[] opcoes = {"Pedra", "Papel", "Tesoura"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado = findViewById(R.id.textoResultado);
        placarJogador = findViewById(R.id.placarJogador);
        placarComputador = findViewById(R.id.placarComputador);
        jogadaComputador = findViewById(R.id.jogadaComputador);
    }

    public void selecionarPedra(View view) {
        jogar("Pedra");
    }

    public void selecionarPapel(View view) {
        jogar("Papel");
    }

    public void selecionarTesoura(View view) {
        jogar("Tesoura");
    }

    private void jogar(String escolhaJogador) {
        String escolhaComputador = opcoes[random.nextInt(3)];
        jogadaComputador.setText("Computador: " + escolhaComputador);

        if (escolhaJogador.equals(escolhaComputador)) {
            textoResultado.setText("Empate!");
        } else if (
                (escolhaJogador.equals("Pedra") && escolhaComputador.equals("Tesoura")) ||
                        (escolhaJogador.equals("Papel") && escolhaComputador.equals("Pedra")) ||
                        (escolhaJogador.equals("Tesoura") && escolhaComputador.equals("Papel"))
        ) {
            textoResultado.setText("Você venceu!");
            pontosJogador++;
        } else {
            textoResultado.setText("Você perdeu!");
            pontosComputador++;
        }

        atualizarPlacar();
    }

    private void atualizarPlacar() {
        placarJogador.setText(String.valueOf(pontosJogador));
        placarComputador.setText(String.valueOf(pontosComputador));
    }
}
