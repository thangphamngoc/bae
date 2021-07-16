package com.bae.fireBase.initial;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * date 2021-03-12 09:02
 *
 * @author Phạm Ngọc Thắng
 */
@Service
public class FCMInitializer {
    private static final Logger logger = LoggerFactory.getLogger(FCMInitializer.class);

    @Value("${app.firebase-teacher-file}")
    private String firebaseConfigPathTeacher;

    @Value("${app.firebase-plus-file}")
    private String firebaseConfigPathPlus;

    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPathParent;

    @Value("${app.firebase-database-file}")
    private String firebaseConfigDataBase;



//    @Bean
//    public void initializeTeacher() {
//        logger.info("---------Start init firebase teacher------------");
//        try {
//            FirebaseOptions optionsTeacher = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPathTeacher).getInputStream())).build();
//
//            FirebaseApp.initializeApp(optionsTeacher, "teacher");
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        }
//    }
//
//
//    @Bean
//    public void initializePlus() {
//        logger.info("-----------Start init firebase plus-------------");
//        try {
//            FirebaseOptions optionsTeacher = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPathPlus).getInputStream())).build();
//
//            FirebaseApp.initializeApp(optionsTeacher, "plus");
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        }
//    }
//
//
//
//    @PostConstruct
//    public void initializeParent() {
//        //parent
//        logger.info("---------Start init firebase parent-----------");
//        try {
//
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPathParent).getInputStream())).build();
//            if (FirebaseApp.getApps().isEmpty()) {
//                FirebaseApp.initializeApp(options, "parent");
//            }
//
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        }
//    }

    @Bean
    public void initializeDataBase() {
        logger.info("-----------Start init database firebase-------------");
        try {
//            FileInputStream serviceAccount =
//                    new FileInputStream(firebaseConfigDataBase);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigDataBase).getInputStream()))
                    .setDatabaseUrl("https://fir-a08d2-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            logger.info("End init database firebase");

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
