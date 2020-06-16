package learning.datascience.shailu.project1.services;

import learning.datascience.shailu.project1.domain.Physician;
import learning.datascience.shailu.project1.domain.StatevsSpend;
import learning.datascience.shailu.project1.repository.PhysicianRepository;
import learning.datascience.shailu.project1.repository.StateVsSpendRepository;
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

@Service("stateVsSpendService")
public class StateVsSpendServiceImpl implements StateVsSpendService {

    @Autowired
    StateVsSpendRepository stateVsSpendRepository;

    @Override
    public List<StatevsSpend> getStateVsSpendList() {
        return stateVsSpendRepository.findAll();
    }

    @Override
    public void loadData(MultipartFile dataFile) throws IOException {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(dataFile.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        List<StatevsSpend> statevsSpendList = new ArrayList<>();
        StatevsSpend statevsSpend = null;
        int counter = 0;
        for (CSVRecord csvRecord : csvRecords) {
            if(counter == 0) {
                counter++;
                continue; // Skipping header;
            }
            statevsSpend = new StatevsSpend();
            statevsSpend.setLocation(csvRecord.get(0));
            statevsSpend.setHealthspend(csvRecord.get(1));

            statevsSpendList.add(statevsSpend);
            counter++;
        }
        if(statevsSpendList.size() > 0 )
            stateVsSpendRepository.saveAll(statevsSpendList);
    }
}
