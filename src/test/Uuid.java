package test;

import java.util.UUID;

/**
 * Author: Zhang Yan
 * Date: 19-10-21 下午8:17
 * Content:
 */
public class Uuid {
    public static void main(String[] args) {
        for (;;){
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }

    }
}
