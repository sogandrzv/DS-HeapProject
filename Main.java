import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int memory = scanner.nextInt();
        List list = new List(memory);
        int count = scanner.nextInt();
        scanner.skip("[\r\n]+");
        ArrayList<String> commands = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            commands.add(scanner.nextLine());
        }
        String command;
        int number;
        for (int i = 0; i < count; i++) {
            command = commands.get(i).split(" ")[0];
            number = Integer.parseInt(commands.get(i).split(" ")[1]);
            if (command.startsWith("m")) {
                list.malloc(number);
            } else if (command.startsWith("f")) {
                list.free(number);
            } else {
                System.out.println("Wrong command");
            }
        }
    }
}
