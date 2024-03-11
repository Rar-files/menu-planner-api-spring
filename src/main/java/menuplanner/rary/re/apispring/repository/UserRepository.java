package menuplanner.rary.re.apispring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import menuplanner.rary.re.apispring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}