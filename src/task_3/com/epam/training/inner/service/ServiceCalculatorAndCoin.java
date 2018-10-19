package task_3.com.epam.training.inner.service;

/**
 * Service for choose mode coin or
 * calculator.
 *
 * @version 2.1
 * @autor Asadchy Raman
 */
public class ServiceCalculatorAndCoin {
/*
    *//**
     * Path inner file
     *//*
    private final String pathIn;
    *//**
     * Path out file
     *//*
    private final String pathOut;

    *//**
     * Initializes a newly created {@code ServiceCalculatorAndCoin}.
     * And started work with inner file.
     *
     * @param pathIn  Path to inner file
     * @param pathOut Path to outer file
     *//*
    public ServiceCalculatorAndCoin(String pathIn, String pathOut) {
        this.pathIn = pathIn;
        this.pathOut = pathOut;
        toDoWork();
    }

    *//**
     * Getter method for inner path file.
     *
     * @return Inner file path
     *//*
    public String getPathIn() {
        return pathIn;
    }

    *//**
     * Getter method for outer path file.
     *
     * @return Outer file path
     *//*
    public String getPathOut() {
        return pathOut;
    }

    *//**
     * Method choose mode with which to work.
     * And validate mode.
     *//*
    private void toDoWork() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathIn)));
             PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(pathOut))))) {
            String mode = bufferedReader.readLine().toLowerCase();

            if (mode.equals(CALCULATOR_MODE)) {
                workMode(new CalculatorMode(bufferedReader, printWriter));
            } else if (mode.equals(COINS_MODE)) {
                workMode(new CoinsMode(bufferedReader, printWriter));
            } else {
                printWriter.printf("Ошибка входного файла");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void workMode(IMode iMode) throws IOException {
        iMode.toDoMode();
    }


    *//**
     * Calculator mode. Mode calculate
     * expression in inner file and validate
     * all information in the inner file.
     * After validate write result in out file.
     *
     * @param scanner    For reading inner file
     * @param fileWriter For write in outer file
     * @throws Exception If file not found or file is not writable
     *//*
    private void calculatorMode(Scanner scanner, FileWriter fileWriter) throws Exception {
        FileValidator fileValidator = new FileValidator();
        CalculateTaskValidator calculateValidator = new CalculateTaskValidator();
        Calculator calculator = new Calculator();
        String capacity = scanner.nextLine();
        int i = 0;

        if (fileValidator.validateCapacity(new FileReader(pathIn), capacity, fileWriter)) {
            String[] task = new String[Integer.parseInt(capacity)];
            while (scanner.hasNextLine()) {
                task[i] = scanner.nextLine();
                if (calculateValidator.validateCalculatorMode(task[i], fileWriter)) {
                    String opn = calculator.getNotation(task[i]);
                    double result = calculator.calculateResult(opn);
                    fileWriter.write("\n" + result);
                }
                i++;
            }
        }
    }

    *//**
     * Coin mode. Mode exchange sum on coins for
     * denomination and validate all information
     * in the inner file. After validate, write
     * result in out file.
     *
     * @param scanner    For reading inner file
     * @param fileWriter For write in outer file
     * @throws Exception If file not found or file is not writable
     *//*
    private void coinMode(Scanner scanner, FileWriter fileWriter) throws Exception {
        FileValidator fileValidator = new FileValidator();
        String capacity = scanner.nextLine();
        int index = 0;

        if (fileValidator.validateCapacity(new FileReader(pathIn), capacity, fileWriter)) {
            String[] tasks = new String[Integer.parseInt(capacity)];
            if (fileValidator.validateOnCharacter(new FileReader(pathIn),
                    fileWriter, Integer.parseInt(capacity))) {
                while (scanner.hasNextLine()) {
                    fileWriter.write("\n\n");
                    tasks[index] = scanner.nextLine();
                    new CoinTaskValidator(tasks[index], fileWriter);
                    index++;
                }
            }
        }
    }*/
}
