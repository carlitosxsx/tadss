package br.univille.NoSQL.Redis.Exercicio8.dao;

import br.univille.NoSQL.Redis.Exercicio8.model.Pessoa;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PessoaDAO {

    private Jedis jedis;

    private static final String CHAVE = "pessoas";

    public PessoaDAO() {

        jedis = new Jedis("localhost", 6379);

    }

    public void create(Pessoa pessoa) throws Exception {

        jedis.hset(
                CHAVE.getBytes(),
                pessoa.getApelido().getBytes(),
                pessoa.serializar()
        );
    }

    public Pessoa read(String apelido) throws Exception {

        byte[] dados = jedis.hget(
                CHAVE.getBytes(),
                apelido.getBytes()
        );

        if (dados == null) {
            return null;
        }

        return Pessoa.desserializar(dados);
    }

    public boolean update(Pessoa pessoa) throws Exception {

        if (!jedis.hexists(CHAVE, pessoa.getApelido())) {
            return false;
        }

        jedis.hset(
                CHAVE.getBytes(),
                pessoa.getApelido().getBytes(),
                pessoa.serializar()
        );

        return true;
    }

    public boolean delete(String apelido) {

        return jedis.hdel(CHAVE, apelido) > 0;
    }

    public List<Pessoa> listarTodos() throws Exception {

        List<Pessoa> lista = new ArrayList<>();

        Map<byte[], byte[]> registros =
                jedis.hgetAll(CHAVE.getBytes());

        for (byte[] dados : registros.values()) {

            Pessoa pessoa =
                    Pessoa.desserializar(dados);

            lista.add(pessoa);
        }

        return lista;
    }

    public boolean existe(String apelido) {

        return jedis.hexists(CHAVE, apelido);
    }

    public void fecharConexao() {

        if (jedis != null) {
            jedis.close();
        }
    }
}