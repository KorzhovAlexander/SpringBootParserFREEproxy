package WebApp.Repository;

import WebApp.Entity.feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface feedbackRepo extends JpaRepository<feedback,Long> {
    List<feedback> findAllByAddTrue();
    feedback findByIdfeedbackEquals(Integer id);
}
