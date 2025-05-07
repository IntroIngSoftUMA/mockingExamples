package org.iis.mocking.examples;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MockedListTest {

  @Test
  void simpleMockingExamples() {
    // STEP 1: create the mock object
    List<String> mockedList = mock(List.class);

    // STEP 2: using the mock object
    mockedList.add("green");
    mockedList.add("blue");
    mockedList.add("green");
    mockedList.clear();

    // STEP 3: verify the calls to the mocked object
    verify(mockedList).add("blue");
    verify(mockedList, times(2)).add("green");
    verify(mockedList, times(1)).clear();

    verify(mockedList, times(3)).add(anyString());
    verify(mockedList, never()).add("red");
    verify(mockedList, never()).size();
    verify(mockedList, atLeastOnce()).add("blue");
    verify(mockedList, atLeast(1)).add(anyString());
  }

  @Test
  void simpleStubbingExamples() {
    // STEP 1: create mock the object
    List<String> mockedList = mock(List.class);

    // STEP 2: stubbing
    mockedList.add("green");
    mockedList.add("blue");
    Mockito.when(mockedList.size()).thenReturn(2);

    when(mockedList.get(0)).thenReturn("green");
    when(mockedList.get(1)).thenReturn("blue");
    when(mockedList.get(-1)).thenThrow(new IndexOutOfBoundsException());

    // STEP 3: verify the calls to the mocked object
    verify(mockedList, times(2)).add(anyString());
    assertEquals(2, mockedList.size());
    assertEquals("green", mockedList.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> mockedList.get(-1));
  }
}
