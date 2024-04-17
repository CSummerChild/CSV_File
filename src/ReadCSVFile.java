import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {

    public static void main(String[] args) {
        String fileName = "Book1.csv";
        int sum = 0;
        int count = 0;
        int lowest = Integer.MAX_VALUE;
        int highest = Integer.MIN_VALUE;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split(","); // Split the line by comma
                for (String numString : numbers) {
                    int num = Integer.parseInt(numString.trim());
                    sum += num;
                    count++;
                    if (num < lowest) {
                        lowest = num;
                    }
                    if (num > highest) {
                        highest = num;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("There was a problem opening or reading the file.");
            return;
        }

        // Print sum, lowest, highest
        System.out.println("The sum is: " + sum);
        System.out.println("The lowest number is: " + lowest);
        System.out.println("The highest number is: " + highest);

        // Calculate and print average
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("The average of the numbers is: " + average);
        } else {
            System.out.println("No numbers found in the file.");
        }
    }
}
