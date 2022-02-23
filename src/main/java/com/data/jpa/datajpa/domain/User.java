package com.data.jpa.datajpa.domain;

import com.data.jpa.datajpa.domain.listener.Auditable;
import com.data.jpa.datajpa.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
@EntityListeners(value = {UserEntityListener.class})
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User extends BaseEntity implements Auditable{

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;

//    @Column(insertable = false)
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient // 영속성 처리에 제외됨.
    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

    /*
    @PrePersist insert 전 호출
    @PreUpdate  merge 전 호출
    @PreRemove delete 전 호출
    @PostPersist insert 후 호출
    @PostUpdate
    @PostRemove
    @PostLoad select 일어난 직후



    @PrePersist
    public void prePersist() {
        System.out.println(">>>>>>>>>>>>>>>>>> prePersist !!!!!!!!!!!");
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println(">>>>>>> preUpdate ");
        this.updatedAt = LocalDateTime.now();
    }
    */
    /*
    @PostPersist
    public void postPersist() {
        System.out.println(">>>>>>>>>>>> postPersist !!!!");
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println(">>>>>>>>>. post Update");
    }

    @PreRemove
    public void preRemove() {
        System.out.println("pre remove ~~");
    }

    @PostRemove
    public void postRemove() {
        System.out.println("post remove !!");
    }

    @PostLoad
    public void postLoad() {
        System.out.println(">>>>>>>>. post lo ad ~");
    }
     */

}
