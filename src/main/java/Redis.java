import redis.clients.jedis.*;

class Redis {
    public static void main(String[]args) {
        System.out.println("Redis");
        try {
            JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);

            Jedis jedis = jedisPool.getResource();
            jedis.set("mykey", "Hello");
            System.out.println(jedis.get("mykey"));
        } catch (Exception e){
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
    }
}