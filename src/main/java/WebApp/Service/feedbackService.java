package WebApp.Service;

import WebApp.Entity.feedback;
import WebApp.Entity.user;
import WebApp.Repository.feedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class feedbackService {

    @Autowired
    private userService userService;

    @Autowired
    private feedbackRepo feedbackRepo;

    public boolean CheckFeedbackUser(String theme,String feedback,String email){
        if (theme.isEmpty() || feedback.isEmpty()) return false;


        if (!userService.getEmailLike(email).iterator().hasNext()) {
            if (userService.createGuestUser(email)) {
                user usr = userService.getEmailLike(email).iterator().next();
                setFeedback(feedback, theme, usr);
                return true;
            }
        }
        if (userService.getEmailLike(email).iterator().hasNext()) {
            user usr = userService.getEmailLike(email).iterator().next();
            setFeedback(feedback, theme, usr);
            return true;
        }
        return false;
    }

    public void deletepublickfeedback(feedback feedbackString){
        feedbackString.setAdd(false);
        feedbackRepo.save(feedbackString);
    }

    public void setpublickfeedback(feedback feedbackString){
        feedbackString.setAdd(true);
        feedbackRepo.save(feedbackString);

    }

    public void setFeedback(String feedback, String theme, user usr){
        feedback feedbackString = new feedback();
        feedbackString.setTheme(theme);
        feedbackString.setFeedback(feedback);
        feedbackString.setIduser(usr.getIdUser());
        feedbackString.setAdd(false);
        feedbackRepo.save(feedbackString);
    }



    public List<feedback> findAll(){
        return feedbackRepo.findAll();
    }
    public List<feedback> findAllByActive(){return feedbackRepo.findAllByAddTrue();}
    public feedback findbyid(Integer id){return feedbackRepo.findByIdfeedbackEquals(id);}
}
