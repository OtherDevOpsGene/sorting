package com.coveros.example.sorting;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/words")
public class WordController {

  @Autowired
  WordService wordService;

  @Autowired
  SortingService sortingService;

  @RequestMapping(method = RequestMethod.GET)
  public List<String> words(@RequestParam(value="sort", defaultValue="none") String sort) throws IOException {

    List<String> words = wordService.words();
    switch(sort) {
      case "none":
        break;
      case "bubble":
        words = sortingService.bubbleSort(words);
        break;
      case "insertion":
        words = sortingService.insertionSort(words);
        break;
      case "merge":
        words = sortingService.mergeSort(words);
        break;
      case "heap":
        words = sortingService.heapSort(words);
        break;
      case "quick":
        words = sortingService.quickSort(words);
        break;
      case "java":
        words = sortingService.javaSort(words);
        break;
      default:
        throw new IllegalArgumentException("Unknown sort type selected [" + sort + "]");
    }
    return words;
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public void delete() {
    wordService.delete();
  }
}
