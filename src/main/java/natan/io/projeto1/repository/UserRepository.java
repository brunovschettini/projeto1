package natan.io.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import natan.io.projeto1.entity.User;

// JpaRepository<User, Long> é para criar uma itnerface de pesquisa
public interface UserRepository extends JpaRepository<User, Long> {

	// Com essa médoto consigo realizar queries pelo parâmetro que eu quiser
	User findByName(String name);
	
	User findByEmail(String email);
	
	// Com essa médoto consigo realizar queries pelo parâmetro que eu quiser com a query
	@Query("SELECT U FROM User U WHERE U.name = ?1")
	User findByNameAnywhere(String name);
	
	// Com essa médoto consigo realizar queries pelo parâmetro que eu quiser com a query
	@Query("SELECT U FROM User U WHERE U.name LIKE %?1%")
	User findByNameContains(String name);
	
}
