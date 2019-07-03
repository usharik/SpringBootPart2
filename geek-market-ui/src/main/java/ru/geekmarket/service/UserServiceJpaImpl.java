package ru.geekmarket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.geekmarket.persist.model.Role;
import ru.geekmarket.persist.model.User;
import ru.geekmarket.persist.repo.RoleRepository;
import ru.geekmarket.persist.repo.UserRepository;
import ru.geekmarket.service.repr.SystemUser;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
public class UserServiceJpaImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceJpaImpl.class);

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceJpaImpl(UserRepository userRepository, RoleRepository roleRepository,
                              BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<SystemUser> findById(Long id) {
        return userRepository.findById(id).map(SystemUser::new);
    }

    @Override
    public Optional<SystemUser> findByUserName(String username) {
        return userRepository.findOneByUserName(username).map(SystemUser::new);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public boolean save(SystemUser systemUser) {
        User user = systemUser.getId() != null ? userRepository
                .findById(systemUser.getId())
                .orElse(new User()) : new User();
        user.setUserName(systemUser.getUserName());
        if (systemUser.getId() == null || (systemUser.getPassword() != null && !systemUser.getPassword().trim().isEmpty())) {
            user.setPassword(passwordEncoder.encode(systemUser.getPassword()));
        }
        user.setFirstName(systemUser.getFirstName());
        user.setLastName(systemUser.getLastName());
        user.setEmail(systemUser.getEmail());
        user.setRoles(new HashSet<>(Collections.singletonList(roleRepository.findOneByName("ROLE_CLIENT"))));
        userRepository.save(user);
        return true;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<SystemUser> findAll() {
        return userRepository.findAll().stream()
                .map(SystemUser::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<SystemUser> user = findByUserName(userName);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        try {
            return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(),
                    mapRolesToAuthorities(user.get().getRoles()));
        } catch (Exception ex) {
            logger.error("", ex);
            throw new BadCredentialsException("Internal error. Try again latter.");
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
