package com.lin.design.patterns.strategy;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 1/26/2022
 */
public class Application {
    public static void main(String[] args) {
        Context context = new Context();
        int firstNumber = 10;
        int secondNumber = 23;
        if (args == null || args.length < 1) {
            return;
        }
        String action = args[0];
        if ("addition".equalsIgnoreCase(action)) {
            context.setStrategy(new ConcreteStrategyAdd());
        }
        if ("subtraction".equalsIgnoreCase(action)) {
            context.setStrategy(new ConcreteStrategySubtract());
        }
        if ("multiplication".equalsIgnoreCase(action)) {
            context.setStrategy(new ConcreteStrategyMultiply());
        }
        System.out.println(context.executeStrategy(firstNumber, secondNumber));
        System.out.println("==Over==");

    }
}
