package dev.otherdevopsgene.example.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Tag("slow")
public class SortingServicePerfTest {

  @Value("classpath:words-20000.txt")
  private Resource wordFile;

  SortingService service = new SortingService();

  WordService wordService = new WordService();

  private List<String> unsorted;

  private List<String> expected;

  @BeforeEach
  public void setUp() throws IOException {
    try (InputStream wordInput = wordFile.getInputStream();) {
      this.unsorted = wordService.readWordsFromStream(wordInput);
      Collections.shuffle(unsorted);

      this.expected = new ArrayList<>(unsorted);
      Collections.sort(expected);
    }
  }

  @RepeatedTest(10)
  @Timeout(value = 8000, unit = TimeUnit.MILLISECONDS)
  void bubbleSort() {
    assertEquals(expected, service.bubbleSort(unsorted));
  }

  @RepeatedTest(10)
  @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
  void insertionSort() {
    assertEquals(expected, service.insertionSort(unsorted));
  }

  @RepeatedTest(10)
  @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
  void mergeSort() {
    assertEquals(expected, service.mergeSort(unsorted));
  }

  @RepeatedTest(10)
  @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
  void heapSort() {
    assertEquals(expected, service.heapSort(unsorted));
  }

  @RepeatedTest(10)
  @Timeout(value = 60, unit = TimeUnit.MILLISECONDS)
  void quickSort() {
    assertEquals(expected, service.quickSort(unsorted));
  }

  @RepeatedTest(10)
  @Timeout(value = 40, unit = TimeUnit.MILLISECONDS)
  void javaSort() {
    assertEquals(expected, service.javaSort(unsorted));
  }
}
