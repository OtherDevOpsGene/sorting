package com.coveros.example.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SortingServiceTest {

  SortingService service = new SortingService();

  List<String> expected = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "grape", "kiwi",
      "lemon", "mango", "orange", "peach", "strawberry"));
  List<String> unsorted = new ArrayList<>(Arrays.asList("banana", "peach", "lemon", "mango", "grape",
      "strawberry", "orange", "kiwi", "cherry", "apple"));

  @Test
  void bubbleSort() {
    assertEquals(expected, service.bubbleSort(unsorted));
  }

  @Test
  void insertionSort() {
    assertEquals(expected, service.insertionSort(unsorted));
  }

  @Test
  void mergeSort() {
    assertEquals(expected, service.mergeSort(unsorted));
  }

  @Test
  void heapSort() {
    assertEquals(expected, service.heapSort(unsorted));
  }

  @Test
  void quickSort() {
    assertEquals(expected, service.quickSort(unsorted));
  }

  @Test
  void javaSort() {
    assertEquals(expected, service.javaSort(unsorted));
  }
}
