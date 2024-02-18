package application;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

import logic.math.Phytagoras;

public class CalcPhytagoras extends Phytagoras {

    private final Scanner scannerLine;

    private String choices;

    private String announcer  = "Choice Side to Calculate \n";

    public CalcPhytagoras() {
        this.scannerLine = new Scanner(System.in);
    }

    public void start() {
        System.out.println(this.announcer);

        this.displayOptions();
        this.takeUserInput();

        System.out.println("");

        if (!this.choices.isEmpty()) {
            System.out.println("Your choice is: " + this.choices + "\n");

            this.announcer = "Choice Side to Calculate \n";

            this.calculate();
        } else {
            this.announcer = "Please Choice Side to Calculate or press CTRL + C to exit \n";

            this.start();
        }
    }

    void calculate() {
        HashMap<String, Consumer<Double>> func = new HashMap<>(); 
        HashMap<String, String> question = new HashMap<>(); 
        
        System.out.println("Calculate " + this.choices);

        if ("Hypotenuse".equalsIgnoreCase(this.choices)) {

            question.put("question_1", "Enter Perpendicular side: ");
            question.put("question_2", "Enter Base side: ");

            func.put("func_1", this::setPerpendicular);
            func.put("func_2", this::setBase);
            
            this.calc(question, func);

            final Double result = this.calculateHypotenuse();
            System.out.println("Result: " + result);

        } else if ("Perpendicular".equalsIgnoreCase(this.choices)) {

            question.put("question_1", "Enter Hypotenuse side: ");
            question.put("question_2", "Enter Base side: ");

            func.put("func_1", this::setHypotenuse);
            func.put("func_2", this::setBase);
            
            this.calc(question, func);

            final Double result = this.calculatePerpendicular();
            System.out.println("Result: " + result);

        } else if ("Base".equalsIgnoreCase(this.choices)) {

            question.put("question_1", "Enter Hypotenuse side: ");
            question.put("question_2", "Enter Perpendicular side: ");

            func.put("func_1", this::setHypotenuse);
            func.put("func_2", this::setPerpendicular);
            
            this.calc(question, func);

            final Double result = this.calculateBase();
            System.out.println("Result: " + result);

        } else {
            System.out.println("Please enter the correct type \n");
            this.start();
        };
    }

    void calc(HashMap<String, String> question, HashMap<String, Consumer<Double>> func) {
        System.out.println(question.get("question_1"));
        func.get("func_1").accept(scannerLine.nextDouble());
        
        System.out.println("");

        System.out.println(question.get("question_2"));
        func.get("func_2").accept(scannerLine.nextDouble());
        
        System.out.println("");
    }

    void displayOptions() {
        System.out.println("1. Hypotenuse");
        System.out.println("2. Perpendicular");
        System.out.println("3. Base \n");

        System.out.println("Answer:");
    }

    void takeUserInput() {
        this.choices = this.scannerLine.nextLine();
    }
}
