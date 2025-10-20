UPDATE users u JOIN profiles p ON p.user_id = u.id SET u.profile_id = p.id;

ALTER TABLE profiles DROP COLUMN  experience;
ALTER TABLE profiles DROP COLUMN  specialty;
ALTER TABLE profiles DROP FOREIGN KEY fk_profiles_user;
ALTER TABLE profiles DROP COLUMN user_id;

ALTER TABLE users ADD CONSTRAINT fk_users_profiles FOREIGN KEY (profile_id) REFERENCES profiles(id);

CREATE TABLE profiles_user
(
    id      VARCHAR(36) NOT NULL,
    dni     VARCHAR(15) NULL DEFAULT NULL,
    address VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_profile_user FOREIGN KEY (id) REFERENCES profiles(id)
);

CREATE TABLE profiles_veterinarian
(
    id         VARCHAR(36) NOT NULL,
    specialty  VARCHAR(100) NULL DEFAULT NULL,
    experience VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_profile_veterinarian FOREIGN KEY (id) REFERENCES profiles(id)
);