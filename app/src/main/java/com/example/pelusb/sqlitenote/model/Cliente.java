package com.example.pelusb.sqlitenote.model;

/**
 * Created by pelusb on 18/04/17.
 */

public class Cliente {

    private int id;
    private String nome;
    private String endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
