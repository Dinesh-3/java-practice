package com.dinesh.design_patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeProfession implements Cloneable{
    private final static Map<String, AbstractProfession> map = new HashMap<>();
    static {
//        System.out.println("\"CALLED\" = " + "CALLED");
        map.put("doctor",new Doctor());
        map.put("engineer",new Engineer());
        map.put("programmer",new Programmer());
        map.put("teacher",new Teacher());
    }
    public static AbstractProfession getNewClone(String profession) {
        AbstractProfession result = map.get(profession);
        try {
            return (AbstractProfession) result.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        throw new Error("Profession "+ profession + " not found !");
    }

//    public static void loadProfessions() {
//
//    }

}
