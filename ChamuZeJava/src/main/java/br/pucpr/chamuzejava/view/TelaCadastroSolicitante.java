package br.pucpr.chamuzejava.view;

import br.pucpr.chamuzejava.app.Main;
import br.pucpr.chamuzejava.controller.ControllerUsuario;
import br.pucpr.chamuzejava.model.Usuario;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TelaCadastroSolicitante {
    public static Scene criarTela(){
        //Tela cadastro
        GridPane telaCadastro = new GridPane();

        //Título da tela de cadastro
        Label tituloTelaCadastro = new Label("Cadastro Solicitante");
        telaCadastro.add(tituloTelaCadastro, 1, 0);

        //Campos tela de cadastro
        Label labelEntradaEmail = new Label("E-mail: ");
        telaCadastro.add(labelEntradaEmail, 1, 1);
        TextField entradaEmail = new TextField();
        telaCadastro.add(entradaEmail, 1, 2);

        Label labelEntradaSenha = new Label("Senha: ");
        telaCadastro.add(labelEntradaSenha, 1, 3);
        PasswordField entradaSenha = new PasswordField();
        telaCadastro.add(entradaSenha, 1, 4);

        //Botão para cadastrar
        Button botaoCadastrar = new Button("Cadastrar");
        telaCadastro.add(botaoCadastrar,1 ,5 );
        //Cadastra o usuário
        botaoCadastrar.setOnAction(evento->{
            //Pegando os dados do input
            String email = entradaEmail.getText();
            String senha = entradaSenha.getText();

            Usuario usuario = new Usuario(email, senha);
            ControllerUsuario controllerUsuario = new ControllerUsuario(usuario);
            controllerUsuario.cadastrarUsuario();

        });

        //Botão voltar para Login
        Button botaoVoltarParaLogin = new Button("Voltar");
        telaCadastro.add(botaoVoltarParaLogin, 1, 6);
        //Lógica para voltar para tela de login
        botaoVoltarParaLogin.setOnAction(evento->{
            Main.mudarCena(TelaLogin.criarTela());
        });

        return new Scene(telaCadastro, 1000, 500);
    }
}
