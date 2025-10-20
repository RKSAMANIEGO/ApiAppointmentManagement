package com.project.appointmentmangement.database.entity;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import jakarta.persistence.*;
import java.util.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    @GeneratedValue()
    private UUID id;

    @Column( nullable = false, length = 100)
    private String email;

    @Column(unique = true, nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(name = "is_enabled")
    @Builder.Default
    private Boolean isEnabled = true;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER )
    private List<UserRolesEntity> roles;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
}
