package learning.datascience.shailu.project1.services;

import learning.datascience.shailu.project1.domain.Luekamia;
import learning.datascience.shailu.project1.repository.LuekamiaRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service("luekamiaService")
public class LuekamiaServiceImpl implements LuekamiaService {

    @Autowired
    LuekamiaRepository luekamiaRepository;

    @Override
    public List<Luekamia> getLuekamiaPatientsList() {
        return luekamiaRepository.findAll();
    }

    @Override
    public void loadData(MultipartFile dataFile) throws IOException {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(dataFile.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        List<Luekamia> luekamiaList = new ArrayList<>();
        Luekamia luekamia = null;
        int counter = 0;
        for (CSVRecord csvRecord : csvRecords) {
            if(counter == 0) {
                counter++;
                continue; // Skipping header;
            }
            luekamia = new Luekamia();
            luekamia.setPatientID(csvRecord.get(0));
            int age = 0;
            if(csvRecord.get(1) != null) {
                try {
                    age = Integer.parseInt(csvRecord.get(1));
                }catch (NumberFormatException nfe){
                    //IGNORE
                }
            }
            luekamia.setAgeAtDiagnosis(age);

            luekamia.setCancerType(csvRecord.get(2));
            luekamia.setCancerTypeDetailed(csvRecord.get(3));
            luekamia.setCauseOfDeathSource(csvRecord.get(4));
            luekamia.setChemotherapy(( csvRecord.get(5) != null && csvRecord.get(5).equalsIgnoreCase("yes") ) ? true : false);
            luekamia.setCumulativeTreatmentStages(csvRecord.get(6));

            luekamiaList.add(luekamia);
            counter++;
        }
        if(luekamiaList.size() > 0 )
            luekamiaRepository.saveAll(luekamiaList);
    }
}
