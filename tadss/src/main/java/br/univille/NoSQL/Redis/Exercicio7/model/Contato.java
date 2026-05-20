package br.univille.NoSQL.Redis.Exercicio7.model;

public class Contato {

    private String nome;
    private String sobrenome;
    private String telefone;
    private String idade;

    public Contato() {
    }

    public Contato(String nome, String sobrenome, String telefone, String idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
               "\nSobrenome: " + sobrenome +
               "\nTelefone: " + telefone +
               "\nIdade: " + idade;
    }
}