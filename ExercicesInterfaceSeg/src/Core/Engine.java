package Core;

import contracts.InputReader;
import io.ConsoleInputReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private CommandHandler commandHandler;

    public Engine() {
        this.commandHandler = new CommandHandler();
    }

    //public Command getCommandHandler;

    public void Run() {
        InputReader input = new ConsoleInputReader();
        String line = input.readLine();
        String name;
        List<String> parameters;
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (line.equals("End")) {
                break;
            }

            List<String> tokens = Arrays.asList(line.split("\\\\"));
            name = tokens.get(0);
            parameters = tokens.stream().skip(1).collect(Collectors.toList());

            try {
                sb.append(this.commandHandler.executeCommand(name, parameters)).append(System.lineSeparator());

            } catch (Exception ex) {
                sb.append(ex.getMessage());
            }

            line = input.readLine();
        }

        System.out.println(sb);

    }
}
