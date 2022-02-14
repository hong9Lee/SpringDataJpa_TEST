package com.data.jpa.datajpa.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor // 인자 없는 생성자
@AllArgsConstructor // 모든 필드를 받아서 생성
@RequiredArgsConstructor
//@EqualsAndHashCode
@Data
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
