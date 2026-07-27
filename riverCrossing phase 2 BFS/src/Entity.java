public enum Entity {

    //---[mother : 0]--[father : 1]--[daughter1 : 2]--[daughter2 : 3]----
    //---[son1 : 4]--[son2 : 5]--[boat : 6]--[police : 7]--[thief : 8]---
    Mother, Father, Girl1, Girl2, Boy1, Boy2, Boat, Thief, Police;

    public int getIndex(){

        return switch(this){
            case Mother -> 0;
            case Father -> 1;
            case Girl1 -> 2;
            case Girl2 -> 3;
            case Boy1 -> 4;
            case Boy2 -> 5;
            case Boat -> 6;
            case Thief -> 7;
            case Police -> 8;
        };
    }

    public boolean hasDriversLicense(){

        return switch(this){
            case Mother, Father, Police -> true;
            default -> false;
        };
    }


}