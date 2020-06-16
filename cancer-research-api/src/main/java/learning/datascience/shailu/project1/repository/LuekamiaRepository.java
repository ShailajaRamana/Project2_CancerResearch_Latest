package learning.datascience.shailu.project1.repository;

import learning.datascience.shailu.project1.domain.Luekamia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("luekamiaRepository")
public interface LuekamiaRepository extends JpaRepository<Luekamia, String> {
}
