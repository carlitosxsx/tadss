package br.univille.NoSQL.Redis.Exercicio7.dao;

import br.univille.NoSQL.Redis.Exercicio7.model.*;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContatoDAO {

    private Jedis redis;

    public ContatoDAO() {
        redis = new Jedis("localhost", 6379);
    }

    private String gerarChave(String nome) {
        return "contatos:" + nome;
    }

    // CREATE
    public void salvar(Contato contato) {

        String chave = gerarChave(contato.getNome());

        redis.hset(chave, "nome", contato.getNome());
        redis.hset(chave, "sobrenome", contato.getSobrenome());
        redis.hset(chave, "telefone", contato.getTelefone());
        redis.hset(chave, "idade", contato.getIdade());
    }

    // READ
    public List<Contato> listarTodos() {

        List<Contato> contatos = new ArrayList<>();

        Set<String> keys = redis.keys("contatos:*");

        for (String key : keys) {

            Map<String, String> dados = redis.hgetAll(key);

            Contato contato = new Contato(
                    dados.get("nome"),
                    dados.get("sobrenome"),
                    dados.get("telefone"),
                    dados.get("idade")
            );

            contatos.add(contato);
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