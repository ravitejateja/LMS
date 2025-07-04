package com.enrollment;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EnrollmentService {

    private final WebClient webClient;

    public EnrollmentService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> enroll(String userId, String courseId) {
        Mono<String> userInfo = webClient.get()
                .uri("http://user-service/users/" + userId)
                .retrieve()
                .bodyToMono(String.class);

        Mono<String> courseInfo = webClient.get()
                .uri("http://course-service/courses/" + courseId)
                .retrieve()
                .bodyToMono(String.class);

        return Mono.zip(userInfo, courseInfo)
                .map(tuple -> "✅ Enrollment successful: " + tuple.getT1() + " enrolled in " + tuple.getT2());
    }
}