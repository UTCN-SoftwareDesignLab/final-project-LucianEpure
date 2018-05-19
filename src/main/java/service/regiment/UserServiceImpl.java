package service.regiment;

import converter.UserConverter;
import dto.UserDto;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.RoleRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static application.Constants.QUARTERMASTER;

@Service
public class UserServiceImpl implements UserService{

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserConverter userConverter;

    @Autowired
    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository, UserConverter userConverter){
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public void registerAdmin(UserDto user) {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        User dbUser = new User();
        dbUser.setUsername(user.getUsername());
        dbUser.setPassword(enc.encode(user.getPassword()));
        List<Role> userRoles = dbUser.getRoles();
        userRoles.add(roleRepository.findByRoleName(QUARTERMASTER));
        dbUser.setRoles(userRoles);
        userRepository.save(dbUser);
    }

    @Override
    public UserDto findAdmin() {
        Role role = roleRepository.findByRoleName(QUARTERMASTER);
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        User user = userRepository.findByRoles(roles);
        return userConverter.convertUserToDto(user);
    }

    @Override
    public UserDto findUser(String username) {
        User user = userRepository.findByUsername(username);
        return userConverter.convertUserToDto(user);
    }
}
