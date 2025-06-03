package br.pucpr.chamuzejava.view;

import br.pucpr.chamuzejava.controller.ControllerUsuario;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TelaPerfilPrestador {
    public static Scene criarTela(){
        GridPane telaPerfilPrestador = new  GridPane();

        // Campos do usuário
        Label labelNome = new Label("Nome: " + ControllerUsuario.usuarioLogado.getNome());
        telaPerfilPrestador.add(labelNome, 1, 2);

        Label labelSobreNome = new Label("Sobrenome: " + ControllerUsuario.usuarioLogado.getSobreNome());
        telaPerfilPrestador.add(labelSobreNome, 1, 3);

        Label labelEmail = new Label("Email: " + ControllerUsuario.usuarioLogado.getEmail());
        telaPerfilPrestador.add(labelEmail, 1, 4);

        Label labelSenha = new Label("Senha: " + ControllerUsuario.usuarioLogado.getSenha());
        telaPerfilPrestador.add(labelSenha, 1, 5);

        Label labelCpf = new Label("CPF: " + ControllerUsuario.usuarioLogado.getCpf());
        telaPerfilPrestador.add(labelCpf, 1, 6);

        Label labelTelefone = new Label("Telefone: " + ControllerUsuario.usuarioLogado.getTelefone());
        telaPerfilPrestador.add(labelTelefone, 1, 7);

        Label labelDataNascimento = new Label("Data de Nascimento: " + ControllerUsuario.usuarioLogado.getDataNascimento());
        telaPerfilPrestador.add(labelDataNascimento, 1, 8);

        Label labelGenero = new Label("Gênero: " + ControllerUsuario.usuarioLogado.getGenero());
        telaPerfilPrestador.add(labelGenero, 1, 9);

        //Faltou CNPJ e Chave pix


        //Botão para realizar a edição dos dados do usuário
        Button botaoEditarSoliciante = new Button("Editar");
        telaPerfilPrestador.add(botaoEditarSoliciante, 1,10);
        botaoEditarSoliciante.setOnAction(e->{
            System.out.println("Vai editar Usuário");
        });

        //Bottão para realizar a exclusão da conta do usuário
        Button botaoExcluirSoliciante = new Button("Excluir");
        telaPerfilPrestador.add(botaoExcluirSoliciante, 1,11);
        botaoExcluirSoliciante.setOnAction(e->{
            System.out.println("Vai excluir Usuário");
        });


        return new Scene(telaPerfilPrestador, 1000, 500);
    }
}
