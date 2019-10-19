package com.coveros.example.sorting;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/words")
public class WordController {

  @Autowired
  WordService wordService;

  @RequestMapping(method = RequestMethod.GET)
  public List<String> words() throws IOException {
    return wordService.words();
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public void delete() {
    wordService.delete();
  }
}
