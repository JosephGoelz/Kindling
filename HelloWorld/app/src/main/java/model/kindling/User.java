package model.kindling;
//the model package will handle the apps data
/**
 * Created by Jay on 4/21/2015.
 */
public class User {
    //the user class as described in the DDD
    private String name, userName, password;
    private int age, intelLevel;
    private int sexualOrientation; // 0 = into males, 1 = into females, 2 = into both
    private int sex; // 0 = male, 1 = female
    private Range intelRange;
    private Range ageRange;
    //add an image format tbd

    public User(){
        //possibly set to some default values
    }

    public void setName (String _name){
        this.name = _name;
    }
    public String getName (){
        return name;
    }

    public void setUserName (String _userName){
        this.userName = _userName;
    }
    public String getUserName (){
        return userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getIntelLevel() {
        return intelLevel;
    }

    public void setIntelLevel(int intelLevel) {
        this.intelLevel = intelLevel;
    }

    public int getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(int sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String p) {
        password = p;
    }

}
