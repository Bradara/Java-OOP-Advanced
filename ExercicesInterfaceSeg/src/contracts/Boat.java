package contracts;


public interface Boat extends Modelable{

   int getWeight();

   String getModel();

   boolean hasEngine();

   double calculateSpeed(Race race);
   double calculateTime(Race race);
}
