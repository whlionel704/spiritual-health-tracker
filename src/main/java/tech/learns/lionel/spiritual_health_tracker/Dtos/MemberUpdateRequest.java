package tech.learns.lionel.spiritual_health_tracker.Dtos;

import java.time.LocalDate;
import java.util.List;

public class MemberUpdateRequest {
    private LocalDate birthday;
    private String name;
    private String email;
    private String contact;
    private List<String> hobbies;

    // Getters
    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
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

    // Setters
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
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