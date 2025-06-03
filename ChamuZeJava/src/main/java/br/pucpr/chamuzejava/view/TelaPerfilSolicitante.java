package br.pucpr.chamuzejava.view;

import br.pucpr.chamuzejava.controller.ControllerUsuario;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TelaPerfilSolicitante {
    public static Scene criarTela(){
        GridPane telaPerfilSolicitante = new  GridPane();

        // Campos do usuário
        Label labelNome = new Label("Nome: " + ControllerUsuario.usuarioLogado.getNome());
        telaPerfilSolicitante.add(labelNome, 1, 2);

        Label labelSobreNome = new Label("Sobrenome: " + ControllerUsuario.usuarioLogado.getSobreNome());
        telaPerfilSolicitante.add(labelSobreNome, 1, 3);

        Label labelEmail = new Label("Email: " + ControllerUsuario.usuarioLogado.getEmail());
        telaPerfilSolicitante.add(labelEmail, 1, 4);

        Label labelSenha = new Label("Senha: " + ControllerUsuario.usuarioLogado.getSenha());
        telaPerfilSolicitante.add(labelSenha, 1, 5);

        Label labelCpf = new Label("CPF: " + ControllerUsuario.usuarioLogado.getCpf());
        telaPerfilSolicitante.add(labelCpf, 1, 6);

        Label labelTelefone = new Label("Telefone: " + ControllerUsuario.usuarioLogado.getTelefone());
        telaPerfilSolicitante.add(labelTelefone, 1, 7);

        Label labelDataNascimento = new Label("Data de Nascimento: " + ControllerUsuario.usuarioLogado.getDataNascimento());
        telaPerfilSolicitante.add(labelDataNascimento, 1, 8);

        Label labelGenero = new Label("Gênero: " + ControllerUsuario.usuarioLogado.getGenero());
        telaPerfilSolicitante.add(labelGenero, 1, 9);


        //Botão para realizar a edição dos dados do usuário
        Button botaoEditarSoliciante = new Button("Editar");
        telaPerfilSolicitante.add(botaoEditarSoliciante, 1,10);
        botaoEditarSoliciante.setOnAction(e->{
            System.out.println("Vai editar Usuário");
        });

        //Bottão para realizar a exclusão da conta do usuário
        Button botaoExcluirSoliciante = new Button("Excluir");
        telaPerfilSolicitante.add(botaoExcluirSoliciante, 1,11);
        botaoExcluirSoliciante.setOnAction(e->{
            System.out.println("Vai excluir Usuário");
        });


        return new Scene(telaPerfilSolicitante, 1000, 500);
    }
}
