package entity;


public class Student {

    private Long id;
    private String name;
    private String sex;
    private String specialty;
    private String grade;

    public Student() {
    }

    public Student(long id, String name, String sex, String specialty, String grade) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.specialty = specialty;
        this.grade = grade;
    }

    public Student(String name, String sex, String specialty, String grade) {
        this.name = name;
        this.sex = sex;
        this.specialty = specialty;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
