package com.basic.next.encryption;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JasyptTest {


    @Test
    public void Test(){
        String mysqlUserName = "username";
        String mysqlPassword = "pwd";
        String mysqlUrl = "jdbc:mariadb://host:3306/db_name?serverTimezone=UTC&autoReconnect=true&allowMultiQueries=true";

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(2);
        encryptor.setPassword("test");
        encryptor.setAlgorithm("PBEWithMD5AndDES");

        // when
        String encryptedTextMysqlUserName = encryptor.encrypt(mysqlUserName);
        System.out.println("mysqlUserName 암호화 값 : " + encryptedTextMysqlUserName);

        String encryptedTextMysqlPassword = encryptor.encrypt(mysqlPassword);
        System.out.println("mysqlPassword 암호화 값 : " + encryptedTextMysqlPassword);


        String encryptedTextMysqlUrl = encryptor.encrypt(mysqlUrl);
        System.out.println("mysqlUrl 암호화 값 : " + encryptedTextMysqlUrl);

        String decryptedTextMysqlUserName = encryptor.decrypt(encryptedTextMysqlUserName);
        String decryptedTextMysqlPassword = encryptor.decrypt(encryptedTextMysqlPassword);
        String decryptedTextMysqlUrl = encryptor.decrypt(encryptedTextMysqlUrl);

        // then
        assertThat(mysqlUserName).isEqualTo(decryptedTextMysqlUserName);
        assertThat(mysqlPassword).isEqualTo(decryptedTextMysqlPassword);
        assertThat(mysqlUrl).isEqualTo(decryptedTextMysqlUrl);
    }
}
