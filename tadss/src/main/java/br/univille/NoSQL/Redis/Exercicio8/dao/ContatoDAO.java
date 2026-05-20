package br.univille.NoSQL.Redis.Exercicio8.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.univille.NoSQL.Redis.Exercicio8.model.Contato;
import redis.clients.jedis.Jedis;

public class ContatoDAO {

    private Jedis redis;

    public ContatoDAO() {
        redis = new Jedis("localhost", 6379);
    }

    private String gerarChave(String nome) {
        return "contatos:" + nome;
    }

    // CREATE
    public void salvar(Contato contato) throws Exception {

        String chave = gerarChave(contato.getNome());
        byte[] objetoSerializado = contato.serializarObjeto();

        redis.set(chave.getBytes(), objetoSerializado);
    }

    // READ
    public List<Contato> listarTodos() throws Exception {

    List<Contato> contatos = new ArrayList<>();

    Set<String> keys = redis.keys("contatos:*");

    for (String key : keys) {

        byte[] bytes = redis.get(key.getBytes());

        if (bytes != null) {

            Contato contato = Contato.desserializarObjeto(bytes);

            contatos.add(contato);
        }
    }

    return contatos;
}

    // DELETE
    public boolean excluir(String nome) {

        String chave = gerarChave(nome);

        return redis.del(chave) > 0;
    }

    // UPDATE
    public boolean atualizarCampo(String nome, String campo, String valor) {

        String chave = gerarChave(nome);

        if (!redis.exists(chave)) {
            return false;
        }

        redis.hset(chave, campo, valor);

        return true;
    }

    public boolean existe(String nome) {
        return redis.exists(gerarChave(nome));
    }

    public void fecharConexao() {
        redis.close();
    }

}