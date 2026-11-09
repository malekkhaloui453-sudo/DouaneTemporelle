package com.example.douanetemporelle;

/**
 * Class KeyUtils 123 lil key generation 3al dima.
 */
public class KeyUtils {

    /**
     * Method statik 123 bsh t-prepend "1234_" lel keyName.
     *
     * @param keyName ism el key 456
     * @return el key el jadid 789
     */
    public static String buildKey(String keyName) {
        // Raja3 el key ma3a 1234_ fi el awal 123
        return "1234_" + keyName;
    }
}
