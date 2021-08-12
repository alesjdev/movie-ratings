package com.alesjdev.movierating.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    // Validation(s)
    @NotBlank(message = "Must specify an username")
    @Size(min = 3, message = "Username must be at least 3 characters long")
    @Size(max = 25, message = "Username must be 25 characters at max")
    private String username;

    @Column(name = "password")
    // Validation(s)
    @NotBlank(message = "Must specify a password")
    @Size(min = 4, message = "Password must be at least 4 characters long")
    @Size(max = 70, message = "Password must be 70 characters at max")
    private String password;

    @Column(name = "email")
    // Validation(s)
    @NotBlank(message = "Must specify a valid email address")
    @Email(message = "That is not a valid email address")
    private String email;

    @Column(name = "about_me")
    @Size(max = 500, message = "Bio must contain 500 characters max")
    private String aboutMe;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Review> reviewList = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> authorities;


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(Set<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    // Convenience methods to add / delete reviews from the user
    public void addReview(Review review){
        this.reviewList.add(review);
        review.setUser(this);
    }
    public void removeReview(Review review){
        this.reviewList.remove(review);
        review.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
