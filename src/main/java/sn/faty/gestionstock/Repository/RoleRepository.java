package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.Roles;

public interface RoleRepository  extends JpaRepository<Roles ,Long> {
}
