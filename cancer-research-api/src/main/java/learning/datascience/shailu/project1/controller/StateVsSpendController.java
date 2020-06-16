package learning.datascience.shailu.project1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import learning.datascience.shailu.project1.domain.Luekamia;
import learning.datascience.shailu.project1.domain.Physician;
import learning.datascience.shailu.project1.domain.StatevsSpend;
import learning.datascience.shailu.project1.services.PhysicianService;
import learning.datascience.shailu.project1.services.StateVsSpendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StateVsSpendController extends BaseController {

    @Autowired
    private StateVsSpendService stateVsSpendService;

    @GetMapping(value="/stateVsSpend", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            httpMethod = "GET",
            value = "Get State Vs Spend $ data.",
            notes = "This API returns State Vs Spend $ data.",
            nickname = "getStateVsSpendDatar",
            response = StatevsSpend.class)
    public ResponseEntity<String> getStateVsSpendDatar() throws JsonProcessingException {
        List<StatevsSpend> stateVsSpendList = stateVsSpendService.getStateVsSpendList();

        String response = generateJsonValue(stateVsSpendList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/uploadStateVsSpendData")
    @ApiOperation(
            httpMethod = "POST",
            value = "Upload Physicians Data File.",
            notes = "This API uploads the Physicians data into database.",
            nickname = "uploadStateVsSpendData")
    public ResponseEntity<String> uploadStateVsSpendData(@RequestParam("files") MultipartFile dataFile) throws IOException {

        String response = "{\"status\":\"success\", \"savedId\":\" " ;
        stateVsSpendService.loadData(dataFile);
        response = response.substring(0, response.length()-1);
        response += " uploaded!"+ "\"}";

        return ResponseEntity.ok().body(response);
    }
}
