package learning.datascience.shailu.project1.services;

import learning.datascience.shailu.project1.domain.Physician;
import learning.datascience.shailu.project1.domain.PhysicianByState;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PhysicianService {
    List<Physician> getPhysiciansList();

    List<PhysicianByState> getPhysiciansByStateList();

    void loadData(MultipartFile dataFile) throws IOException;
}
