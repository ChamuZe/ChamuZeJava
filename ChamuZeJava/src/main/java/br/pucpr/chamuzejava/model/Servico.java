package br.pucpr.chamuzejava.model;
import br.pucpr.chamuzejava.file.categoria;
import br.pucpr.chamuzejava.file.status_servico;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Servico implements Serializable{
    private static final long serialVersionUID = 1L;
    private String descricao;
    private String titulo;
    private BufferedImage img;
    private categoria categoria;
    private String local_servico;
    private status_servico status_servico;
    private double preco;

    public Servico(String descricao, String titulo, BufferedImage img, categoria categoria, String local_servico, status_servico status_servico, double preco ) {
        this.descricao = descricao;
        this.titulo = titulo;
        this.img = img;
        this.categoria = categoria;
        this.local_servico = local_servico;
        this.status_servico = status_servico;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BufferedImage getImg(){
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public br.pucpr.chamuzejava.file.categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(br.pucpr.chamuzejava.file.categoria categoria) {
        this.categoria = categoria;
    }

    public String getLocal_servico() {
        return local_servico;
    }

    public void setLocal_servico(String local_servico) {
        this.local_servico = local_servico;
    }

    public br.pucpr.chamuzejava.file.status_servico getStatus_servico() {
        return status_servico;
    }

    public void setStatus_servico(br.pucpr.chamuzejava.file.status_servico status_servico) {
        this.status_servico = status_servico;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
