package br.pucpr.chamuzejava.view;

import br.pucpr.chamuzejava.app.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TelaSolicitanteInicial {
    public static Scene criarTela(){
        //Tela do solicitante
        GridPane telaSolicitante = new GridPane();

        //Barra de navegação
        HBox barraDeNavegacao = new HBox();
        //Campos do Nav necessários...

        //Perfil do usuário
        Button botaoPerfil = new Button("Perfil");
        //Acção do botão de perfil
        botaoPerfil.setOnAction(e->{
            Main.mudarCena(TelaPerfilSolicitante.criarTela());
        });

        Button botaoSolicitarServico = new Button("Solicitar Serviço");
        botaoSolicitarServico.setOnAction(e->{
            Main.mudarCena(TelaSolicitarServico.criarTela());
        });

        //Inclusão dos icones do NAVBAR
        barraDeNavegacao.getChildren().addAll(botaoPerfil);
        barraDeNavegacao.getChildren().addAll(botaoSolicitarServico);
        //Adição do NAVBAR na tela
        telaSolicitante.add(barraDeNavegacao, 1, 0);

        //Titulo da tela
        Label tituloTelaSolicitante = new Label("Bem-vindo(a) Solicitante!");
        telaSolicitante.add(tituloTelaSolicitante, 1,1);


        return new Scene(telaSolicitante, 1000, 500);
    }
}
