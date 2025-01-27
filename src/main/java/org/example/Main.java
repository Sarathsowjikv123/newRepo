package org.example;
import redis.clients.jedis.Jedis;
public class Main {
    public static void main(String[] args) {
        // Connect to Redis server
        try (Jedis jedis = new Jedis("redis-16777.c330.asia-south1-1.gce.redns.redis-cloud.com", 16777)) {
            System.out.println("Connected to Redis");
            jedis.auth("default", "MGGPCBFeDJOMZSyQ3L2jyzF73vSm2DYz");
            // Store a value

            jedis.sadd("newNames", "Sarath", "Praba", "Vinoth" );
            System.out.println("Added a set to redis !!!");

            // Retrieve the value
            String value = jedis.get("key");
            System.out.println("Retrieved value for 'key': " + value);

            // Example of setting a value with an expiration time (5 seconds)
            jedis.setex("tempKey", 5, "temporaryValue");
            System.out.println("Stored 'tempKey' with expiration of 5 seconds");
            System.out.println("Chenges Made in newBranch.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}