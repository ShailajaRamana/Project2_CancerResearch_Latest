package learning.datascience.shailu.project1.repository;

import learning.datascience.shailu.project1.domain.StatevsSpend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("stateVsSpendRepository")
public interface StateVsSpendRepository extends JpaRepository<StatevsSpend, Long> {
}
