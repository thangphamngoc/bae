package com.bae.cronJobs;//package com.example.onekids_project.cronjobs;
//
//import com.example.onekids_project.firebase.servicecustom.FirebaseService;
//import com.example.onekids_project.service.servicecustom.SmsSendService;
//import com.google.firebase.messaging.FirebaseMessagingException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class BirthdayCronjobs {
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private FirebaseService firebaseService;
//
//    @Autowired
//    private SmsSendService smsSendService;
//
//    /*
//    gửi sinh nhật firebase, sms tự động 8h sáng hàng ngày
//     */
//    @Scheduled(cron = "0 0 8 * * ?")
//    protected void executeInternal() throws FirebaseMessagingException {
//        logger.info("--------Start send birthday auto--------");
//        firebaseService.sendAutoFirebaseBirthday();
//        smsSendService.sendAutoSmsBirthday();
//        logger.info("--------End send birthday auto--------");
//    }
//}
