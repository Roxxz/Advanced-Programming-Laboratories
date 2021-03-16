import java.util.*;

public class Solution {
    private Problem problem;

    Solution(Problem p){this.setProblem(p);}

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    /**
     * Imi creez un nou map highSchoolInformation in care o sa salvez fiecare highSchool cu preferintele lui.
     * Imi creez o lista de studenti ce ma va ajuta sa salvez temporar preferintele pentru highSchool x (x=0,1,2).
     * Sortez lista de studenti descrescator dupa score si lista de scoli dupa capacity.
     * Pentru fiecare highschool, iau fiecare student si verific daca este available si daca mai este loc pt el la acel highschool
     * pentru a-l adauga ca si preferinta.
     */
    public void getMatching(List<Student> studentList, List<HighSchool> highSchoolList){
        problem.stud = studentList;
        problem.hs = highSchoolList;
        problem.hs.get(0).setCapacity(1);
        problem.hs.get(1).setCapacity(2);
        problem.hs.get(2).setCapacity(2);
        problem.stud.get(0).setScore(10.0);
        problem.stud.get(1).setScore(8.1);
        problem.stud.get(2).setScore(7.0);
        problem.stud.get(3).setScore(9.6);

        Map<HighSchool, List<Student>> highSchoolInformation = new HashMap<>();
        List<Student> studentsPreferences = new ArrayList<>();

        problem.stud.sort(Comparator.comparing(Student::getScore, Comparator.reverseOrder()));
        problem.hs.sort(Comparator.comparing(HighSchool::getCapacity, Comparator.reverseOrder()));

        for(HighSchool iterator_h : problem.hs){
                for(Student iterator_s : problem.stud){
                    if(iterator_s.available && iterator_h.getCapacity()>0){
                        studentsPreferences.add(iterator_s);
                        iterator_s.available = false;
                        iterator_h.setCapacity(iterator_h.getCapacity()-1);
                    }
                }
                highSchoolInformation.put(iterator_h, studentsPreferences);
                studentsPreferences.clear();
            }
        System.out.println("HighSchools' preferences regarding students are:");
        highSchoolInformation.forEach((key, value) -> System.out.println(key + ":" + value));
    }

}
