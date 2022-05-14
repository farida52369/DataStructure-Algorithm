package ds2.lab4.data_generator;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Operations {

    public static void random_data_generator(String fileName, int numOfData) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/tests/" + fileName));

            StringBuilder s = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < numOfData; i++) {
                s.append(Math.abs(random.nextInt(numOfData))).append("\n");
            }

            writer.write(s.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer[] get_data(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/tests/" + fileName));
            List<Integer> res = new LinkedList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                res.add(Integer.parseInt(line));
            }
            reader.close();

            return res.toArray(new Integer[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
