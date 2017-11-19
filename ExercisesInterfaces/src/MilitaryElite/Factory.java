package MilitaryElite;

import MilitaryElite.Soldiers.*;

public class Factory {
    public static Private createPrivate(String id, String firstName, String lastName, double salary){
        return new Private(id, firstName, lastName, salary);
    }
    public static LeutenantGeneral createLeutenantGeneral(String id, String firstName, String lastName, double salary){
        return new LeutenantGeneral(id, firstName, lastName, salary);
    }
    public static Engineer createEngineer(String id, String firstName, String lastName, double salary, String corps){
        return new Engineer(id, firstName, lastName, salary, corps);
    }

    public static Commando createCommando(String id, String firstName, String lastName, double salary, String corps){
        return new Commando(id, firstName, lastName, salary, corps);
    }

    public static Spy createSpy(String id, String firstName, String lastName, String codeName){
        return new Spy(id, firstName, lastName, codeName);
    }


}
