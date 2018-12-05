package WebApp.Controller;


import WebApp.Entity.feedback;
import WebApp.Entity.role;
import WebApp.Entity.user;
import WebApp.Repository.ProxysocksRepository;
import WebApp.Service.feedbackService;
import WebApp.Service.mainPageSearchService;
import WebApp.Service.searchService;
import WebApp.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class MainController {
    private final ProxysocksRepository proxysocksRepository;
    private final searchService searchService;
    private final mainPageSearchService mainPageSearchService;
    private final WebApp.Service.userService userService;
    private final feedbackService feedbackService;

    @Autowired
    public MainController(ProxysocksRepository proxysocksRepository, searchService searchService, mainPageSearchService mainPageSearchService, userService userService, feedbackService feedbackService) {
        this.proxysocksRepository = proxysocksRepository;
        this.searchService = searchService;
        this.mainPageSearchService = mainPageSearchService;
        this.userService = userService;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model, HttpServletRequest ht) {
        model.addAttribute("proxysocks", searchService.getStatic50Proxy("%"));
        model.addAttribute("feedback", feedbackService.findAllByActive());
        return "index";
    }

    @PostMapping("/")
    public @ResponseBody
    Map<String, Object>
    findWithFilter(@RequestParam(name = "proxy", required = false) String proxy,
                   @RequestParam(name = "port", required = false) String port,
                   @RequestParam(name = "code", required = false) String code) {
        Map<String, Object> mmd = new HashMap<>();
        mmd.put("rezult", mainPageSearchService.getListProxyLike(proxy, port, code));

        return mmd;
    }

    @GetMapping("/allproxy")
    public String gd(Map<String, Object> OBJ) {
        OBJ.put("query", proxysocksRepository.findAll());
        return "REZULT";
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/feedback")
    public String getFeedback(Model model) {
        model.addAttribute("feedback", feedbackService.findAll());
        return "feedback";
    }
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/feedback")
    public String setNewFeedback(@RequestParam(name = "Published", required = false) String Published,
                                 @RequestParam(name = "idfeedback") Integer idfeedback,
                                 @RequestParam(name = "Delete", required = false) String Delete) {
        if (Published == null && Delete == null) return "redirect:/feedback";

        if (Published != null) if (Published.equals("Published")){
            feedback feedback = feedbackService.findbyid(idfeedback);
            feedbackService.setpublickfeedback(feedback);
        }

        if (Delete != null)
            if (Delete.equals("Delete")){feedback feedback = feedbackService.findbyid(idfeedback);
                feedbackService.deletepublickfeedback(feedback);}


        return "redirect:/feedback";
    }

    @PostMapping("/feedbacksend")
    public @ResponseBody
    boolean sendFeedback(@RequestParam(name = "theme") String theme,
                         @RequestParam(name = "feedback") String feedback,
                         @RequestParam(name = "email", required = false) String email) {
        if (email == null) {
            if (theme.trim().isEmpty() || feedback.trim().isEmpty()) return false;
            user usr = userService.getUserLike(SecurityContextHolder.getContext().getAuthentication().getName());
            feedbackService.setFeedback(feedback.trim(), theme.trim(), usr);
            return true;
        }
        return feedbackService.CheckFeedbackUser(theme.trim(), feedback.trim(), email.trim());
    }


}
