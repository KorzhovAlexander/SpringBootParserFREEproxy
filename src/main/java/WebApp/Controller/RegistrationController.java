package WebApp.Controller;

import WebApp.Entity.user;
import WebApp.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private final userService userService;


    @Autowired
    public RegistrationController(userService userService) {
        this.userService = userService;
    }

    @GetMapping("/Register")
    public String Register(Model model) {
        return "Register";
    }

    @PostMapping("/Register")
    public String AddUser(user user) {

        if (userService.createUser(user)) {
//            userService.sendAndCreateActivationCode(user);
            return "redirect:/login";
        }
        return "redirect:/error";
    }

    @GetMapping("/Register/{code}")
    public String activate(@PathVariable String code, Model model) {
        if (userService.parseCode(code)) {
            model.addAttribute("message", "user");
            return "redirect:/success";
        }
        return "redirect:/error";
    }

    @PostMapping(value = "/Register/getUserExist")
    public @ResponseBody boolean findUser(@RequestParam(name = "username") String username) {
        return userService.loadUserByUsername(username) != null;
    }

    @GetMapping("/getUserExist")
    public String getUserExist() {
        return "Register";
    }

}

//{"status": true})