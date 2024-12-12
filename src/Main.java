import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    String tempInput;
    String conversionTypeInput;
    float result;

    System.out.println("Welcome to Temperature Converter app");
    System.out.println();

    System.out.println("Temperature to convert (include C, F, or K at the end): ");
    tempInput = scan.nextLine().trim();

    int tempLength = tempInput.length();
    String centigrade = tempInput.substring(tempLength - 1).toUpperCase();
    String tempValue = tempInput.substring(0, tempLength - 1);
    double temp;

    if (!centigrade.equals("C") && !centigrade.equals("F") && !centigrade.equals("K")) {
      System.out.println("Please enter a valid centigrade/input");
      return;
    }

    try {
      temp = Double.parseDouble(tempValue);
    }
    catch (NumberFormatException e) {
      System.out.println("Please enter a valid number");
      return;
    }

    System.out.println("Convert to? (C, F, or K) ");
    conversionTypeInput = scan.nextLine().toUpperCase().trim();

    switch (conversionTypeInput) {
      case "F":
        switch (centigrade) {
          case "C":
            result = (float) ((temp * 9/5) + 32);
            System.out.println(result + " " + conversionTypeInput);
            break;
          case "K":
            result = (float) ((temp - 273.15) * 9/5 + 32);
            System.out.println(result + " " + conversionTypeInput);
            break;
          case "F":
            System.out.println(temp + " " + conversionTypeInput);
            break;
        }
        break;
      case "C":
        switch (centigrade) {
          case "C":
            System.out.println(temp + " " + conversionTypeInput);
            break;
          case "K":
            result = (float) (temp - 273.15);
            System.out.println(result + " " + conversionTypeInput);
            break;
          case "F":
            result = (float) (temp - 32) * 5/9;
            System.out.println(result + " " + conversionTypeInput);
            break;
        }
        break;
      case "K":
        switch (centigrade) {
          case "C":
            result = (float) (temp + 273.15);
            System.out.println(result + " " + conversionTypeInput);
            break;
          case "K":
            System.out.println(temp + " " + conversionTypeInput);
            break;
          case "F":
            result = (float) ((temp - 32) * ((double) 5 /9) + 273.15) ;
            System.out.println(result + " " + conversionTypeInput);
            break;
        }
        break;
      default:
        System.out.println("Please enter a valid centigrade");
    }
  }
}