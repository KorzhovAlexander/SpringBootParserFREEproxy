package WebApp.Repository;


import WebApp.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<user,Long> {

    user findByUsername(String username);
    user findByIdUser(Integer idUser);
    String getFirstByUsername(String username);
    Iterable<user> findByMail(String email);

}
