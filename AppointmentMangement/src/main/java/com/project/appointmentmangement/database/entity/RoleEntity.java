package com.project.appointmentmangement.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    @GeneratedValue()
    private UUID id;

    @Column(name = "role_name", length = 50, nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<RolPermissionEntity> permissions;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<UserRolesEntity> roleUsers;
}
