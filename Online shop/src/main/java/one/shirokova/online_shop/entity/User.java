package one.shirokova.online_shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Builder
@Data
public class User {
    public User() {}

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column(name = "login")
    @JsonProperty(value = "login")
    private String login;

    @Column(name = "password")
    @JsonProperty(value = "password")
    private String password;

    private long bagId;
}