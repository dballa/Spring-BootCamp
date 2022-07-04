package com.ikubinfo.ioc;

import com.ikubinfo.ioc.entities.CommentEntity;
import com.ikubinfo.ioc.entities.PostEntity;
import com.ikubinfo.ioc.entities.RoleEntity;
import com.ikubinfo.ioc.entities.UserEntity;
import com.ikubinfo.ioc.repositories.CommentRepository;
import com.ikubinfo.ioc.repositories.PostRepository;
import com.ikubinfo.ioc.repositories.RoleRepository;
import com.ikubinfo.ioc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/jpa")
public class TestJpaResource {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping
    private List<CommentEntity> exchange() {

        return commentRepository.getAllComments(1,2);


    }

    public static RoleEntity createRole() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("Admin");
        roleEntity.setDescription("Admin description");
        roleEntity.setCreatedOn(LocalDateTime.now());
        return roleEntity;
    }

    public static UserEntity createUser() {
        UserEntity user = new UserEntity();
        user.setFirstName("userTestInClass");
        user.setLastName("class");
        user.setEmail("doland1@gmail.com");
        user.setPassword("doland");
        user.setUsername("test123");
        user.setValid(Boolean.TRUE);
        user.setCreatedOn(LocalDateTime.now());
        return user;
    }
}
