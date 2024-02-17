package readline;


import java.util.Scanner;
public class ScannerLine {

    private Scanner scan = new Scanner(System.in);
        
    public ScannerLine() {     
        if (this.scan == null) {
            System.out.println("No Scanner Available");
        }
    }

    public void run() {
        System.out.println("Enter Your Name");
        String question = this.scan.nextLine();
        System.out.println("Your Name " + question);
    }

    public Scanner getScanner() {
        return this.scan;
    }

}
