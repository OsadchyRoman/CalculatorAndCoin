package task_3.com.epam.training.inner;

import task_3.com.epam.training.inner.service.ServiceCalculatorAndCoin;

public class Runner {
    public static void main(String[] args) {
        ServiceCalculatorAndCoin serviceCalculatorAndCoin =
                new ServiceCalculatorAndCoin("D:\\Java\\CoinsAndCalculator\\CoinsAndCalculator\\1.txt",
                "D:\\Java\\CoinsAndCalculator\\CoinsAndCalculator\\out.txt");
        serviceCalculatorAndCoin.toDoWork();
    }
}
