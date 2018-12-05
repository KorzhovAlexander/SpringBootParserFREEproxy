package WebApp.Controller;

import WebApp.Repository.RoleRepository;
import WebApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@PreAuthorize("hasAuthority('Admin')")
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping("/users")
    public String user(Model Model){
        Model.addAttribute("userlist",userRepository.findAll());
        Model.addAttribute("rolelist",roleRepository.findAll());
        return "userlist";
    }

    @PostMapping("/setuser")
    public String setuserdetails(@RequestParam(required = false) String username
                                 ){
        System.out.println(username);
        return "redirect:/";
    }
}
