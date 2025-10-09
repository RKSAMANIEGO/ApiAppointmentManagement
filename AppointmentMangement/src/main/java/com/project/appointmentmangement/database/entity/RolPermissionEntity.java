package com.project.appointmentmangement.database.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.UUID;

@Entity
@Table(name = "role_permissions")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolPermissionEntity {

    @Id
    @JdbcTypeCode((SqlTypes.VARCHAR))
    @Column(columnDefinition = "VARCHAR(36)")
    @GeneratedValue()
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permission_id")
    private PermissionEntity permission;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}
