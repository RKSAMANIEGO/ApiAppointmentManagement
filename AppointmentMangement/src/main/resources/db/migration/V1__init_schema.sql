CREATE TABLE `permissions`
(
    id              VARCHAR(36) NOT NULL DEFAULT (UUID()),
    name            VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `roles`(
   id               VARCHAR(36) NOT NULL DEFAULT (UUID()),
   role_name        VARCHAR(50)  NOT NULL,
   PRIMARY KEY(`id`)
);

CREATE TABLE `role_permissions`
(
    id              VARCHAR(36) NOT NULL DEFAULT (UUID()),
    permission_id   VARCHAR(36) NOT NULL,
    role_id         VARCHAR(36) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_permission` FOREIGN KEY (permission_id) REFERENCES `permissions` (`id`),
    CONSTRAINT `fk_role` FOREIGN KEY (role_id) REFERENCES `roles` (`id`)
);

CREATE TABLE `users`(
    id              VARCHAR(36) NOT NULL DEFAULT (UUID()),
    email           VARCHAR(100) NOT NULL,
    username        VARCHAR(100) NOT NULL,
    password        VARCHAR(255) NOT NULL,
    is_enabled      TINYINT(1) DEFAULT 1,
    PRIMARY KEY (`id`)
);

CREATE TABLE `user_roles`(
    id              VARCHAR(36) NOT NULL DEFAULT (UUID()),
    role_id         VARCHAR(36) NOT NULL,
    user_id         VARCHAR(36) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_role_user` FOREIGN KEY (role_id) REFERENCES  `roles` (`id`),
    CONSTRAINT `fk_user_role` FOREIGN KEY (user_id) REFERENCES `users` (`id`)
);

CREATE TABLE `profiles`(
    id              VARCHAR(36) NOT NULL DEFAULT (UUID()),
    user_id         VARCHAR(36) NOT NULL,
    name            VARCHAR(100) NOT NULL,
    lastname        VARCHAR(100) NOT NULL,
    specialty       VARCHAR(100) NULL DEFAULT NULL,
    experience      VARCHAR(100) NULL DEFAULT NULL,
    phone           VARCHAR(15)  NULL DEFAULT NULL,
    is_enabled      TINYINT(1) DEFAULT 1,
    CONSTRAINT `fk_profiles_user` FOREIGN KEY (user_id) REFERENCES `users`(`id`),
    PRIMARY KEY (id)
);

CREATE TABLE `pets`(
    id              VARCHAR(36) NOT NULL DEFAULT (UUID()),
    duenio_id       VARCHAR(36) NOT NULL,
    name            VARCHAR(60) NOT NULL,
    race            VARCHAR(60) NULL DEFAULT NULL,
    genre           ENUM('F','M') NOT NULL,
    age             INT NOT NULL,
    registry_datetime  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    state ENUM('ACTIVO','INACTIVO') NOT NULL,
    is_enabled TINYINT(1) DEFAULT 1,
    CONSTRAINT `fk_pets_user` FOREIGN KEY (duenio_id) REFERENCES `profiles`(`id`),
    PRIMARY KEY (id)
);

CREATE TABLE `medical_records`(
    id              VARCHAR(36) NOT NULL DEFAULT (UUID()),
    pet_id          VARCHAR(36) NOT NULL,
    observation     TEXT NULL DEFAULT NULL,
    CONSTRAINT `fk_medical_records_pet` FOREIGN KEY (pet_id) REFERENCES `pets`(`id`),
    PRIMARY KEY (id)
);

CREATE TABLE `medical_records_details`(
    id                  VARCHAR(36) NOT NULL DEFAULT (UUID()),
    registry_datetime   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    medical_record_id   VARCHAR(36) NOT NULL,
    diagnosis           VARCHAR(255) NULL DEFAULT NULL,
    reason              VARCHAR(255) NOT NULL,
    treatment           VARCHAR(255) NULL DEFAULT NULL,
    CONSTRAINT `fk_medical_record_details` FOREIGN KEY (medical_record_id) REFERENCES `medical_records`(`id`),
    PRIMARY KEY (id)
);

CREATE TABLE `service_types`(
    id                  VARCHAR(36) NOT NULL DEFAULT (UUID()),
    service_type        VARCHAR(50) NOT NULL,
    is_enabled          TINYINT(1) DEFAULT 1,
    PRIMARY KEY (id)
);

CREATE TABLE `services`(
    id                      VARCHAR(36) NOT NULL DEFAULT (UUID()),
    service_type_id         VARCHAR(36) NOT NULL,
    name                    VARCHAR(60) NOT NULL,
    description             VARCHAR(255) NULL DEFAULT NULL,
    duration_attention      INT NULL DEFAULT 0,
    price                   DECIMAL(8,2) NULL DEFAULT NULL,
    state                   ENUM('ACTIVO','INACTIVO') NULL DEFAULT NULL,
    CONSTRAINT `fk_service_type` FOREIGN KEY (service_type_id) REFERENCES `service_types`(`id`),
    PRIMARY KEY (id)
);

CREATE TABLE `appointment`(
    id                          VARCHAR(36) NOT NULL DEFAULT (UUID()),
    pet_id                      VARCHAR(36) NOT NULL,
    veterinarian_id             VARCHAR(36) NOT NULL,
    appointment_datetime        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    reason                      VARCHAR(255) NOT NULL,
    ubication                   VARCHAR(255) NOT NULL,
    appointment_type            ENUM('DOMICILIO','PRESENCIAL') NOT NULL,
    state                       ENUM('PENDIENTE','CANCELADO','RESERVADO','REPROGRAMADO') NOT NULL,
    is_enabled                  TINYINT(1) DEFAULT 1,
    CONSTRAINT `fk_appointment_pet` FOREIGN KEY (pet_id) REFERENCES `pets`(`id`),
    CONSTRAINT `fk_veterinarian` FOREIGN KEY  (veterinarian_id) REFERENCES `profiles`(`id`),
    PRIMARY KEY (id)
);

CREATE TABLE `appointment_services` (
    id VARCHAR(36) NOT NULL DEFAULT (UUID()),
    service_id VARCHAR(36) NOT NULL,
    appointment_id VARCHAR(36) NOT NULL,
    CONSTRAINT `fk_appointment_service_id` FOREIGN KEY (service_id) REFERENCES `services`(`id`),
    CONSTRAINT `fk_service_appointment_id` FOREIGN KEY (appointment_id) REFERENCES `appointment`(`id`),
    PRIMARY KEY(id)
);

CREATE TABLE `recipes`(
    id                          VARCHAR(36) NOT NULL DEFAULT (UUID()),
    medical_record_details_id   VARCHAR(36) NOT NULL,
    appointment_id              VARCHAR(36) NOT NULL,
    datetime                    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    description                 VARCHAR(255) NULL DEFAULT NULL,
    medications                 VARCHAR(255) NULL DEFAULT NULL,
    CONSTRAINT `fk_recipes_medical_records` FOREIGN KEY (medical_record_details_id) REFERENCES `medical_records_details`(`id`),
    CONSTRAINT `fk_recipes_appointment` FOREIGN KEY (appointment_id) REFERENCES `appointment`(`id`),
    PRIMARY KEY (id)
);

CREATE TABLE `documents`(
    id VARCHAR(36) NOT NULL DEFAULT (UUID()),
    name_file VARCHAR(100) NULL DEFAULT NULL,
    type_file VARCHAR(60) NULL DEFAULT NULL,
    path_file TEXT NULL DEFAULT NULL DEFAULT NULL,
    entity_type VARCHAR(100) NULL DEFAULT NULL,
    entity_id VARCHAR(36) NULL DEFAULT NULL,
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_enabled TINYINT(1) DEFAULT 1,
    PRIMARY KEY(id)
)


