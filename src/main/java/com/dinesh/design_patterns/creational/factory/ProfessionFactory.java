package com.dinesh.design_patterns.creational.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessionFactory {
    private static Map<String, Profession> map = new HashMap<>(){{
        put("doctor", new Doctor());
        put("engineer", new Engineer());
        put("teacher", new Teacher());
        put("programmer", new Programmer());
    }};
    public static Profession getProfession(String profession) {
//        if(profession == null) return null;
//        if(profession.equals("doctor")) return new Doctor();
//        if(profession.equals("engineer")) return new Engineer();
//        if(profession.equals("teacher")) return new Teacher();
//        if(profession.equals("programmer")) return new Programmer();
        if(map.containsKey(profession)) return map.get(profession);
        throw new Error("Profession "+ profession + " not found !");
    }
}
