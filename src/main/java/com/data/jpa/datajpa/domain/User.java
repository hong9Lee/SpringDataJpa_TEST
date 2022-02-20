package com.data.jpa.datajpa.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Column(updatable = false)
    private LocalDateTime createdAt;

//    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient // 영속성 처리에 제외됨.
    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
