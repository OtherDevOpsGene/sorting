package dev.otherdevopsgene.example.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

  public static final Charset UTF_8 = StandardCharsets.UTF_8;

  @Value("classpath:words-20000.txt")
  private Resource wordFile;

  @Cacheable("words")
  public List<String> words() throws IOException {
    try (InputStream wordInput = wordFile.getInputStream();) {
      List<String> words = readWordsFromStream(wordInput);
      Collections.shuffle(words);
      return words;
    }
  }

  List<String> readWordsFromStream(InputStream wordInput) throws IOException {
    List<String> words = new ArrayList<>();
    try (InputStreamReader reader = new InputStreamReader(wordInput, UTF_8);
        BufferedReader br = new BufferedReader(reader);) {

      String word;
      while (null != (word = br.readLine())) {
        words.add(word);
      }
      return words;
    }
  }

  @CacheEvict(value = "words", allEntries = true)
  public void delete() {}
}
