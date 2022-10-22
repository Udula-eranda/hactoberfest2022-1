package com.example.InventoryApp;

import com.example.InventoryApp.user.Role;
import com.example.InventoryApp.user.User;
import com.example.InventoryApp.user.UserRepositary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRespositaryTests {
    @Autowired
    private UserRepositary repo;

    private TestEntityManager entityManager;

    @Test
    public void testCreateRoles(){
        Role roleAdmin = new Role("Administor");
        Role roleEditor = new Role("Editor");
        Role roleVisitor = new Role("Visitor");

        entityManager.persist(roleAdmin);
        entityManager.persist(roleEditor);
        entityManager.persist(roleVisitor);
    }
    @Test
    public void testCreateNewUserWithOneRole(){
        Role roleAdmin = entityManager.find(Role.class, 1);
        User user = new User("c@gmail.com","c1996");
        user.addRole(roleAdmin);

        repo.save(user);

    }
    @Test
    public void testCreateNewUserWithTwoRoles(){
        Role roleEditor = entityManager.find(Role.class, 2);
        Role roleVisitor = entityManager.find(Role.class, 3);

        User user = new User("d@gmail.com","d1996");
        user.addRole(roleEditor);
        user.addRole(roleVisitor);

        repo.save(user);

    }

}
