package br.pucpr.chamuzejava.view;

import br.pucpr.chamuzejava.app.Main;
import br.pucpr.chamuzejava.controller.ControllerUsuario;
import br.pucpr.chamuzejava.model.Admin;
import br.pucpr.chamuzejava.model.Prestador;
import br.pucpr.chamuzejava.model.Solicitante;
import br.pucpr.chamuzejava.model.Usuario;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TelaLogin {

    public static Scene criarTela() {
        GridPane telaLogin = new GridPane();

        // Título da tela de login
        Label tituloTelaLogin = new Label("Login");
        telaLogin.add(tituloTelaLogin, 1, 0);

        // Campos de email e senha
        Label labelEntradaEmail = new Label("E-mail: ");
        telaLogin.add(labelEntradaEmail, 1, 1);

        TextField entradaEmail = new TextField();
        telaLogin.add(entradaEmail, 1, 2);

        Label labelEntradaSenha = new Label("Senha: ");
        telaLogin.add(labelEntradaSenha, 1, 3);

        PasswordField entradaSenha = new PasswordField();
        telaLogin.add(entradaSenha, 1, 4);

        // Botão de enviar
        Button botaoEnviar = new Button("Enviar");
        telaLogin.add(botaoEnviar, 1, 5);

        botaoEnviar.setOnAction(evento -> {
            String email = entradaEmail.getText().trim();
            String senha = entradaSenha.getText().trim();

            if(email.isEmpty() || senha.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Preencha todos os campos!").show();
                return;
            }

            ControllerUsuario controllerUsuario = new ControllerUsuario();
            Usuario usuario = controllerUsuario.realizarLogin(email, senha);

            if(usuario != null) {
                controllerUsuario.setUsuario(usuario);

                if (usuario instanceof Admin) {
                    System.out.println("Login como ADMIN bem-sucedido!");
                    Main.mudarCena(TelaPerfilADM.criarTela());
                } else if (usuario instanceof Prestador) {
                    Main.mudarCena(TelaPrestadorInicial.criarTela());
                } else if (usuario instanceof Solicitante) {
                    Main.mudarCena(TelaSolicitanteInicial.criarTela());
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "E-mail ou senha inválidos!").show();
            }
        });

        // Link para cadastro
        HBox linhaSeCadastrar = new HBox(2);
        Label labelLinkSeCadastrar = new Label("Não possui uma conta? ");
        Hyperlink linkSeCadastrar = new Hyperlink("Cadastre-se");
        linhaSeCadastrar.getChildren().addAll(labelLinkSeCadastrar, linkSeCadastrar);
        telaLogin.add(linhaSeCadastrar, 1, 6);

        linkSeCadastrar.setOnMouseClicked(evento -> {
            Main.mudarCena(TelaEscolhaCadastro.criarTela());
        });

        return new Scene(telaLogin, 1000, 500);
    }
}