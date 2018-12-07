package WebApp.Service;

import WebApp.Entity.activation_code;
import WebApp.Entity.user;
import WebApp.Repository.RoleRepository;
import WebApp.Repository.UserRepository;
import WebApp.Repository.activationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class userService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final activationRepo activationRepo;
    private final MailSender mailSender;

    @Autowired
    public userService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, activationRepo activationRepo, MailSender mailSender) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.activationRepo = activationRepo;
        this.mailSender = mailSender;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return userRepository.findByUsername(username);
    }

    public user getUserLike(String username){
        return userRepository.findByUsername(username);
    }
    public Iterable<user> getEmailLike(String email){return userRepository.findByMail(email);}

    public boolean createUser(user user){
        user UserFromDatabase = userRepository.findByUsername(user.getUsername());
        if ((UserFromDatabase != null) || (user.getUsername().isEmpty()) || (user.getPassword().isEmpty()) || (user.getMail().isEmpty()))
            return false;

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(false);
        user.setRole(roleRepository.getFirstByIdRole(1));

        userRepository.save(user);
        sendAndCreateActivationCode(user);
        return true;
    }

//    @Async
    public void sendAndCreateActivationCode(user user){
        activation_code activation_code = new activation_code();
        activation_code.setIdUser(user.getIdUser());
        activation_code.setActivationcode(UUID.randomUUID().toString());
        activationRepo.save(activation_code);
        String message = String.format(
                "Hello, %s! \n" +
                        "Welcome to proxysocks. Please, visit next link: <a href="+'"'+"http://localhost:8080/Register/%s>"+'"'+"LINK</a>",
                user.getUsername(),
                activation_code.getActivationcode()
        );

        mailSender.send(user.getMail(), "Activation code", message);
    }


    public boolean parseCode(String code){
        activation_code activation_code= activationRepo.findByActivationcode(code);
        if(activation_code!=null){
            user user = userRepository.findByIdUser(activation_code.getIdUser());
            user.setActive(true);
            userRepository.save(user);
        return true;}
        return false;
    }

    public boolean createGuestUser(String email){
        if (getEmailLike(email)!=null){
            user user = new user();
            user.setActive(false);
            user.setMail(email);
            user.setPassword("");
            user.setUsername("");
            user.setRole(roleRepository.getFirstByIdRole(4)); /*Guest role*/
            userRepository.save(user);
        return true;
        }
        return false;
    }
}
