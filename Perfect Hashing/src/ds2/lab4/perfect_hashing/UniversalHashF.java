package ds2.lab4.perfect_hashing;

import java.util.Random;

public class UniversalHashF {

    private final int b;
    private boolean[][] h_matrix;
    private boolean[][] x_matrix;
    private boolean[][] res_matrix;

    private static final int BIT_INTEGER_32 = 32;

    public UniversalHashF(int M) {
        // b = (log(M) for the base(2))
        this.b = (int) (Math.log(M) / Math.log(2));
        generate_h_matrix();
    }

    private void generate_h_matrix() {
        this.h_matrix = new boolean[b][BIT_INTEGER_32];

        // Construct h matrix dimensions (b, 32)
        Random random = new Random();
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < BIT_INTEGER_32; j++) {
                h_matrix[i][j] = random.nextBoolean();
            }
        }
    }

    private void generate_x_matrix(int x) {
        this.x_matrix = new boolean[BIT_INTEGER_32][1];

        // Construct x matrix dimensions (32, 1)
        String keyInBinary = Integer.toBinaryString(x);
        int len = keyInBinary.length();
        for (int i = 0; i < len; i++) {
            x_matrix[len - 1 - i][0] = (keyInBinary.charAt(i) == '1');
        }
    }

    private void generate_res_matrix() {
        this.res_matrix = new boolean[b][1];

        // Construct h(x) matrix dimensions (b, 1)
        // (h(i, k) & x(k, j)) % 2
        for (int i = 0; i < b; i++) {
            boolean value = false;
            for (int k = 0; k < BIT_INTEGER_32; k++) {
                value = value ^ (h_matrix[i][k] & x_matrix[k][0]);
            }
            res_matrix[i][0] = value;
        }
    }

    public int hash(int key) {
        generate_x_matrix(key);
        generate_res_matrix();

        // for b-bits long there's (2^b = M) slots to hash to
        // That's the next step
        // convert res_matrix (h(x)) to the representing integer
        int radix = 1, res = 0;
        for (int i = 0; i < b; i++) {
            if (res_matrix[i][0])
                res += radix;
            radix *= 2;
        }
        return res;
    } // Oooops! finally, ended.
}
