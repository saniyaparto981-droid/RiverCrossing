public interface IState {

    void moveEntity(Entity e);

    boolean[] getPositions();
}