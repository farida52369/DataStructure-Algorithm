package test_junit;

import ds2.lab4.data_generator.Operations;
import ds2.lab4.perfect_hashing.IMap;
import ds2.lab4.perfect_hashing.NMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NMethodTest {

    @Test
    public void testNSquareSpaceComplexityMethod_1() {

        Integer[] data = Operations.get_data("test_1");
        IMap nMethod = new NMethod();
        nMethod.hash(data);

        // Assert that Exists
        assert data != null;
        for (int key : data) {
            assertTrue(nMethod.contains(key));
        }

        // generate data does exist
        int[] notExist = new int[]{1, 2, 4, 7, 456, 543, 123, 321, 9822};

        // Assert that doesn't Exist
        for (int key : notExist) {
            assertFalse(nMethod.contains(key));
        }

        nMethod.print();
        System.out.println("Space Consumed: " + nMethod.spaceConsumed());
    }

    @Test
    public void testNSquareSpaceComplexityMethod_2() {

        Integer[] data = Operations.get_data("test_2");
        IMap nMethod = new NMethod();
        nMethod.hash(data);

        // Assert that Exists
        assert data != null;
        for (int key : data) {
            assertTrue(nMethod.contains(key));
        }

        // generate data does exist __ random data hard to get unExisted numbers
        int[] notExist = new int[]{123145, 3213, 34897, 48923, 34576, 7809};

        // Assert that doesn't Exist
        for (int key : notExist) {
            assertFalse(nMethod.contains(key));
        }

        nMethod.print();
        System.out.println("Space Consumed: " + nMethod.spaceConsumed());
    }

    @Test
    public void testNSquareSpaceComplexityMethod_3() {

        Integer[] data = Operations.get_data("test_3");
        IMap nMethod = new NMethod();
        nMethod.hash(data);

        // Assert that Exists
        assert data != null;
        for (int key : data) {
            assertTrue(nMethod.contains(key));
        }

        // generate data does exist __ random data hard to get unExisted numbers
        int[] notExist = new int[]{123145, 32678, 237222, 111154, 487037, 1223424};

        // Assert that doesn't Exist
        for (int key : notExist) {
            assertFalse(nMethod.contains(key));
        }

        nMethod.print();
        System.out.println("Space Consumed: " + nMethod.spaceConsumed());
    }

    @Test
    public void testNSquareSpaceComplexityMethod_4() {

        Integer[] data = Operations.get_data("test_4");
        IMap nMethod = new NMethod();
        nMethod.hash(data);

        // Assert that Exists
        assert data != null;
        for (int key : data) {
            assertTrue(nMethod.contains(key));
        }

        // generate data does exist __ random data hard to get unExisted numbers
        int[] notExist = new int[]{123143, 0, 64247853};

        // Assert that doesn't Exist
        for (int key : notExist) {
            assertFalse(nMethod.contains(key));
        }

        nMethod.print();
        System.out.println("Space Consumed: " + nMethod.spaceConsumed());
    }

    @Test
    public void testNSquareSpaceComplexityMethod_5() {

        Integer[] data = Operations.get_data("test_5");
        IMap nMethod = new NMethod();
        nMethod.hash(data);

        // Assert that Exists
        assert data != null;
        for (int key : data) {
            assertTrue(nMethod.contains(key));
        }

        // generate data does exist __ random data hard to get unExisted numbers
        int[] notExist = new int[]{0};

        // Assert that doesn't Exist
        for (int key : notExist) {
            assertFalse(nMethod.contains(key));
        }

        nMethod.print(); // My PC's struggling
        System.out.println("Space Consumed: " + nMethod.spaceConsumed());
    }
}
