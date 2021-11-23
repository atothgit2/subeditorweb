package com.arpi.subeditorforweb2.subeditorweb;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HtmlController {
  @RequestMapping(value = "", method = RequestMethod.GET)
    public String getIndexPage() {
    return "index2.html";
  }

  @PostMapping(value = "/upload")
  public @ResponseBody ResponseEntity handleFileUpload(@RequestParam("inpFile") MultipartFile file) {
    System.out.println("myfile:" + file);
    return new ResponseEntity(HttpStatus.ACCEPTED);
  }
}