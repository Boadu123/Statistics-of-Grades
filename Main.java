import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 0;

        while (true) {
            System.out.print("Enter number of students: ");
            if (scanner.hasNextInt()) {
                N = scanner.nextInt();
                if (N > 0) {
                    break;
                } else {
                    System.out.println("Please enter a number greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        
        int[] scores = new int[N];
        System.out.println("Enter all the grades with a space in between, ensure it is between (0-100):");
        for (int i = 0; i < N; i++) {
            while (true) {
                System.out.print("Grades: ");
                if (scanner.hasNextInt()) {
                    int grade = scanner.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        scores[i] = grade;
                        break;
                    } else {
                        System.out.println("Invalid input! Please enter a grade between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();
                }
            }
        }


        int maxGrade = Arrays.stream(scores).max().orElse(0);
        int minGrade = Arrays.stream(scores).min().orElse(0);
        double avgGrade = Arrays.stream(scores).average().orElse(0.0);

        System.out.println("\nValues:");
        System.out.println("The maximum grade is " + maxGrade);
        System.out.println("The minimum grade is " + minGrade);
        System.out.printf("The average grade is %.2f\n", avgGrade);

        int[] stats = new int[5];
        for (int grade : scores) {
            if (grade <= 20) stats[0]++;
            else if (grade <= 40) stats[1]++;
            else if (grade <= 60) stats[2]++;
            else if (grade <= 80) stats[3]++;
            else stats[4]++;
        }

        int maxHeight = Arrays.stream(stats).max().orElse(0);

        System.out.println("\nGraph:\n");
        for (int row = maxHeight; row > 0; row--) {
            System.out.print("   " + row + " > ");
            for (int count : stats) {
                if (count >= row) {
                    System.out.print(" #######   ");
                } else {
                    System.out.print("          ");
                }
            }
            System.out.println();
        }
        
        System.out.print("      +-----------+---------+---------+---------+---------+\n");
        System.out.print("      I  0-20   I  21-40  I  41-60  I  61-80  I  81-100 I\n");

        scanner.close();
    }
}
