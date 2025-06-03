package br.pucpr.chamuzejava.controller;

import br.pucpr.chamuzejava.model.Prestador;
import br.pucpr.chamuzejava.model.Solicitante;
import br.pucpr.chamuzejava.model.Usuario;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

public class ControllerUsuario {
    // Constante com a pasta e o nome do arquivo para persistir o objeto
    private final String CAMINHO_ARQUIVO = "baseDeDados.dat";
    private Usuario usuario;
    public static Usuario usuarioLogado;

    //Construtor padrão
    public ControllerUsuario(){

    }

    //Contrutor para Login
    public ControllerUsuario(Usuario usuario){
        this.usuario = usuario;
        System.out.println("Contrutor -> Dados do Usuário: " + usuario.getEmail() + "  " + usuario.getSenha());
    }

    //Contrutor para cadastro

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public ArrayList<Usuario> lerLista(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        //Abrir a lista de usuários
        try{
            File arquivo = new File(CAMINHO_ARQUIVO);
            if(arquivo.exists()){
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
                usuarios = (ArrayList<Usuario>) ois.readObject();
                ois.close();
            }
        }catch (Exception e){
            System.err.println("Erro ao ler o arquivo");
        }
        return usuarios;
    }

    public void salvarLista(ArrayList<Usuario> usuarios){
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            //Verificação de existência de arquivo, caso não exista cria
            if(!(arquivo.exists())){
                arquivo.createNewFile();
            }
            //Salva a lista de usuarios em um arquivo
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
            oos.writeObject(usuarios);
            oos.close();

        } catch (Exception e){
            System.err.println("Ocorreu um erro ao salvar o usuário :" + e.getMessage());
        }
    }

    public void cadastrarUsuario(){
        ArrayList<Usuario> usuarios = lerLista();
        usuarios.add(this.usuario);
        salvarLista(usuarios);
    }

    public Usuario realizarLogin(String email, String senha){
        ArrayList<Usuario> usuarios = lerLista();

        //Lógica para verificar tipo de perfil
        for (Usuario usuario : usuarios){
            if ((usuario.getEmail().equals(email)) && (usuario.getSenha().equals(senha))){
                this.usuarioLogado = usuario;
                return usuario;
            }
        }

        return null;
    }

}
