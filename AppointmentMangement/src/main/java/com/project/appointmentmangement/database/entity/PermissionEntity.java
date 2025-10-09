package com.project.appointmentmangement.database.entity;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.*;


@Entity
@Table(name = "permissions")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermissionEntity {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    @GeneratedValue()
    private UUID id;

    @Column(nullable = false , length = 50)
    private String name;

    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    private List<RolPermissionEntity> permissionRoles;
}
