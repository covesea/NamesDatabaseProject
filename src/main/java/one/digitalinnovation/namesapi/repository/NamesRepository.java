package one.digitalinnovation.namesapi.repository;

import one.digitalinnovation.namesapi.entity.Names;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NamesRepository extends JpaRepository<Names, Long> {
}
