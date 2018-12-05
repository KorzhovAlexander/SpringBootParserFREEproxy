package WebApp.Repository;


import WebApp.Entity.search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
public interface searchRepository extends JpaRepository<search, Long> {
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE search AUTO_INCREMENT=1;",nativeQuery = true)
    void autoincrementNull();

    void deleteAllByIduserEquals(Integer idUser);
}
