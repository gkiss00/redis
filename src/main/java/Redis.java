import redis.clients.jedis.*;
import model.*;

import java.io.File;
import java.util.*;

class Redis {
    public static final List<User> users = new ArrayList<>();

    private static void populate(Jedis jedis) throws Exception{
        List<String> names = new ArrayList<>();
        File f = new File("resources/names.txt");
        Scanner scan = new Scanner(f);
        while(scan.hasNextLine()){
            String name = scan.nextLine();
            names.add(name);
        }

        Random rand = new Random();
        for (int i = 0; i < 50; ++i) {
            User user = new User(names.get(rand.nextInt(names.size())));
            jedis.set(user.key, user.firstName);
            users.add(user);
        }
    }
    public static void main(String[]args) {
        System.out.println("Redis");
        try {
            JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);

            Jedis jedis = jedisPool.getResource();
            populate(jedis);
            for (int i = 0; i < users.size(); ++i) {
                System.out.println(users.get(i).key + " : " + jedis.get(users.get(i).key));
            }
        } catch (Exception e){
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
    }
}