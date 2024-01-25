package console;

import model.Operation;
import service.OperationService;

public class ConsoleApplication {

    private final OperationService operationService = new OperationService();
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    public void run() {
        boolean stopCalculating=true;
        while (stopCalculating){
            consoleWriter.write("Enter num 1");
            double num1 = consoleReader.readNum();
            consoleWriter.write("Enter num 2");
            double num2 = consoleReader.readNum();
            consoleWriter.write("Enter operation ('sum', 'min', 'multi', 'div') ");
            String type = consoleReader.readOperationType();
            Operation operation = new Operation(num1, num2, type);
            Operation calculate = operationService.calculate(operation);
            consoleWriter.write("Result = " + calculate.getResult());
            consoleWriter.write("Do you want to keep calculating (yes/no) ?");
            String choice = consoleReader.readNeedToCalculate();
            if (choice.equalsIgnoreCase("no")){
                stopCalculating=false;
            }
        }

    }
}
