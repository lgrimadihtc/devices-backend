package com.guidewheel.metric.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.guidewheel.metric.model.LoadProcess;
import com.guidewheel.metric.service.LoadServiceCompressor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
public class FileUploader {

   List<String> files = new ArrayList<String>();
   private final Path rootLocation = Paths.get("");

   @Autowired
   private LoadServiceCompressor loadService;
   @PostMapping("/savefile/{deviceId}")
   public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,@PathVariable String deviceId) {
      String message;
      try {
         try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
        System.out.println(this.rootLocation.resolve(file.getOriginalFilename()));
         
         } catch (Exception e) {
        	 e.printStackTrace();
            throw new RuntimeException("FAIL!");
         }
         files.add(file.getOriginalFilename());
         LoadProcess lp=loadService.load(file.getOriginalFilename(), deviceId);
         
         message = "Successfully uploaded! idTX:"+ lp.getId();
         return ResponseEntity.status(HttpStatus.OK).body(message);
      } catch (Exception e) {
    	  e.printStackTrace();
    	  
         message = "Failed to upload!";
         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
      }
   }
}