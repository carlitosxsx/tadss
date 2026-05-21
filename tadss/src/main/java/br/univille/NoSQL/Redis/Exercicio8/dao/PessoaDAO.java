package br.univille.NoSQL.Redis.Exercicio8.dao;

import java.util.HashMap;
import java.util.Map;
import br.univille.NoSQL.Redis.Exercicio8.model.Pessoa;
import redis.clients.jedis.Jedis;

public class PessoaDAO {

    private HashMap<String, byte[]> banco;
    private Jedis redis;

    public PessoaDAO() {
        banco = new HashMap<>();
        redis = new Jedis("localhost", 6379);
    }

    public void create(Pessoa pessoa) throws Exception {

        banco.put(
                pessoa.getApelido(),
                pessoa.serializar()
        );
    }

    public Pessoa read(String apelido) throws Exception, ClassNotFoundException {

        byte[] dados = banco.get(apelido);

        if (dados == null) {
            return null;
        }

        return Pessoa.desserializar(dados);
    }

    public boolean update(Pessoa pessoa) throws Exception {

        if (!banco.containsKey(pessoa.getApelido())) {
            return false;
        }

        banco.put(
                pessoa.getApelido(),
                pessoa.serializar()
        );

        return true;
    }

    public boolean delete(String apelido) {

        if (banco.containsKey(apelido)) {
            banco.remove(apelido);
            return true;
        }

        return false;
    }

    public void listar() throws Exception, ClassNotFoundException {

        for (Map.Entry<String, byte[]> entry : banco.entrySet()) {

            Pessoa pessoa =
                    Pessoa.desserializar(entry.getValue());

            System.out.println(pessoa);
        }
    }
}