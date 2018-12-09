package WebApp.Controller;

import WebApp.Service.userService;
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
    private userService userService;


    @GetMapping("/users")
    public String user(Model Model) {
        Model.addAttribute("userlist", userService.findAll());
        return "userlist";
    }

    @PostMapping("/setuser")
    public String setuserdetails(@RequestParam(required = false) String username
    ) {
        System.out.println(username);
        return "redirect:/";
    }

    @PostMapping("/updateuser")
    public String updateuser(@RequestParam Integer iduser,
                             @RequestParam String email,
                             @RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String nameRole) {
        userService.updateuser(iduser,email,username,password,nameRole);

        return "redirect:/users";
    }

    @PostMapping("/banuser")
    public String banuser(
            @RequestParam Integer iduser) {
        userService.banuser(iduser);
        return "redirect:/users";
    }

    @PostMapping("/deleteuser")
    public String deleteuser(
            @RequestParam Integer iduser){
        userService.deleteuserbyid(iduser);
        return "redirect:/users";
    }

}
