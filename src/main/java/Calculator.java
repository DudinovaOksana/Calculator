import java.io.*;

class Calculator {
    public static void main(String[] args) throws Exception{
        String outputPath = "C:\\Users\\karam\\IdeaProjects\\Calculator\\src\\main\\java\\output1.txt";
        try {
            FileWriter writer = new FileWriter(outputPath);
            writer.close();
        }
        catch (IOException e){
            System.out.println("Ошибка записи в файл" + e.getMessage());
        }
        try {
            String path = "C:\\Users\\karam\\IdeaProjects\\Calculator\\src\\main\\java\\input.txt";
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while (true) {
                line = reader.readLine();
                if (line == null) { break;}
                    String resultOfCalculator = calculator(line);
                    output(outputPath, line, resultOfCalculator);
            }
            reader.close();}
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String calculator(String line) throws Exception {
        double result = 0;
        double a=0;
        double b=0;
        String[] arr = line.split(" ");

        try {
            a = Double.parseDouble(arr[0]);
            b = Double.parseDouble(arr[2]);
        } catch (Exception e) {
            return "Error! Not number";

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
                    return "Error! Division by zero";
                }
                result = a / b;
                break;
            default:
                return "Operation Error!";
        }
        return String.valueOf(result);

    }
    public static void output(String path, String content,String result) throws Exception {
        try {
            FileWriter writer = new FileWriter(path, true);
            String writeOutput = content+" = "+result + "\n";
            writer.write(writeOutput);
            writer.close();
            System.out.println(content+" = "+result);
        }

        catch (IOException e){
            System.out.println("Ошибка записи в файл" + e.getMessage());
        }
    }
}
