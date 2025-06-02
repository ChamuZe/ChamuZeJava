package br.pucpr.chamuzejava.view;

import br.pucpr.chamuzejava.app.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TelaEscolhaCadastro {
    public static Scene criarTela(){
        GridPane telaEscolhaCadastro = new GridPane();

        //Cadastro como prestador
        Button botaoPrestador = new Button("Prestador");
        telaEscolhaCadastro.add(botaoPrestador, 1, 1);
        botaoPrestador.setOnAction(evento->{
            Main.mudarCena(TelaCadastroPrestador.criarTela());
        });

        //Cadastro como solicitante
        Button botaoSolicitante = new Button("Solicitante");
        telaEscolhaCadastro.add(botaoSolicitante, 1, 2);
        botaoSolicitante.setOnAction(evento->{
            Main.mudarCena(TelaCadastroSolicitante.criarTela());
        });

        return new Scene(telaEscolhaCadastro, 1000, 500);

    }
}
