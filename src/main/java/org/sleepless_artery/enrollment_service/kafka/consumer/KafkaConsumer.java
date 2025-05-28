package org.sleepless_artery.enrollment_service.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.sleepless_artery.enrollment_service.service.EnrollmentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final EnrollmentService enrollmentService;

    @KafkaListener(topics = "user.profiles.deleted", groupId = "enrollment-service")
    public void listenUserDeletedEvent(@Header(KafkaHeaders.RECEIVED_KEY) String key) {
        enrollmentService.deleteEnrollmentsByStudentId(Long.parseLong(key));
    }

    @KafkaListener(topics = "course.courses.deleted", groupId = "enrollment-service")
    public void listen(Long courseId) {
        enrollmentService.deleteEnrollmentsByCourseId(courseId);
    }
}
