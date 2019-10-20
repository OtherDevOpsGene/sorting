package com.coveros.example.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * A selection of sorting algorithms for demonstration purposes. Only the {@link #javaSort(List)} should be actually
 * used. Even better, use {@link Collections#sort(List)} directly.
 */
@Service
public class SortingService {

  /**
   * Sort a list using the bubble sort algorithm.
   *
   * @param list a list to be sorted
   * @param <T> a Comparable type
   * @return a new sorted list
   * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">https://en.wikipedia.org/wiki/Bubble_sort</a>
   */
  public <T extends Comparable> List<T> bubbleSort(List<T> list) {
    List<T> sorted = new ArrayList<>(list);
    T current;

    for (int i = 0; i < sorted.size(); i++) {
      for (int j = 0; j < sorted.size() - i - 1; j++) {
        if (sorted.get(j).compareTo(sorted.get(j + 1)) > 0) {
          current = sorted.get(j);
          sorted.set(j, sorted.get(j + 1));
          sorted.set(j + 1, current);
        }
      }
    }

    return sorted;
  }

  /**
   * Sort a list using the insertion sort algorithm.
   *
   * @param list a list to be sorted
   * @param <T> a Comparable type
   * @return a new sorted list
   * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort">https://en.wikipedia.org/wiki/Insertion_sort</a>
   */
  public <T extends Comparable> List<T> insertionSort(List<T> list) {
    List<T> sorted = new ArrayList<>(list);

    for (int i = 1; i < sorted.size(); i++) {
      T current = sorted.get(i);
      int j = i - 1;
      while (j >= 0 && current.compareTo(sorted.get(j)) < 0) {
        sorted.set(j + 1, sorted.get(j));
        j--;
      }
      sorted.set(j + 1, current);
    }

    return sorted;
  }

  /**
   * Sort a list using the merge sort algorithm.
   *
   * @param list a list to be sorted
   * @param <T> a Comparable type
   * @return a new sorted list
   * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">https://en.wikipedia.org/wiki/Merge_sort</a>
   */
  public <T extends Comparable> List<T> mergeSort(List<T> list) {
    List<T> sorted = new ArrayList<>(list);
    final int len = sorted.size();
    if (len < 2) {
      return sorted;
    }

    int mid = len / 2;
    List<T> left = sorted.subList(0, mid);
    List<T> right = sorted.subList(mid, len);

    left = mergeSort(left);
    right = mergeSort(right);

    return merge(left, right, sorted);
  }

  private <T extends Comparable> List<T> merge(List<T> left, List<T> right, List<T> whole) {
    int l = 0;
    int r = 0;
    int w = 0;

    while (l < left.size() && r < right.size()) {
      if (left.get(l).compareTo(right.get(r)) < 0) {
        whole.set(w, left.get(l));
        l++;
      } else {
        whole.set(w, right.get(r));
        r++;
      }
      w++;
    }

    List<T> extra;
    int e;
    if (l >= left.size()) {
      extra = right;
      e = r;
    } else {
      extra = left;
      e = l;
    }

    for (int i = e; i < extra.size(); i++) {
      whole.set(w, extra.get(i));
      w++;
    }
    return whole;
  }

  /**
   * Sort a list using the heapsort algorithm.
   *
   * @param list a list to be sorted
   * @param <T> a Comparable type
   * @return a new sorted list
   * @see <a href="https://en.wikipedia.org/wiki/Heapsort">https://en.wikipedia.org/wiki/Heapsort</a>
   */
  public <T extends Comparable> List<T> heapSort(List<T> list) {
    List<T> sorted = new ArrayList<>(list);
    final int len = sorted.size();
    if (0 == len) {
      return sorted;
    }

    for (int i = len / 2 - 1; i >= 0; i--) {
      sorted = heapify(sorted, len, i);
    }

    for (int i = len - 1; i >= 0; i--) {
      T temp = sorted.get(0);
      sorted.set(0, sorted.get(i));
      sorted.set(i, temp);

      sorted = heapify(sorted, i, 0);
    }
    return sorted;
  }

  private <T extends Comparable> List<T> heapify(List<T> list, int len, int i) {
    int max = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < len && list.get(l).compareTo(list.get(max)) > 0) {
      max = l;
    }
    if (r < len && list.get(r).compareTo(list.get(max)) > 0) {
      max = r;
    }

    if (max != i) {
      T temp = list.get(i);
      list.set(i, list.get(max));
      list.set(max, temp);

      list = heapify(list, len, max);
    }

    return list;
  }

  /**
   * Sort a list using the quicksort algorithm.
   *
   * @param list a list to be sorted
   * @param <T> a Comparable type
   * @return a new sorted list
   * @see <a href="https://en.wikipedia.org/wiki/Quicksort">https://en.wikipedia.org/wiki/Quicksort</a>
   */
  public <T extends Comparable> List<T> quickSort(List<T> list) {
    if (list.isEmpty()) {
      return list;
    }

    List<T> smaller = new ArrayList<>();
    List<T> greater = new ArrayList<>();

    T pivot = list.get(0);
    T current;
    for (int i = 1; i < list.size(); i++) {
      current = list.get(i);
      if (current.compareTo(pivot) < 0) {
        smaller.add(current);
      } else {
        greater.add(current);
      }
    }

    List<T> sorted = quickSort(smaller);
    sorted.add(pivot);
    sorted.addAll(quickSort(greater));

    return sorted;
  }

  /**
   * Sort a list using the built-in Java sort implementation.
   *
   * @param list a list to be sorted
   * @param <T> a Comparable type
   * @return a new sorted list
   * @see java.util.Collections#sort(List)
   */
  public <T extends Comparable> List<T> javaSort(List<T> list) {
    List<T> sorted = new ArrayList<>(list);
    Collections.sort(sorted);

    return sorted;
  }

}
