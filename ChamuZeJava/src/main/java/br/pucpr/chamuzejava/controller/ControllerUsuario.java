package br.pucpr.chamuzejava.controller;

import br.pucpr.chamuzejava.model.Admin;
import br.pucpr.chamuzejava.model.Prestador;
import br.pucpr.chamuzejava.model.Solicitante;
import br.pucpr.chamuzejava.model.Usuario;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerUsuario {
    // Constantes com os caminhos dos arquivos
    private final String CAMINHO_ARQUIVO = "baseDeDados.dat";
    private final String CAMINHO_ADMINS = "admins.dat";
    private Usuario usuario;
    public static Usuario usuarioLogado;

    private static Admin ADMIN_MASTER = new Admin(
            "Admin", "Master", "ADM@gmail.com", "ADM123",
            "000.000.000-00", "(00) 00000-0000", LocalDate.now(), "Não informado"
    );

    public ControllerUsuario() {
        inicializarAdminMaster();
    }

    public ControllerUsuario(Usuario usuario) {
        this.usuario = usuario;
        System.out.println("Contrutor -> Dados do Usuário: " + usuario.getEmail() + "  " + usuario.getSenha());
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Usuario> lerLista() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if(arquivo.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
                usuarios = (ArrayList<Usuario>) ois.readObject();
                ois.close();
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo");
        }
        return usuarios;
    }

    public void salvarLista(ArrayList<Usuario> usuarios) {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if(!(arquivo.exists())) {
                arquivo.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
            oos.writeObject(usuarios);
            oos.close();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao salvar o usuário :" + e.getMessage());
        }
    }

    public void cadastrarUsuario() {
        if (this.usuario instanceof Admin) {
            throw new IllegalArgumentException("Use cadastrarAdmin() para administradores");
        }

        ArrayList<Usuario> usuarios = lerLista();
        usuarios.add(this.usuario);
        salvarLista(usuarios);
    }

    private ArrayList<Admin> lerAdmins() {
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            File arquivo = new File(CAMINHO_ADMINS);
            if(arquivo.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
                admins = (ArrayList<Admin>) ois.readObject();
                ois.close();
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler arquivo de admins: " + e.getMessage());
        }
        return admins;
    }

    private void salvarAdmins(ArrayList<Admin> admins) {
        try {
            File arquivo = new File(CAMINHO_ADMINS);
            if(!arquivo.exists()) {
                arquivo.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
            oos.writeObject(admins);
            oos.close();
        } catch (Exception e) {
            System.err.println("Erro ao salvar admins: " + e.getMessage());
        }
    }

    public boolean cadastrarAdmin(Admin admin) {
        if (usuarioLogado instanceof Admin) {
            ArrayList<Admin> admins = lerAdmins();
            admins.add(admin);
            salvarAdmins(admins);
            return true;
        }
        return false;
    }

    public static ArrayList<Admin> listarAdmins() {
        ControllerUsuario controller = new ControllerUsuario(); // Cria instância se precisar
        ArrayList<Admin> admins = controller.lerAdmins(); // Supondo que lerAdmins() não é estático

        if (admins.stream().noneMatch(a -> a.getEmail().equals(ADMIN_MASTER.getEmail()))) {
            admins.add(ADMIN_MASTER);
        }
        return admins;
    }

    private void inicializarAdminMaster() {
        ArrayList<Admin> admins = lerAdmins();
        if (admins.stream().noneMatch(a -> a.getEmail().equals(ADMIN_MASTER.getEmail()))) {
            admins.add(ADMIN_MASTER);
            salvarAdmins(admins);
        }
    }
    public boolean excluirAdmin(Admin admin) {
        try {
            ArrayList<Admin> admins = lerAdmins();

            // Não permite excluir o ADM master
            if (admin.getEmail().equals(ADMIN_MASTER.getEmail())) {
                return false;
            }

            // Remove o admin da lista
            admins.removeIf(a -> a.getEmail().equals(admin.getEmail()));
            salvarAdmins(admins);
            return true;

        } catch (Exception e) {
            System.err.println("Erro ao excluir admin: " + e.getMessage());
            return false;
        }
    }

    public Usuario realizarLogin(String email, String senha) {
        ArrayList<Usuario> usuarios = lerLista();
        for (Usuario usuario : usuarios) {
            if ((usuario.getEmail().equals(email)) && (usuario.getSenha().equals(senha))) {
                this.usuarioLogado = usuario;
                return usuario;
            }
        }
        ArrayList<Admin> admins = lerAdmins();
        for (Admin admin : admins) {
            if ((admin.getEmail().equals(email)) && (admin.getSenha().equals(senha))) {
                this.usuarioLogado = admin;
                return admin;
            }
        }

        return null;
    }
}