package learning.datascience.shailu.project1.repository;

import learning.datascience.shailu.project1.domain.Physician;
import learning.datascience.shailu.project1.domain.PhysicianByState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("physicianRepository")
public interface PhysicianRepository extends JpaRepository<Physician, Long> {
    @Query("SELECT new learning.datascience.shailu.project1.domain.PhysicianByState(p.state, COUNT(p.physicianID)) "
            + " FROM Physician AS p GROUP BY p.state ORDER BY p.state")
    List<PhysicianByState> physiciansByStateCount();
}
