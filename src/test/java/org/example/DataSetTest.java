package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataSetTest {

    public static class DataSet {
        private int size = 0;
        private String[] array = new String[100];

        public boolean add(String value) {
            if (contains(value)) return false;
            checkArrayIndex();
            array[size] = value;
            size++;
            return true;
        }

        private void checkArrayIndex() {
            if (size >= array.length) {
                String[] newArray = new String[array.length * 2];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }
        }

        public int size() {
            return size;
        }

        public boolean remove(String value) {
            if (!contains(value)) return false;

            for (int i = 0; i < size; i++) {
                if (Objects.equals(array[i], value)) {
                    if (i+1 < size) {
                        array[i] = array[i+1];
                    }
                }
            }
            size--;
            return true;
        }

        public boolean contains(String value) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(array[i], value)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    public void testDataSet() {
        DataSet set = new DataSet();
        Assertions.assertEquals(0, set.size());
        set.add("Roy");
        Assertions.assertEquals(1, set.size());
        set.add("Ryando");
        Assertions.assertEquals(2, set.size());
        set.add("Roni");
        Assertions.assertEquals(3, set.size());
        Assertions.assertFalse(set.add("Roy"));
        Assertions.assertFalse(set.add("Ryando"));
        Assertions.assertFalse(set.add("Roni"));
        set.remove("Ryando");
        Assertions.assertEquals(2, set.size());
        Assertions.assertTrue(set.contains("Roy"));
        Assertions.assertFalse(set.contains("Ryando"));
        Assertions.assertTrue(set.contains("Roni"));
    }

    @Test
    public void testBigData() {
        DataSet set = new DataSet();
        for (int i = 0; i < 1000; i++) {
            set.add("Name-" + i);
        }
        Assertions.assertEquals(1000, set.size());
    }

}
