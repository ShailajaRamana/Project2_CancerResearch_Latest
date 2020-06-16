package learning.datascience.shailu.project1.services;

import learning.datascience.shailu.project1.domain.Luekamia;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface LuekamiaService {
    List<Luekamia> getLuekamiaPatientsList();

    void loadData(MultipartFile dataFile) throws IOException;
}
