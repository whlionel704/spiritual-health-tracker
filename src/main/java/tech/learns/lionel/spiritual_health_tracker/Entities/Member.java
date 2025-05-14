package tech.learns.lionel.spiritual_health_tracker.Entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity
// @Getter
// @Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private String contact;

    @ElementCollection
    @Column(name = "hobbies")
    private List<String> hobbies;

    @ElementCollection
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Journal> journals;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}