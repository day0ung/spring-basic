package com.basic.next.encryption;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.encryption.pbe.config.StringPBEConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableEncryptableProperties
public class JasyptConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "jasypt.encryptor")
    public StringPBEConfig stringPBEConfig() {
        return new SimpleStringPBEConfig();
    }

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor(StringPBEConfig stringPBEConfig) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(stringPBEConfig);
        return encryptor;
    }

//    public static final String ALGORITHM = "PBEWithMD5AndDES";
//    @Bean("jasyptStringEncryptor")
//    public StringEncryptor stringEncryptor() {
//        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//        config.setPassword(getPassword());
//
//        config.setAlgorithm(ALGORITHM);
//        config.setKeyObtentionIterations("1000");
//        config.setPoolSize("1");
//        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//        config.setStringOutputType("base64");
//        encryptor.setConfig(config);
//        return encryptor;
//    }
//
//    public static String getDecryptedString(String str) {
//        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
//        jasypt.setPassword(getPassword());
//        jasypt.setAlgorithm(ALGORITHM);
//        return jasypt.decrypt(str);
//    }
//
//    private static String getPassword() {
//        try {
//            File file = new File("./encryption_key.txt");
//            if (file.exists())
//                return Files.readAllLines(file.getAbsoluteFile().toPath()).get(0);
//            file = new File(Paths.get("").toAbsolutePath().toString() + "/encryption_key.txt");
//            if (file.exists()) {
//                return Files.readAllLines(file.getAbsoluteFile().toPath()).get(0);
//            }
//        } catch (Exception e) {
//            logger.error("[JasyptConfig] getPassword ERROR!", e);
//
//        }
//
//        return "";
//    }
//    https://velog.io/@ssol_916/Jasypt%EC%9C%BC%EB%A1%9C-properties-%EC%95%94%ED%98%B8%ED%99%94
}
