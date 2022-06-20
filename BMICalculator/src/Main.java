import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input height :");
        double height = scanner.nextDouble();
        System.out.println("Input weight :");
        double weight = scanner.nextDouble();

        double bmi = weight / (height * height);

        System.out.println("Your bmi is : " + bmi);

        if (bmi <= 18.5) {
            System.out.println("You are underweight !");
        } else if (bmi > 18.5 && bmi < 24.9) {
            System.out.println("You are normal weight !");
        } else if (bmi > 25 && bmi < 25.9) {
            System.out.println("You are overweight !");
        } else if (bmi > 30) {
            System.out.println("You are in risk of obesity !");
        } else {
            System.out.println("You are ok !");
        }
    }
}
