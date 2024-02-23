package Model;

public class Student {

    private String id;
    private String name;
    private String course;
    private int semester;
    public Student(String id, String name, String course, int semester){
        this.id = id;
        this.name = name;
        this.course = course;
        this.semester = semester;
    }


    public void setCourse(String course) {
        this.course = course;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public String getCourse() {
        return course;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getSemester() {
        return semester;
    }
    
    @Override
    public String toString(){
        return "-> " + id +" | " + name + " | " + course + " | " + semester;
    }
}
