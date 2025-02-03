import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

class Calculator {
    public static void main(String[] args) throws Exception{
        try {
            Path path = Paths.get("C:\\Users\\karam\\IdeaProjects\\skyscraper\\src\\main\\java\\input.txt");
            String content = Files.readString(path);
            calculator(content);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void calculator(String content) throws Exception {
        double result = 0;
        double a=0;
        double b=0;
        String[] arr = content.split(" ");

        try {
            a = Double.parseDouble(arr[0]);
            b = Double.parseDouble(arr[2]);
        } catch (Exception e) {
            System.out.println("Error! Not number");
            return;
        }
        switch (arr[1]){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Error! Division by zero");
                    return;
                }
                result = a / b;
                break;
            default:
                System.out.println("Operation Error!");
                return;
        }
        output(String.valueOf(result));

    }
    public static void output(String result) throws Exception {
        try {
            Files.writeString(Path.of("C:\\Users\\karam\\IdeaProjects\\Calculator\\src\\main\\java\\output1.txt"),result);
        }
        catch (IOException e){
            System.out.println("Ошибка записи в файл" + e.getMessage());
        }

    }

}
