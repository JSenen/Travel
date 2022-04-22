package com.travel.juansenen.util;

import java.security.SecureRandom;

public class Constantes {

    // Cadenas constantes para uso a la conexión JDBC con la base de datos
    public static String ORCDRV="oracle.jdbc.driver.OracleDriver";
    public static String ORCURL="jdbc:oracle:thin:@//localhost:1521/xe";
    public static String ORCUSER="adminweb";
    public static String ORCPASS="1234";

    // Cadenas String mensajes comunes
    public static String NOBD = "No se pudo conectar a la BD";

    // Generador numeros de vuelo aleatorios
    public static String generateRandomString(int length) {

        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();

        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // 0-62 (exclusive), retornos aleatorios 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);
        }

        return sb.toString();
    }

}
