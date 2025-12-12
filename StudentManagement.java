import java.util.*;

public class Main{
    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("s1","Nakul",75));
        list.add(new Student("s2","Karan",85));
        list.add(new Student("s3","Shubham",95));

        list.add(new GraduateStudent("G1","tmkoc",33));

        repository<Student>repo = new repository<>()    ;
        for(Student s:list) repo.save(s.getId(),s);
        
        System.out.println("All: ");
        list.forEach(System.out :: println);
        System.out.println("\nLOOKUP s2: ");
        Student s = repo.find("s2");
        System.out.println(s != null ? s : "not found");
        
        Iterator<Student> it = list.iterator();

        while(it.hasNext()){
            Student st = it.next();

            if(st.getMarks()<80){
                it.remove();
                repo.delete(st.getId());

            }
        }

        System.out.println("\nAFTER REMOVAL: ");
        list.forEach(System.out :: println);

        Iterator<Student> it2 = list.iterator();
        String ids = null;
        int max = 0; 
        while(it2.hasNext()){
            Student sta = it2.next();
            
            if(sta.getMarks()>max){
                max = sta.getMarks();
                ids = sta.getId();
            }
        }
        System.out.println("Topper is "+ids);

    }
}

class Student{
    private String id,name;
    private int marks;

    public Student(String id,String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId()   {return id;}
    public int getMarks()   {return marks;}
    
    public String getrole() {return "Undergrad";}

    @Override
    public String toString(){
        return id+" - "+name+" ("+marks+") "+getrole();
    }

}

class GraduateStudent extends Student{
    private String area;

    public GraduateStudent(String id, String name , int marks){
        super(id,name,marks);
        this.area = area;
    }

    public String getrole(){
        return "Grad ("+area+")";
    }
}

class repository<T>{
    private Map<String,T> data = new HashMap<>();

    public void save(String id,T obj){data.put(id,obj);}
    public T find(String id)    {return data.get(id);}
    public void delete(String id)  {data.remove(id);}
}

