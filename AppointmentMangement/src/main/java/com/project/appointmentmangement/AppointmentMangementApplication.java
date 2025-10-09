package com.project.appointmentmangement;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.project.appointmentmangement.database.repository.*;
import com.project.appointmentmangement.database.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.*;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class AppointmentMangementApplication implements CommandLineRunner {

    private final IRolePermissionRepository rolePermissionRepository;
    private final IPermissionRepository permissionRepository;
    private final IUserRolesRepository userRolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleRepository roleRepository;
    private final IUserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppointmentMangementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // permissions
        PermissionEntity permissionEntity1 = new PermissionEntity();
        PermissionEntity permissionEntity2 = new PermissionEntity();
        PermissionEntity permissionEntity3 = new PermissionEntity();
        PermissionEntity permissionEntity4 = new PermissionEntity();
        if(permissionRepository.count() == 0 ){
             permissionEntity1 =  PermissionEntity.builder()
                    .name("PERMISSION_01")
                    .build();
             permissionEntity2 =  PermissionEntity.builder()
                    .name("PERMISSION_02")
                    .build();
             permissionEntity3 =  PermissionEntity.builder()
                    .name("PERMISSION_03")
                    .build();
             permissionEntity4 =  PermissionEntity.builder()
                    .name("PERMISSION_04")
                    .build();
            permissionRepository.saveAll(List.of(permissionEntity1,permissionEntity2,permissionEntity3,permissionEntity4));
        }

        // roles
        RoleEntity role1=new RoleEntity();
        RoleEntity role2=new RoleEntity();
        RoleEntity role3=new RoleEntity();
        if(roleRepository.count() == 0){
             role1= RoleEntity.builder().roleName("ADMIN").build();
             role2= RoleEntity.builder().roleName("USER").build();
             role3= RoleEntity.builder().roleName("VETERINARIO").build();
            roleRepository.saveAll(List.of(role1,role2,role3));
        }

        // rolePermissions
        if(rolePermissionRepository.count() == 0){
            RolPermissionEntity rolePermissionAdmin1 = RolPermissionEntity.builder()
                    .permission(permissionEntity1)
                    .role(role1)
                    .build();
            RolPermissionEntity rolePermissionAdmin2 = RolPermissionEntity.builder()
                    .permission(permissionEntity2)
                    .role(role1)
                    .build();
            RolPermissionEntity rolePermissionAdmin3 = RolPermissionEntity.builder()
                    .permission(permissionEntity3)
                    .role(role1)
                    .build();
            RolPermissionEntity rolePermissionAdmin4 = RolPermissionEntity.builder()
                    .permission(permissionEntity4)
                    .role(role1)
                    .build();
            RolPermissionEntity rolePermissionUser1 = RolPermissionEntity.builder()
                    .permission(permissionEntity1)
                    .role(role2)
                    .build();
            RolPermissionEntity rolePermissionUser2 = RolPermissionEntity.builder()
                    .permission(permissionEntity2)
                    .role(role2)
                    .build();
            RolPermissionEntity rolePermissionVeterinario1 = RolPermissionEntity.builder()
                    .permission(permissionEntity1)
                    .role(role3)
                    .build();
            RolPermissionEntity rolePermissionVeterinario2 = RolPermissionEntity.builder()
                    .permission(permissionEntity2)
                    .role(role3)
                    .build();
            RolPermissionEntity rolePermissionVeterinario3 = RolPermissionEntity.builder()
                    .permission(permissionEntity3)
                    .role(role3)
                    .build();
            rolePermissionRepository.saveAll(List.of(rolePermissionAdmin1,rolePermissionAdmin2,rolePermissionAdmin3,rolePermissionAdmin4,rolePermissionVeterinario1,rolePermissionVeterinario2,rolePermissionVeterinario3,rolePermissionUser1,rolePermissionUser2));
        }

        // users
        UserEntity user1=new UserEntity();
        UserEntity user2=new UserEntity();
        UserEntity user3=new UserEntity();
        if(userRepository.count() == 0){
             user1=UserEntity.builder().email("enrike@gmail.com").username("esamanig").password(passwordEncoder.encode("enrike123")).profile(null) .build();
             user2=UserEntity.builder().email("angie@gmail.com").username("asamanig").password(passwordEncoder.encode("angie123")).profile(null).build();
             user3=UserEntity.builder().email("stefano@gmail.com").username("bsamanig").password(passwordEncoder.encode("stefano123")).profile(null).build();
             userRepository.saveAll(List.of(user1,user2,user3));
        }

        // userRoles
        if(userRolesRepository.count() == 0){
            UserRolesEntity userRole1 = UserRolesEntity.builder().role(role1).user(user1).build();
            UserRolesEntity userRole2 = UserRolesEntity.builder().role(role2).user(user2).build();
            UserRolesEntity userRole3 = UserRolesEntity.builder().role(role3).user(user3).build();
            userRolesRepository.saveAll(List.of(userRole1,userRole2,userRole3));
        }



    }
}
