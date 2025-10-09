package com.project.appointmentmangement.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="documents")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentEntity<T> {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @Column(name = "name_file", nullable = false)
    private String nameFile;

    @Column(name = "type_file" ,nullable = false)
    private String typeFile;

    @Column(name = "path_file", nullable = false)
    private String pathFile;

    @Column(name = "entity_type",  nullable = false)
    private String entityType;

    @Column(name = "entity_id", nullable = false)
    private String entityId;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;

    @Column(name = "is_enabled")
    private boolean isEnabled;
}
