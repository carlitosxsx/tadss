package exercicio;

import java.util.Set;
import redis.clients.jedis.RedisClient;
import redis.clients.jedis.params.SetParams;

public class Exercicio {
    public static void main(String[] args) {
        RedisClient redis = RedisClient.create("redis://localhost:6379");
        for (int i = 1; i < 10; i++) {
            redis.set("chave " + i, "valor " + i, SetParams.setParams().ex(30));
        }
        Set<String> keys = redis.keys("");
        for (String key : keys) {
            System.out.println(key + ":" + redis.get(key));
        }
        redis.close();
    }
}