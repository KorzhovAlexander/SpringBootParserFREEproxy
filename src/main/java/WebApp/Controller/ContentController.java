package WebApp.Controller;

import WebApp.Service.searchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@PreAuthorize(" hasAuthority('Admin') or hasAuthority('User') ")
public class ContentController {

    @Autowired
    private searchService searchService;

    @PostMapping(value = "/content")
    public @ResponseBody Map<String, Object> ajaxQuery(
            @RequestParam(name = "SeachEdit", required = false) String SeachEdit,
            @RequestParam(name = "id", required = false) String id
    ) {
        Map<String, Object> mmd = new HashMap<>();
        mmd.put("rez", searchService.get50randomGoodProxy((SeachEdit).trim(), Integer.valueOf(id.replaceAll(" ",""))));
        return mmd;
    }

    @GetMapping(value = "/error")
    public String getError(){
        return "error";
    }

    @GetMapping(value = "/success")
    public String getSuccess(Map<String,Object> model){
            model.put("message","success");
        return "success";
    }
}
