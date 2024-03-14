package menuplanner.rary.re.apispring.repository;

import menuplanner.rary.re.apispring.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String>{

}