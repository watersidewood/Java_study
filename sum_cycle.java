import java.util.Scanner;

public class sum_cycle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        in.close();

        int cnt = 0;
        int copy = num;

        while (true) {
            num = ((num % 10) * 10) + (((num / 10) + (num % 10)) % 10);
            cnt++;

            if (copy == num) {
                break;
            }
        }
        System.out.println(cnt);
    }
}