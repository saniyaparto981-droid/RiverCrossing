import java.util.ArrayList;
import java.util.List;

public class ChildNodeGenerate implements IChidNodeGenerator{


    @Override
    public List<INode> generate(INode node) {

        List<INode> possibleNodes = new ArrayList<>();
        List<Entity> possibleDrivers = new ArrayList<>();
        List<Entity> possiblePassengers = new ArrayList<>();


        for (Entity entity : Entity.values()){

            if (isInBoatSide(entity, node) && isRider(entity))
                possibleDrivers.add(entity);

            if (isInBoatSide(entity, node))
                possiblePassengers.add(entity);
        }


        for (Entity driver : possibleDrivers){

            INode cloned = node.clone();

            cloned.setState(new Entity[]{Entity.Boat, driver});
            possibleNodes.add(cloned);


            for (Entity passenger : possiblePassengers){

                if (!isPassengerValid(driver, passenger))
                    continue;

                INode cloned2 = node.clone();
                cloned2.setState(new Entity[]{Entity.Boat, driver, passenger});
                possibleNodes.add(cloned2);
            }
        }

        return possibleNodes;
    }

    private boolean isRider(Entity e){

        return (e.hasDriversLicense()) && (e != Entity.Boat);
    }

    private boolean isInBoatSide(Entity e, INode node){

        boolean entitySide = node.getState().getPositions()[e.getIndex()];
        boolean boatside = node.getState().getPositions()[Entity.Boat.getIndex()];

        return (entitySide == boatside) && (e != Entity.Boat);
    }

    private boolean isPassengerValid(Entity driver, Entity passenger){

        if (driver == passenger)
            return false;

        if ((driver == Entity.Father) &&
                ((passenger == Entity.Daughter1) || (passenger == Entity.Daughter2)))
            return false;

        if ((driver == Entity.Mother) &&
            ((passenger == Entity.Son1) || (passenger == Entity.Son2)))
            return false;

        return true;
    }
}