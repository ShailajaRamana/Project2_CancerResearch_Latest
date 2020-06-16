package learning.datascience.shailu.project1.services;

import learning.datascience.shailu.project1.domain.Luekamia;
import learning.datascience.shailu.project1.domain.Physician;
import learning.datascience.shailu.project1.domain.PhysicianByState;
import learning.datascience.shailu.project1.repository.LuekamiaRepository;
import learning.datascience.shailu.project1.repository.PhysicianRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service("physicianService")
public class PhysicianServiceImpl implements PhysicianService {

    @Autowired
    PhysicianRepository physicianRepository;

    @Override
    public List<Physician> getPhysiciansList() {
        return physicianRepository.findAll();
    }

    @Override
    public List<PhysicianByState> getPhysiciansByStateList() {
        return physicianRepository.physiciansByStateCount();
    }

    @Override
    public void loadData(MultipartFile dataFile) throws IOException {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(dataFile.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        List<Physician> physicianList = new ArrayList<>();
        Physician physician = null;
        int counter = 0;
        for (CSVRecord csvRecord : csvRecords) {
            if(counter == 0) {
                counter++;
                continue; // Skipping header;
            }
            physician = new Physician();
            long physicianId = 0;
            if(csvRecord.get(0) != null){
                try{
                    physicianId = Long.parseLong(csvRecord.get(0));
                }catch (NumberFormatException nfe){
                    continue; // As primary key is null, cannot insert this row/data.
                }
            }
            physician.setPhysicianID(physicianId);
            long enrollementId = 0;
            if(csvRecord.get(1) != null) {
                try {
                    enrollementId = Long.parseLong(csvRecord.get(1));
                }catch (NumberFormatException nfe){
                    //IGNORE
                }
            }
            physician.setProfessionalEnrollmentID(enrollementId);

            physician.setLastname(csvRecord.get(2));
            physician.setFirstname(csvRecord.get(3));
            physician.setMiddlename(csvRecord.get(4));
            physician.setSuffix(csvRecord.get(5));
            physician.setGender(csvRecord.get(6));

            physician.setState(csvRecord.get(13));

            physicianList.add(physician);
            counter++;
        }
        if(physicianList.size() > 0 )
            physicianRepository.saveAll(physicianList);
    }
}
