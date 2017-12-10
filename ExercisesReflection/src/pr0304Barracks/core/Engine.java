package pr0304Barracks.core;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.core.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;
	public static final String CLASS_NAME_PREFIX = "pr0304Barracks.core.commands.";
	public static final String CLASS_NAME_SUFIX = "Command";

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpredCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | IllegalAccessException | ClassNotFoundException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
				e.printStackTrace();
			}
        }
	}

	// TODO: refactor for problem 4
	private String interpredCommand(String[] data, String commandName) throws IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		String result;
		String className = CLASS_NAME_PREFIX + String.valueOf(commandName.charAt(0)).toUpperCase() + commandName.substring(1) + CLASS_NAME_SUFIX;
		Class<?> cl = Class.forName(className);
        Constructor constructor = cl.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
        constructor.setAccessible(true);
        Object command = constructor.newInstance(data, this.repository, this.unitFactory);
        Method execute = cl.getDeclaredMethod("execute");
        result = (String) execute.invoke(command);


//		switch (commandName) {
//			case "add":
//				result = this.addUnitCommand(data);
//				break;
//			case "report":
//				result = this.reportCommand(data);
//				break;
//			case "fight":
//				result = this.fightCommand(data);
//				break;
//			default:
//				throw new RuntimeException("Invalid command!");
//		}
		return result;
	}

//	private String reportCommand(String[] data) {
//		String output = this.repository.getStatistics();
//		return output;
//	}
//
//	private String addUnitCommand(String[] data) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//		String unitType = data[1];
//		Unit unitToAdd = this.unitFactory.createUnit(unitType);
//		this.repository.addUnit(unitToAdd);
//		String output = unitType + " added!";
//		return output;
//	}
//
//	private String fightCommand(String[] data) {
//		return "fight";
//	}
}
