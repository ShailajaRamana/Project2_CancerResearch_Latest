package learning.datascience.shailu.project1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import learning.datascience.shailu.project1.domain.Luekamia;
import learning.datascience.shailu.project1.services.LuekamiaService;
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
public class LuekamiaController extends BaseController {

    @Autowired
    LuekamiaService luekamiaService;

    @GetMapping(value="/luekamia", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            httpMethod = "GET",
            value = "Get Luekamia Patients data.",
            notes = "This API returns Luekamia Patients data.",
            nickname = "getPendingReviewsForUser",
            response = Luekamia.class)
    public ResponseEntity<String> getLuekamiaPatientsList() throws JsonProcessingException {
        List<Luekamia>  luekamiaList = luekamiaService.getLuekamiaPatientsList();

        String response = generateJsonValue(luekamiaList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/uploadLuekamiaData")
    @ApiOperation(
            httpMethod = "POST",
            value = "Upload Luekamia Data File.",
            notes = "This API uploads the Luekamia data into database.",
            nickname = "uploadLuekamiaData")
    public ResponseEntity<String> uploadLuekamiaData(@RequestParam("files") MultipartFile dataFile) throws IOException {

        String response = "{\"status\":\"success\", \"savedId\":\" " ;
        luekamiaService.loadData(dataFile);
        response = response.substring(0, response.length()-1);
        response += " uploaded!"+ "\"}";

        return ResponseEntity.ok().body(response);
    }
}
