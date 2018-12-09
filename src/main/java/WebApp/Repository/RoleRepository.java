package WebApp.Repository;

import WebApp.Entity.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<role,Long> {
    role getFirstByIdRole(Integer id);
    role findByNameRole(String nameRole);
}
