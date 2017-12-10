package pr0304Barracks.contracts;

import java.util.Map;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);

	Map<String, Integer> getAmountOfUnits();
}
