package ru.geekmarket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.geekmarket.persist.model.Role;
import ru.geekmarket.persist.model.User;
import ru.geekmarket.persist.repo.RoleRepository;
import ru.geekmarket.persist.repo.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class GeekMarketUiApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testAdminUser() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("admin", users.get(0).getUserName());
        assertTrue(users.get(0).getRoles().contains(new Role("ROLE_ADMIN")));
    }

    @Test
    public void testUserRoles() {
        List<Role> roles = roleRepository.findAll();
        assertNotNull(roles);
        assertEquals(2, roles.size());
    }

}
