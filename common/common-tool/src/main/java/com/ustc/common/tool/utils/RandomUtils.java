package com.ustc.common.tool.utils;

import java.util.Random;
import java.util.UUID;

/**
 * ClassName: RandomUtils
 * Package: com.ustc.common.tool.utils
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/28 15:28
 * @Version 1.0
 */
public class RandomUtils {

    public static Integer randomNumber(int size) {
        return Integer.valueOf(generator(size, "0123456789"));
    }

    public static String generator() {
        return generator(6);
    }

    public static String generator(int capacity) {
        return generator(capacity, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
    }

    public static String generator(int capacity, String randomString) {
        StringBuilder builder = new StringBuilder(capacity);
        for (int i = 0; i < capacity; i++) {
            char ch = randomString.charAt(new Random().nextInt(randomString.length()));
            builder.append(ch);
        }
        return String.valueOf(builder);
    }

    public static String uuid() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }

}
