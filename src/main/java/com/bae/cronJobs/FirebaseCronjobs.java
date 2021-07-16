package com.bae.cronJobs;//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//
//private final Logger logger = LoggerFactory.getLogger(getClass());
//@Autowired
//private FirebaseService firebaseService;
//
//    /*
//    gửi lại firebase lỗi, 60p quét 1 lần, chạy từ 8h->21h
//     */
//@Scheduled(cron = "${firebase.sendagain}")
//protected void executeInternal() throws FirebaseMessagingException {
//        logger.info("--------Start send again firebase fail auto--------");
//        firebaseService.sendFirebaseFail();
//        logger.info("--------End send again firebase fail auto--------");
//        }