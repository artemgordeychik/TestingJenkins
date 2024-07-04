package tests;

import exceptions.CustomCheckedException;
import exceptions.CustomUncheckedException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionsTest {
    @Test
    public void throwCheckedException() throws CustomCheckedException {
        try (Scanner file = new Scanner(new File("fileName.json"))) {
            if (file.hasNextLine())
                file.nextLine();
        } catch (FileNotFoundException err) {
            throw new CustomCheckedException("Incorrect filename : ");
            // throw new CustomCheckedException(
            //         "Incorrect filename : ", err);
        }
    }

    @Test
    public void throwUncheckedException() {
        try (Scanner file = new Scanner(new File("fileName.json"))) {
            if (file.hasNextLine())
                file.nextLine();
        } catch (FileNotFoundException err) {
            throw new CustomUncheckedException("Incorrect filename : ");

        } catch (CustomUncheckedException err) {

            throw new CustomUncheckedException(
                    "Filename does not contain extension : ", err);
        }
    }
}

class Factorial {

    public static int getFactorial(int num) throws FactorialException {

        int result = 1;
        if (num < 1) throw new FactorialException("The number is less than 1", num);

        for (int i = 1; i <= num; i++) {

            result *= i;
        }
        return result;
    }
}

class FactorialException extends Exception {

    private int number;

    public int getNumber() {
        return number;
    }

    public FactorialException(String message, int num) {

        super(message);
        number = num;
    }
}