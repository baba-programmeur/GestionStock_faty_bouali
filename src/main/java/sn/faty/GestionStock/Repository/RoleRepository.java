package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.Roles;

public interface RoleRepository  extends JpaRepository<Roles ,Long> {
}
