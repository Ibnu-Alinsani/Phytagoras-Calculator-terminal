package application;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

import logic.math.Phytagoras;

public class Application extends Phytagoras {

    Scanner scannerLine;

    String choices;

    enum sidePhytagoras {
        Hypotenuse, Perpendicular, Base
    };

    public Application() {
        this.scannerLine = new Scanner(System.in);
        // HashMap<String, Object> mapperFunction;
        // mapperFunction.put("hypo", super.setPerpendicular);
    }

    public void choice() {
        System.out.println("Choice Side to Calculate \n");

        System.out.println("1. Hypotenuse");
        System.out.println("2. Perpendicular");
        System.out.println("3. Base \n");

        System.out.println("Answer:");

        this.choices = this.scannerLine.nextLine();

        System.out.println("");

        System.out.println("Your choice is: " + this.choices + "\n");

        if (this.choices != "") {
            this.calculate();
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
            // this.calcPerpen();
            // final Double result = super.calculatePerpendicular();

            // System.out.println("Result: " + result);
        } else if ("Base".equalsIgnoreCase(this.choices)) {
            question.put("question_1", "Enter Hypotenuse side: ");
            question.put("question_2", "Enter Perpendicular side: ");

            func.put("func_1", this::setHypotenuse);
            func.put("func_2", this::setPerpendicular);
            
            this.calc(question, func);

            final Double result = this.calculateBase();

            System.out.println("Result: " + result);
        } else {
            System.out.println("Please enter the correct type");
            this.choice();
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
}
