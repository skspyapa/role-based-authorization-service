package lk.sky360solutions.authorization.role.repository;

import lk.sky360solutions.authorization.role.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  User getByUsername(String username);
}
