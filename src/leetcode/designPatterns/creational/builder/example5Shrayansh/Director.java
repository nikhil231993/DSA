package leetcode.designPatterns.creational.builder.example5Shrayansh;

public class Director {

    StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder){
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent(){

        if(this.studentBuilder instanceof EngineeringStudentBuilder){
            return createEngineeringStudent();
        }
        else if(this.studentBuilder instanceof MBAStudentBuilder){
            return createMBAStudent();
        }
        return null;
    }


    private Student createEngineeringStudent(){

        return this.studentBuilder.setRollNumber(1).setAge(22).setName("sj").setSubjects().build();
    }

    private Student createMBAStudent(){

        return this.studentBuilder.setRollNumber(2).setAge(24).setName("sj").setFatherName("MyFatherName").setMotherName("MyMotherName").setSubjects().build();
    }
}
