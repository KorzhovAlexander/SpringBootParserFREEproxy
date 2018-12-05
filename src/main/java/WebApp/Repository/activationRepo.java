package WebApp.Repository;

import WebApp.Entity.activation_code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface activationRepo extends JpaRepository<activation_code,Long> {
    activation_code findByActivationcode(String code);
}
