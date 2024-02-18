package application;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

import static VerseMinds.ColoredConsole.ColoredConsole.*;

import logic.math.Phytagoras;
// import static VerseMinds.ConsolColor;

public class CalcPhytagoras extends Phytagoras {

    private final Scanner scannerLine;

    private String choices;
    private Boolean isErrorInput;

    public CalcPhytagoras() {
        this.scannerLine = new Scanner(System.in);
        this.isErrorInput = false;
    }

    public void start() {
        if (!this.isErrorInput) {
            println("Choose Side to Calculate \n", CYAN);
        } else {
            println("Please Choose Side to Calculate or Press CTRL + C to Exit \n", YELLOW);
        }

        this.displayOptions();
        this.takeUserInput();

        println("");

        if (!this.choices.isEmpty()) {
            println("Your choice is: " + this.choices + "\n", GREEN);

            this.isErrorInput = false;

            this.calculate();
        } else {
            this.isErrorInput = true;

            this.start();
        }
    }

    void calculate() {
        HashMap<String, Consumer<Double>> func = new HashMap<>(); 
        HashMap<String, String> question = new HashMap<>(); 
        
        println("Calculate " + this.choices);

        if ("Hypotenuse".equalsIgnoreCase(this.choices)) {

            // Set the question
            question.put("question_1", "Enter Perpendicular side: ");
            question.put("question_2", "Enter Base side: ");

            // Set the function
            func.put("func_1", this::setPerpendicular);
            func.put("func_2", this::setBase);
            
            // calculate
            this.calc(question, func);

            // get result and display
            final Double result = this.calculateHypotenuse();
            println("Result: " + result, GREEN);

        } else if ("Perpendicular".equalsIgnoreCase(this.choices)) {

            question.put("question_1", "Enter Hypotenuse side: ");
            question.put("question_2", "Enter Base side: ");

            func.put("func_1", this::setHypotenuse);
            func.put("func_2", this::setBase);
            
            this.calc(question, func);

            final Double result = this.calculatePerpendicular();
            println("Result: " + result, GREEN);

        } else if ("Base".equalsIgnoreCase(this.choices)) {

            question.put("question_1", "Enter Hypotenuse side: ");
            question.put("question_2", "Enter Perpendicular side: ");

            func.put("func_1", this::setHypotenuse);
            func.put("func_2", this::setPerpendicular);
            
            this.calc(question, func);

            final Double result = this.calculateBase();
            println("Result: " + result, GREEN);

        } else {
            println("Please enter the correct type \n", RED);
            this.start();
        };
    }

    void calc(HashMap<String, String> question, HashMap<String, Consumer<Double>> func) {
        // Display Question 1
        println(question.get("question_1"), CYAN);
        // Execute Function 1
        func.get("func_1").accept(scannerLine.nextDouble());
        
        println("");

        // Display Question 2
        println(question.get("question_2"), CYAN);
        // Execute Function 2
        func.get("func_2").accept(scannerLine.nextDouble());
        
        println("");
    }

    void displayOptions() {
        println("1. Hypotenuse");
        println("2. Perpendicular");
        println("3. Base \n");

        println("Answer:", CYAN);
    }

    void takeUserInput() {
        this.choices = this.scannerLine.nextLine();
    }
}
