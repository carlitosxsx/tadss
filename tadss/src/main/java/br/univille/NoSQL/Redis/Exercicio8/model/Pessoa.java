package br.univille.NoSQL.Redis.Exercicio8.model;

import java.io.*;

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String apelido;
    private String telefone;
    private String email;
    private int idade;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String apelido, String telefone, String email, int idade) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.email = email;
        this.idade = idade;
    }

    public byte[] serializar() throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(this);

        byte[] dados = baos.toByteArray();

        return dados;
    }

    public static Pessoa desserializar(byte[] dados) throws IOException, ClassNotFoundException {

        ByteArrayInputStream bais = new ByteArrayInputStream(dados);
        ObjectInputStream ois = new ObjectInputStream(bais);

        Pessoa pessoa = (Pessoa) ois.readObject();

        return pessoa;
    }

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

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}