package br.pucpr.chamuzejava.controller;

import br.pucpr.chamuzejava.model.Servico;
import java.io.*;
import java.util.ArrayList;

public class ControllerServico {
    private final String CAMINHO_ARQUIVO = "servicos.dat";

    public void cadastrarServico(Servico servico) {
        ArrayList<Servico> servicos = lerServicos();
        servicos.add(servico);
        salvarServicos(servicos);
    }

    public ArrayList<Servico> lerServicos() {
        ArrayList<Servico> servicos = new ArrayList<>();
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if(arquivo.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
                servicos = (ArrayList<Servico>) ois.readObject();
                ois.close();
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler serviços: " + e.getMessage());
        }
        return servicos;
    }

    private void salvarServicos(ArrayList<Servico> servicos) {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if(!arquivo.exists()) {
                arquivo.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
            oos.writeObject(servicos);
            oos.close();
        } catch (Exception e) {
            System.err.println("Erro ao salvar serviços: " + e.getMessage());
        }
    }

}