package DesignPatterns.creational.factory;

public class ProfessionFactory {
    public static Profession getProfession(String profession) {
//        if(profession == null) return null;
        if(profession.equals("doctor")) return new Doctor();
        if(profession.equals("engineer")) return new Engineer();
        if(profession.equals("teacher")) return new Teacher();
        if(profession.equals("programmer")) return new Programmer();
        throw new Error("Profession "+ profession + " not found !");
    }
}
