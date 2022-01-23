package hellojpa;

import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private Long id;
    private String name;

    // JPA는 동적으로 객체를 생성해야 하므로 기본 생성자 하나씩 있어야함
    public Member() {

    }

    // 생성자
    public Member(Long id, String name) {

        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
