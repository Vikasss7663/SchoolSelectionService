package com.school.selection.listener;

import com.school.management.schema.student.StudentEvent;
import com.school.management.schema.student.StudentEventKey;
import com.school.selection.model.AkashAcademyStudent;
import com.school.selection.model.JhunjhunuAcademyStudent;
import com.school.selection.service.AkashAcademyStudentService;
import com.school.selection.service.JhunjhunuAcademyStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.school.selection.constants.ApplicationsConstants.TOPIC_NAME;

@Component
@Slf4j
@RequiredArgsConstructor
public class StudentListener {

    private final AkashAcademyStudentService akashAcademyStudentService;
    private final JhunjhunuAcademyStudentService jhunjhunuAcademyStudentService;

    private final String AKASH_ACADEMY_NAME = "Akash Academy";
    private final String JHUNJHUNU_ACADEMY_NAME = "Jhunjhunu Academy";

    @KafkaListener(topics = TOPIC_NAME)
    public void listen(ConsumerRecord<StudentEventKey, StudentEvent> record) {

        StudentEventKey studentEventKey = record.key();
        StudentEvent studentEvent = record.value();
        String topicName = record.topic();
        int partition = record.partition();
        long offset = record.offset();

        String schoolName = studentEvent.getSchoolName().toString();

        if (schoolName.equals(JHUNJHUNU_ACADEMY_NAME)) {

            JhunjhunuAcademyStudent student = new JhunjhunuAcademyStudent();
            student.setStudentId((int) studentEvent.getStudentId());
            student.setStudentName(studentEvent.getStudentName().toString());
            student.setStudentSemester((int) studentEvent.getStudentSemester());
            student.setStudentYear((int) studentEvent.getStudentYear());
            jhunjhunuAcademyStudentService.addStudent(student);

        } else if(schoolName.equals(AKASH_ACADEMY_NAME)) {

            AkashAcademyStudent student = new AkashAcademyStudent();
            student.setStudentId((int) studentEvent.getStudentId());
            student.setStudentName(studentEvent.getStudentName().toString());
            student.setStudentSemester((int) studentEvent.getStudentSemester());
            student.setStudentYear((int) studentEvent.getStudentYear());
            akashAcademyStudentService.addStudent(student);

        }

        log.debug("\n\n\n\n");
        log.debug("Topic Name: " + topicName);
        log.debug("Partition: " + partition);
        log.debug("Offset: " + offset);
        log.debug("Key: " + studentEventKey);
        log.debug("Value: " + studentEvent);
        log.debug("\n\n\n\n");

    }

}

/*

@toString() method
ConsumerRecord(
    topic = Kafka-Example,
    partition = 0,
    leaderEpoch = 0,
    offset = 2,
    CreateTime = 1649385320111,
    serialized key size = 12,
    serialized value size = 26,
    headers = RecordHeaders(headers = [], isReadOnly = false),
    key = {"studentId": 3, "studentSemester": 8, "studentYear": 2018},
    value = {"studentId": 3, "studentName": "Rupesh Yadav", "studentSemester": 8, "studentYear": 2018}
)


@Object
GenericMessage [
    payload={"studentId": 9, "studentName": "Rupesh Yadav", "studentSemester": 8, "studentYear": 2018},
    headers={
        kafka_offset=8,
        kafka_consumer=org.apache.kafka.clients.consumer.KafkaConsumer@3d04b4cc,
        kafka_timestampType=CREATE_TIME,
        kafka_receivedPartitionId=0,
        kafka_receivedMessageKey={"studentId": 9, "studentSemester": 8, "studentYear": 2018},
        kafka_receivedTopic=Kafka-Example, kafka_receivedTimestamp=1649385969411,
        kafka_groupId=school-service
    }
]

 */