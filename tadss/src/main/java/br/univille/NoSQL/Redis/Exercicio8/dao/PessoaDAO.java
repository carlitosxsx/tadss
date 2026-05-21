package br.univille.NoSQL.Redis.Exercicio8.dao;

import br.univille.NoSQL.Redis.Exercicio8.model.Pessoa;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PessoaDAO {

    private Jedis redis;

    private static final String CHAVE = "pessoas";

    public PessoaDAO() {

        redis = new Jedis("localhost", 6379);
    }

    public void salvar(Pessoa pessoa) throws Exception {

        redis.hset(
                CHAVE.getBytes(),
                pessoa.getNome().getBytes(),
                pessoa.serializar()
        );
    }

    public List<Pessoa> listarTodos() throws Exception {

        List<Pessoa> pessoas = new ArrayList<>();

        Map<byte[], byte[]> registros =
                redis.hgetAll(CHAVE.getBytes());

        for (byte[] dados : registros.values()) {

            Pessoa pessoa =
                    Pessoa.desserializar(dados);

            pessoas.add(pessoa);
        }

        return pessoas;
    }

    public Pessoa buscar(String nome) throws Exception {

        byte[] dados = redis.hget(
                CHAVE.getBytes(),
                nome.getBytes()
        );

        if (dados == null) {
            return null;
        }

        return Pessoa.desserializar(dados);
    }

    public boolean excluir(String nome) {

        return redis.hdel(CHAVE, nome) > 0;
    }

    public boolean atualizar(Pessoa pessoa) throws Exception {

        if (!redis.hexists(CHAVE, pessoa.getNome())) {
            return false;
        }

        redis.hset(
                CHAVE.getBytes(),
                pessoa.getNome().getBytes(),
                pessoa.serializar()
        );

        return true;
    }

    public boolean existe(String nome) {

        return redis.hexists(CHAVE, nome);
    }

    public void fecharConexao() {

        redis.close();
    }
}