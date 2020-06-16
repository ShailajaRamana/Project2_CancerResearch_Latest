package learning.datascience.shailu.project1.services;

import learning.datascience.shailu.project1.domain.StatevsSpend;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StateVsSpendService {
    List<StatevsSpend> getStateVsSpendList();

    void loadData(MultipartFile dataFile) throws IOException;
}
