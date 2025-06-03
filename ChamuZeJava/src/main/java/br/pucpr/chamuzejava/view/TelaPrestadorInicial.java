package br.pucpr.chamuzejava.view;

import br.pucpr.chamuzejava.app.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TelaPrestadorInicial {
    public static Scene criarTela(){
        //Tela do prestador
        GridPane telaPrestador = new GridPane();

        //Barra de navegação
        HBox barraDeNavegacao = new HBox();
        //Campos do Nav necessários...

        //Perfil do usuário
        Button botaoPerfil = new Button("Perfil");
        //Acção do botão de perfil
        botaoPerfil.setOnAction(e->{
            Main.mudarCena(TelaPerfilPrestador.criarTela());
        });

        //Inclusão dos icones do NAVBAR
        barraDeNavegacao.getChildren().addAll(botaoPerfil);

        //Adição do NAVBAR na tela
        telaPrestador.add(barraDeNavegacao, 1, 0);

        //Titulo da tela
        Label tituloTelaPrestador = new Label("Bem-vindo(a) Prestador!");
        telaPrestador.add(tituloTelaPrestador, 1,1);


        return new Scene(telaPrestador, 1000, 500);
    }
}