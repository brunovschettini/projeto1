package natan.io.projeto1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import natan.io.projeto1.entity.UserMongo;

//Para não desfazer o User do MYSQL, criei outro userRepository para o MongoDB

// JpaRepository<User, Long> é para criar uma itnerface de pesquisa
public interface UserMongoRepository extends MongoRepository<UserMongo, Long> {

	// Com essa médoto consigo realizar queries pelo parâmetro que eu quiser
	UserMongo findByName(String name);
 
	UserMongo findByEmail(String email);

	// IgnoreCase
	UserMongo findByNameIgnoreCase(String name);

	// IgnoreCaseLike
	UserMongo findByNameIgnoreCaseLike(String name);

	@Query("{ 'email' : ?0 }")
	UserMongo findByEmailAnywhere(String email);

}
