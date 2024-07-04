package tests;

import org.testng.annotations.Test;

import java.lang.annotation.Annotation;

public class GenericTest {


    @Test
    public void generic() {

    }

    interface Accountable<T>{
        T getId();
        int getSum();
        void setSum(int sum);
    }
    class Account<T, S> implements Accountable<T> {

        private T id;
        private int sum;

        Account(T id, int sum) {
            this.id = id;
            this.sum = sum;
        }

        public T getId() {
            return id;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        //generic method
        public <Y> void print(Y[] items) {
            for (Y item : items) {
                System.out.println(item);
            }
        }
    }


    //extend generic
    class Transaction<T extends Account>{

        private T from;     // с какого счета перевод
        private T to;       // на какой счет перевод
        private int sum;    // сумма перевода

        Transaction(T from, T to, int sum){
            this.from = from;
            this.to = to;
            this.sum = sum;
        }
        public void execute(){

            if (from.getSum() > sum)
            {
                from.setSum(from.getSum() - sum);
                to.setSum(to.getSum() + sum);
                System.out.printf("Account %s: %d \nAccount %s: %d \n",
                        from.getId(), from.getSum(),to.getId(), to.getSum());
            }
            else{
                System.out.printf("Operation is invalid");
            }
        }
    }

}
