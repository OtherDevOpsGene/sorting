package com.coveros.example.sorting;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

  @Autowired
  WordService wordService;

  @RequestMapping("/words")
  public List<String> words() throws IOException {
    return wordService.words();
  }
}
