package learning.datascience.shailu.project1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public class BaseController {

    protected static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected ModelMapper modelMapper;

    public BaseController() {
        modelMapper = new ModelMapper();
    }

    @Bean
    protected ModelMapper getModelMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        return modelMapper;
    }

    protected String generateJsonValue(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        //objectMapper.enable( SerializationFeature.INDENT_OUTPUT );
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // do various things, perhaps:
        String arrayToJson = objectMapper.writeValueAsString(object);

        return arrayToJson;
    }

//    @RequestMapping("/swagger")
//    public String swaggerHome() {
//        return "redirect:/swagger-ui.html";
//    }
}
