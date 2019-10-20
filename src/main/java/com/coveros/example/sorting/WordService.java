package com.coveros.example.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class WordService {

  @Value("classpath:words-20000.txt")
  private Resource wordFile;

  @Cacheable("words")
  public List<String> words() throws IOException {
    InputStream wordInput = wordFile.getInputStream();

    BufferedReader br = new BufferedReader(new InputStreamReader(wordInput));

    List<String> words = new ArrayList<>();
    String word;
    while (null != (word = br.readLine())) {
      words.add(word);
    }

    Collections.shuffle(words);
    return words;
  }

  @CacheEvict(value = "words", allEntries = true)
  public void delete() {}
}
