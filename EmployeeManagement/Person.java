public class Person {
    private  String name;
    private int age;
    private String gender;
    private int experience;
    private String skillLevel;
    private String city;
    Person(){}
    public Person(String name, int age, String gender,String skillLevel,int experience, String city) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.skillLevel=skillLevel;
        this.experience=experience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getExperience() {
        return experience;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public String getCity() {
        return city;
    }
    public String getDetails(){
        return ("{Name: "+getName()+", Age: "+ getAge()+", Experience: "+getExperience()+", skill: "+ getSkillLevel()+ ", City: "+ getCity()+"}");
    }
}
