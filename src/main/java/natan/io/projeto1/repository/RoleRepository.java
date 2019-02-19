package natan.io.projeto1.repository;

import java.util.List;
import natan.io.projeto1.entity.Role;
import natan.io.projeto1.entity.StatusRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByStatus(StatusRole status);

    @Override
    Page<Role> findAll(Pageable pageble);

}
