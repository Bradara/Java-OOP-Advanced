package MilitaryElite;

import MilitaryElite.Soldiers.Private;
import MilitaryElite.Soldiers.Soldier;

import java.util.HashMap;
import java.util.Map;

public class SoldierManager {
    private Map<String, Soldier> soldiers = new HashMap<>();
    private Map<String, Private> privates = new HashMap<>();

    public String addPrivate(String id, String firstName, String lastName, double salary) {
        soldiers.putIfAbsent(id, Factory.createPrivate(id, firstName, lastName, salary));
        privates.putIfAbsent(id, (Private) soldiers.get(id));
        return soldiers.get(id).toString();
    }

    public String addCommando(String id, String firstName, String lastName, double salary, String[] corps) {
        soldiers.putIfAbsent(id, Factory.createCommando(id, firstName, lastName, salary, corps[0]));
        if (corps.length > 1) {
            for (int i = 1; i < corps.length; i += 2) {
                String mission = corps[i];
                String status = corps[i + 1];
                soldiers.get(id).addMission(mission, status);
            }
        }

        return soldiers.get(id).toString();
    }


    public String addLeutenantGeneral(String id, String firstName, String lastName, double salary, String[] privatesID) {
        soldiers.putIfAbsent(id, Factory.createLeutenantGeneral(id, firstName, lastName, salary));
        for (String p : privatesID) {
            if (privates.containsKey(p)) {
                Private aPrivate = privates.get(p);
                soldiers.get(id).addPrivate(aPrivate);

            }
        }

        return soldiers.get(id).toString();
    }

    public String addSpy(String id, String firstName, String lastName, String codeName) {
        soldiers.putIfAbsent(id, Factory.createSpy(id,firstName, lastName, codeName));
        return soldiers.get(id).toString();
    }

    public String addEngineer(String id, String firstName, String lastName, double salary, String[] corps) {
        if (!(corps[0].equals("Airforces")||corps[0].equals("Marines"))){
            return "";
        }
        soldiers.putIfAbsent(id, Factory.createEngineer(id, firstName, lastName, salary, corps[0]));
        if (corps.length > 1) {
            for (int i = 1; i < corps.length; i += 2) {
                String repair = corps[i];
                Integer hours = Integer.valueOf(corps[i + 1]);
                soldiers.get(id).addRepair(repair, hours);
            }
        }

        return soldiers.get(id).toString();
    }
}
