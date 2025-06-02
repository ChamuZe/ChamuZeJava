package br.pucpr.chamuzejava.view;

import br.pucpr.chamuzejava.app.Main;
import br.pucpr.chamuzejava.controller.ControllerUsuario;
import br.pucpr.chamuzejava.model.Usuario;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TelaLogin {
    public static Scene criarTela(){
        //Tela de Login
        GridPane telaLogin = new GridPane();

        /*try {
            //Imagem Logo da tela de login
            Image logoChamuze = new Image(TelaLogin.class.getResourceAsStream("/br/pucpr/chamuzejava/img/chamuzeLogoSemFundo.png"));
            ImageView logoChamuzeView = new ImageView(logoChamuze);
            telaLogin.add(telaLogin, 0, 0);
        } catch (IllegalArgumentException e){
            System.err.println("Erro ao carregar a imagem: " + e.getMessage());
        } catch (Exception e){
            System.err.println("O erro está na IMG");
        }*/

        //Título da tela de login
        Label tituloTelaLogin = new Label("Login");
        telaLogin.add(tituloTelaLogin, 1,0);

        //Campo de entrada E-mail
        Label labelEntradaEmail = new Label("E-mail: ");
        telaLogin.add(labelEntradaEmail, 1, 1);

        TextField entradaEmail = new TextField();
        telaLogin.add(entradaEmail, 1, 2);

        //Campo de entrada senha
        Label labelEntradaSenha = new Label("Senha: ");
        telaLogin.add(labelEntradaSenha, 1, 3);

        PasswordField entradaSenha = new PasswordField();
        telaLogin.add(entradaSenha, 1, 4);

        //Botão de enviar
        Button botaoEnviar = new Button("Enviar");
        telaLogin.add(botaoEnviar,1, 5);

        botaoEnviar.setOnAction(evento -> {
            //Lógica para realizar login
            String email = entradaEmail.getText();
            String senha = entradaSenha.getText();


            ControllerUsuario controllerUsuario = new ControllerUsuario();
            Usuario usuario = controllerUsuario.realizarLogin(email, senha);
            controllerUsuario.setUsuario(usuario);
            System.out.println("Usuario Logado: " + "Tipo: " + usuario.getClass());

        });

        //Campo para cadastrar caso não tenha conta
        HBox linhaSeCadastrar = new HBox(2);

        Label labelLinkSeCadastrar = new Label("Não possui uma conta? ");

        Hyperlink linkSeCadastrar = new Hyperlink("Cadastre-se");

        linhaSeCadastrar.getChildren().addAll(labelLinkSeCadastrar, linkSeCadastrar);

        telaLogin.add(linhaSeCadastrar, 1, 6);

        linkSeCadastrar.setOnMouseClicked(evento -> {
            //Mudar para a tela de escolha de cadastro
            Main.mudarCena(TelaEscolhaCadastro.criarTela());
        });

        return new Scene(telaLogin, 1000, 500) ;
    }
}
