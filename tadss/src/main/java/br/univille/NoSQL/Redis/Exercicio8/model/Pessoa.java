package br.univille.NoSQL.Redis.Exercicio8.model;

import java.io.*;

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String telefone;
    private String email;
    private int idade;

    public Pessoa() {
    }

    public Pessoa(
            int id,
            String nome,
            String telefone,
            String email,
            int idade
    ) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.idade = idade;
    }

    // SERIALIZAR
    public byte[] serializar() throws IOException {

        ByteArrayOutputStream baos =
                new ByteArrayOutputStream();

        ObjectOutputStream oos =
                new ObjectOutputStream(baos);

        oos.writeObject(this);
        oos.flush();

        byte[] dados = baos.toByteArray();

        oos.close();
        baos.close();

        return dados;
    }

    // DESSERIALIZAR
    public static Pessoa desserializar(byte[] dados)
            throws IOException, ClassNotFoundException {

        ByteArrayInputStream bais =
                new ByteArrayInputStream(dados);

        ObjectInputStream ois =
                new ObjectInputStream(bais);

        Pessoa pessoa = (Pessoa) ois.readObject();

        ois.close();
        bais.close();

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

        return "\nID: " + id +
               "\nNome: " + nome +
               "\nTelefone: " + telefone +
               "\nEmail: " + email +
               "\nIdade: " + idade;
    }
}