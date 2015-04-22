package model.kindling;
//the model package will handle the apps data
/**
 * Created by Jay on 4/21/2015.
 */
public class User {
    //the user class as described in the DDD
    private String name, userName;
    private int age, intel_level;
    private int sexual_orientation;
    private int sex;
    private Range intelRange;
    private Range ageRange;
    //add an image format tbd

    public User(){
        //possibly set to some default values
    }

    private void setName (String _name){
        this.name = _name;
    }
    private String getName (){
        return name;
    }

    private void setUserName (String _userName){
        this.userName = _userName;
    }
    private String getUserName (){
        return userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIntel_level() {
        return intel_level;
    }

    public void setIntel_level(int intel_level) {
        this.intel_level = intel_level;
    }

    public int getSexual_orientation() {
        return sexual_orientation;
    }

    public void setSexual_orientation(int sexual_orientation) {
        this.sexual_orientation = sexual_orientation;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Range getIntelRange() {
        return intelRange;
    }

    public void setIntelRange(Range intelRange) {
        this.intelRange = intelRange;
    }

    public Range getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(Range ageRange) {
        this.ageRange = ageRange;
    }
    //getter and setter functions

}
