package cleato.assigmnt.api_cleato_assignment.controller;

import cleato.assigmnt.api_cleato_assignment.model.StudentOne;
import cleato.assigmnt.api_cleato_assignment.service.StudentService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getAllStudentsAndSaveInFile(@RequestParam("sort") String sort) throws Exception {

        try {
            File file = new File("result.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            List<String> nameList = studentService.getStudentsNames(sort);
            if(nameList.size()==0){
                return new ResponseEntity<String>("Students are not founded!", HttpStatus.NOT_FOUND);
            }

            Files.write(Paths.get(file.getPath()), nameList);

        } catch (IOException e) {
            return new ResponseEntity<String>("Something wrong!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Student's names successfully ordered and saved in Result.txt", HttpStatus.OK);
    }
}
