public enum Entity {

    //---[mother : 0]--[father : 1]--[daughter1 : 2]--[daughter2 : 3]----
    //---[son1 : 4]--[son2 : 5]--[boat : 6]------------------------------
    Mother, Father, Daughter1, Daughter2, Son1, Son2, Boat;

    public int getIndex(){

        return switch(this){
            case Mother -> 0;
            case Father -> 1;
            case Daughter1 -> 2;
            case Daughter2 -> 3;
            case Son1 -> 4;
            case Son2 -> 5;
            case Boat -> 6;
        };
    }

    public boolean hasDriversLicense(){

        return switch(this){
            case Mother, Father -> true;
            default -> false;
        };
    }

}