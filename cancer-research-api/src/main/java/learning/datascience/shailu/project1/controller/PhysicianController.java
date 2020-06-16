package learning.datascience.shailu.project1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import learning.datascience.shailu.project1.domain.Luekamia;
import learning.datascience.shailu.project1.domain.Physician;
import learning.datascience.shailu.project1.domain.PhysicianByState;
import learning.datascience.shailu.project1.services.PhysicianService;
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
public class PhysicianController extends BaseController {

    @Autowired
    private PhysicianService physicianService;

    @GetMapping(value="/physicians", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            httpMethod = "GET",
            value = "Get Physician Patients data.",
            notes = "This API returns Physicians data.",
            nickname = "getPhysiciansList",
            response = Luekamia.class)
    public ResponseEntity<String> getPhysiciansList() throws JsonProcessingException {
        List<Physician> physiciansList = physicianService.getPhysiciansList();

        String response = generateJsonValue(physiciansList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value="/physiciansByState", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            httpMethod = "GET",
            value = "Get Physician Patients data.",
            notes = "This API returns Physicians data.",
            nickname = "getPhysiciansByStateList",
            response = Physician.class)
    public ResponseEntity<String> getPhysiciansByStateList() throws JsonProcessingException {
        List<PhysicianByState> physiciansByStateList = physicianService.getPhysiciansByStateList();

        String response = generateJsonValue(physiciansByStateList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/uploadPhysicianData")
    @ApiOperation(
            httpMethod = "POST",
            value = "Upload Physicians Data File.",
            notes = "This API uploads the Physicians data into database.",
            nickname = "uploadPhysicianData")
    public ResponseEntity<String> uploadPhysicianData(@RequestParam("files") MultipartFile dataFile) throws IOException {

        String response = "{\"status\":\"success\", \"savedId\":\" " ;
        physicianService.loadData(dataFile);
        response = response.substring(0, response.length()-1);
        response += " uploaded!"+ "\"}";

        return ResponseEntity.ok().body(response);
    }
}
