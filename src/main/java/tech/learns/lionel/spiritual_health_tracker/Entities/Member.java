package tech.learns.lionel.spiritual_health_tracker.Entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    @Column(name = "name")
    private String name;

    // @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private MemberAuth memberAuth;

    @Column(name = "birthday")
    private LocalDate birthday;
    
    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private String contact;

    @ElementCollection
    @Column(name = "hobbies")
    private List<String> hobbies;

    @JsonIgnore
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Journal> journals;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "member_accountability_buddies",
        joinColumns = @JoinColumn(name = "member_id"),
        inverseJoinColumns = @JoinColumn(name = "buddy_id")
    )
    private List<Member> accountabilityBuddies;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Journal> getJournals() {
        return journals;
    }

    public List<Member> getAccountabilityBuddies() {
        return accountabilityBuddies;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirthday(String birthdayStr) {
        this.birthday = LocalDate.parse(birthdayStr);
        System.out.println( " this.birthday is : "+this.birthday);
    }

    public void setAge(String birthday) {
        this.age = calculateAge(this.birthday);
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

    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }

    public void setAccountabilityBuddies(List<Member> accountabilityBuddies) {
        this.accountabilityBuddies = accountabilityBuddies;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private int calculateAge(LocalDate birthday) {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - birthday.getYear();
        if (now.getDayOfYear() < birthday.getDayOfYear()) {
            age--; // hasn't had birthday yet this year
        }
        return age;
    }
}
