import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static class Hospital {
        String name;
        String location;
        
        List<Doctor> doctorList;
        Hospital(String name, String location, List<Doctor> doctorList) {
            this.name = name;
            this.location = location;
            this.doctorList = doctorList;

        }

        @Override
        public String toString() {
            return "Hospital{" +
                    "name='" + name + '\'' +
                    ", location='" + location + '\'' +
                    ", doctorList=" + doctorList +
                    '}';
        }
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class Doctor extends Person {
        String qualification;

        Doctor(String name, int age, String qualification) {
            super(name, age);
            this.qualification = qualification;
        }

        @Override
        public String toString() {
            return super.toString() + "Doctor{" +
                    "qualification='" + qualification + '\'' +
                    '}';
        }
    }


    String res = "<html><head></head><title>This is a test</title><body>"+
    "<h1>Hello World</h1>"+
    "<p> I am trying something new</p>"+
    "</body>" +
    "</head>" +
    "</html>";

    static Map<String, Hospital> hospitalMap = new HashMap<>();
    public static void main(String[] args) {
        Doctor person1 = new Doctor("Subash", 22, "MD");
        Doctor person2 = new Doctor("Bhisma", 23, "MBBS");
        Hospital hospital = new Hospital("AIIMS", "Delhi", Arrays.asList(person1, person2));

        hospitalMap.put("AIIMS", hospital);

        getHospital();
    }

    private static void getHospital() {
        String hospitalName = "AIIMS";
        Hospital hospital = hospitalMap.get(hospitalName);
        System.out.println(hospital);
    }
}

