import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class CSDesignAssignment4 extends Application {
     private Map<String, Integer> MAP =new HashMap<>(6);
     private int count = 0;

    public static void main(String args[]) {
    launch(args);
        
    }
    
    
   public void start(Stage stage) 
   {
       
               String dropStudents = "Drop TABLE if Exists Students";
        String dropCourses  = "Drop TABLE if Exists Courses";
        String dropClasses  = "Drop TABLE if Exists Classes";
        String dropGrade = "Drop table if exists GradeAggerate";
        
        
        String viewStudents = "Select *From Students";
        String viewCourses = "Select *From Courses";
        String viewClasses = "Select *From Classes";
        String viewGrade = "Select *From GradeAggerate";
                
        //DDL for creating the tables
        String createSchedule = "CREATE TABLE Schedule(courseID varchar (12),sectionNo INT (6),courseTitle varchar (32),year INT(4),semester varchar (12),instructor varchar (32),department varchar (32),program varchar (48),PRIMARY KEY(courseID))";
        String createStudents = "CREATE TABLE Students(emplID INT,firstName varchar (32),lastName varchar (32),email varchar (48),gender CHAR CHECK (gender ='F' OR gender ='M' OR gender ='U' ),PRIMARY KEY(emplID))";
        String createCourses = "CREATE TABLE Courses(courseID varchar (12),courseTitle varchar (32),department varchar (32),PRIMARY KEY(courseID))";
        String createClasses = "CREATE TABLE Classes(courseID varchar (12),studentID INT,sectionNo INT (6),year INT,semester varchar (12),grade char CHECK (grade ='A' OR grade ='B' OR grade ='C'OR grade ='D' OR grade ='F' OR grade ='W'  ) NULL, PRIMARY KEY(courseID,studentID,sectionNo))";
        String createGradeAggerate = "CREATE Table GradeAggerate(grade char,numberStudents INT)";
        
        
        //inserting into Students Table DDL 
              String st1 =  "INSERT INTO Students values (100,'Muner','Khan','Munerkhan99@gmail.com','M')";
              String st2 =  "INSERT INTO Students values (101,'John','Doe','JohnDoe@gmail.com','M')";
              String st3 =  "INSERT INTO Students values (102,'Nicholas','Samuel','NicholasSamuel@gmail.com','M')";
              String st4 =  "INSERT INTO Students values (103,'Allison','Page','AllisonPage@gmail.com','U')"; 
              String st5 =  "INSERT INTO Students values (104,'Penny','Scott','PennyScott@gmail.com','F')";
              String st6 =  "INSERT INTO Students values (105,'Haley','Lawson','HaleyLawson@gmail.com','F')";
              String st7 =  "INSERT INTO Students values (106,'George','Becham','GeorgeBecham@gmail.com','M')";
              String st8 =  "INSERT INTO Students values (107,'Simon','Dan','SimonDan@gmail.com','M')";
              String st9 =  "INSERT INTO Students values (108,'Emma','William','EmmaWilliam@gmail.com','F')";
              String st10 = "INSERT INTO Students values (109,'Joseph','Archer','JosephArcher@gmail.com','M')";
              String st11 = "INSERT INTO Students values (201,'Jay','Parker','JayParker@gmail.com','M')";
              String st12 = "INSERT INTO Students values (202,'Laura','Ross','LauraRoss@gmail.com','M')";
              String st13 = "INSERT INTO Students values (203,'Carl','Layton','CarlLayton@gmail.com','U')";
              String st14 = "INSERT INTO Students values (204,'Victoria','Carter','VictoriaCarter@gmail.com','F')";
              String st15 = "INSERT INTO Students values (205,'Marc','Levine','MarcLevine@gmail.com','F')";
              String st16 = "INSERT INTO Students values (206,'Kelly','Sharp','KellySharp@gmail.com','M')";
              String st17 = "INSERT INTO Students values (207,'Felix','Thompson','FelixThompson@gmail.com','M')";
              String st18 = "INSERT INTO Students values (208,'Eric','Chen','EricChen@gmail.com','F')";
              
              
        //inserting into Classes table
             String c1 = "Insert into Classes values ('22100 F',100,32131,2021,'Spring','C')";
             String c2 = "Insert into Classes values ('22100 P',101,32132,2021,'Spring','B')";
             String c3 = "Insert into Classes values ('22100 R',102,32150,2021,'Spring','A')";
             String c4 = "Insert into Classes values ('22100 F',103,32131,2021,'Spring','A')";
             String c5 =  "Insert into Classes values ('22100 P',104,32132,2021,'Spring','C')";
             String c6 = "Insert into Classes values ('22100 R',105,32150,2021,'Spring','D')";
             String c7 = "Insert into Classes values ('22100 F',106,32131,2021,'Spring','A')";
             String c8 = "Insert into Classes values ('22100 P',107,32132,2021,'Spring','A')";
             String c9 = "Insert into Classes values ('22100 R',108,32150,2021,'Spring','B')";
             String c10 = "Insert into Classes values ('22100 F',109,32131,2021,'Spring','B')";
             String c11 = "Insert into Classes values ('22100 P',201,32132,2021,'Spring','B')";
             String c12 = "Insert into Classes values ('22100 R',202,32150,2021,'Spring','D')";
             String c13 = "Insert into Classes values ('22100 F',203,32131,2021,'Spring','A')";
             String c14 = "Insert into Classes values ('22100 P',204,32132,2021,'Spring','C')";
             String c15 = "Insert into Classes values ('22100 R',205,32150,2021,'Spring','D')";
             String c16 = "Insert into Classes values ('22100 F',206,32131,2021,'Spring','F')";
             String c17 = "Insert into Classes values ('22100 P',207,32132,2021,'Spring','A')";
             String c18 = "Insert into Classes values ('22100 R',208,32150,2021,'Spring','A')";
             
             
             String courses = "INSERT INTO Courses (courseID,courseTitle,department) SELECT courseID,courseTitle,department FROM Schedule";
             String grades = "INSERT INTO GradeAggerate SELECT grade, count(grade) FROM Classes Group BY grade";
        
        
        
        
        
        //String DEFAULT_QUERY = "SELECT *FROM employees";

        try {
                //Class.forName("com.mysql.jdbc.Driver");
                String DATABASE_URL = "jdbc:mysql://localhost:3306/Assignment4";
                String user = "root";
                String password = "p0946751322";
            
                //connect to database 
                Connection con = DriverManager.getConnection(DATABASE_URL,user,password);
                
                
                
                
            
        

               Statement stmt = con.createStatement();
               //stmt.executeUpdate();
             
               
               //drop tables if they exist
                stmt.executeUpdate(dropCourses);
                stmt.executeUpdate(dropStudents);
                stmt.executeUpdate(dropGrade);
                stmt.executeUpdate(dropClasses);
               
              

              //creating all the tables  
              //stmt.executeUpdate(createSchedule);
                stmt.executeUpdate(createStudents);
                stmt.executeUpdate(createCourses);
                stmt.executeUpdate(createClasses);    
                stmt.executeUpdate(createGradeAggerate);
               
               
               
                //inserting into courses 
                stmt.executeUpdate(courses);

              //inserting into classes 
                stmt.executeUpdate(c1);
                stmt.executeUpdate(c2);
                stmt.executeUpdate(c3);
                stmt.executeUpdate(c4);
                stmt.executeUpdate(c5);
                stmt.executeUpdate(c6);
                stmt.executeUpdate(c7);
                stmt.executeUpdate(c8);
                stmt.executeUpdate(c9);
                stmt.executeUpdate(c10);
                stmt.executeUpdate(c11);
                stmt.executeUpdate(c12);
                stmt.executeUpdate(c13);
                stmt.executeUpdate(c14);
                stmt.executeUpdate(c15);
                stmt.executeUpdate(c16);
                stmt.executeUpdate(c17);
                stmt.executeUpdate(c18);
                
                //inserting into students 
                stmt.executeUpdate(st1);
                stmt.executeUpdate(st2);
                stmt.executeUpdate(st3);
                stmt.executeUpdate(st4);
                stmt.executeUpdate(st5);
                stmt.executeUpdate(st6);
                stmt.executeUpdate(st7);
                stmt.executeUpdate(st8);
                stmt.executeUpdate(st9);
                stmt.executeUpdate(st10);
                stmt.executeUpdate(st11);
                stmt.executeUpdate(st12);
                stmt.executeUpdate(st13);
                stmt.executeUpdate(st14);
                stmt.executeUpdate(st15);
                stmt.executeUpdate(st16);
                stmt.executeUpdate(st17);
                stmt.executeUpdate(st18);
                
               stmt.executeUpdate(grades);
               
            Statement stat = con.createStatement();
            ResultSet myrs = stat.executeQuery(viewGrade);
           // Map<String, Integer> MAP =new HashMap<>(6);
             
            
            
            
            while (myrs.next())
            {
                count ++;
                int n = myrs.getInt("numberStudents");
                String g = (myrs.getString("grade"));
                
                if (!MAP.containsKey(g)) 
                { // if letter not in map
                    MAP.put(g,n); // add letter with an occurrence of n
                } 
                
                
            }
            
            
           
        } catch (Exception e) {
            System.out.println(e);
        }
       
       
       
       
       
        // Setting up the display
        Group root = new Group(); // creates root node where all other java classes link back to
       
        Scene scene = new Scene(root); // creates container window where all visuals will appear
        int w = 800, h = 500;
        Canvas canvas = new Canvas(w, h); // creates a canvas of size 800 x 500
        GraphicsContext graphics = canvas.getGraphicsContext2D(); // put all graphics into the canvas
        root.getChildren().add(canvas); // send all children to the canvas
        stage.setScene(scene); // set the scene to display to be the window container
         
        MyPoint mid = new MyPoint(w/2,h/2);
        //HistogramAlphaBet histogram = new HistogramAlphaBet(MAP);
        MyPieChart p1 = new MyPieChart(MAP,count,mid,200);
        p1.Draw(graphics);
        stage.show();
        
        
    }

}



/*
--mysql --local-infil -u root -p 
--use Assignment4
--LOAD DATA local INFILE '/Users/MunerKhan/Desktop/Class Schedule Computer Science Department Spring 2021.txt' INTO TABLE Schedule;
--DROP TABLE IF EXISTS SCHEDULE;


Drop TABLE if Exists Students;
Drop TABLE if Exists Courses;
Drop TABLE if Exists Classes;


--drop Table if Exists Schedule;

CREATE TABLE Schedule(
courseID varchar (12),
sectionNo INT (6),
courseTitle varchar (32),
year INT(4),
semester varchar (12),
instructor varchar (32),
department varchar (32),
program varchar (48),
PRIMARY KEY(courseID)
);

Select *From Schedule;



CREATE TABLE Students(
emplID INT,
firstName varchar (32),
lastName varchar (32),
email varchar (48),
gender CHAR CHECK (gender ='F' OR gender ='M' OR gender ='U' ),
PRIMARY KEY(emplID)
);

INSERT INTO Students values (100,'Muner','Khan','Munerkhan99@gmail.com','M');
INSERT INTO Students values (101,'John','Doe','JohnDoe@gmail.com','M');
INSERT INTO Students values (102,'Nicholas','Samuel','NicholasSamuel@gmail.com','M');
INSERT INTO Students values (103,'Allison','Page','AllisonPage@gmail.com','U');
INSERT INTO Students values (104,'Penny','Scott','PennyScott@gmail.com','F');
INSERT INTO Students values (105,'Haley','Lawson','HaleyLawson@gmail.com','F');
INSERT INTO Students values (106,'George','Becham','GeorgeBecham@gmail.com','M');
INSERT INTO Students values (107,'Simon','Dan','SimonDan@gmail.com','M');
INSERT INTO Students values (108,'Emma','William','EmmaWilliam@gmail.com','F');
INSERT INTO Students values (109,'Joseph','Archer','JosephArcher@gmail.com','M');
INSERT INTO Students values (201,'Jay','Parker','JayParker@gmail.com','M');
INSERT INTO Students values (202,'Laura','Ross','LauraRoss@gmail.com','M');
INSERT INTO Students values (203,'Carl','Layton','CarlLayton@gmail.com','U');
INSERT INTO Students values (204,'Victoria','Carter','VictoriaCarter@gmail.com','F');
INSERT INTO Students values (205,'Marc','Levine','MarcLevine@gmail.com','F');
INSERT INTO Students values (206,'Kelly','Sharp','KellySharp@gmail.com','M');
INSERT INTO Students values (207,'Felix','Thompson','FelixThompson@gmail.com','M');
INSERT INTO Students values (208,'Eric','Chen','EricChen@gmail.com','F');




Select *From Students;


--===========Courses ===============================

CREATE TABLE Courses(
courseID varchar (12),
courseTitle varchar (32),
department varchar (32),
PRIMARY KEY(courseID)
);

INSERT INTO Courses (courseID,courseTitle,department) SELECT courseID,courseTitle,department FROM Schedule;
Select *From Courses;


-------------Classes----------------------------------
Drop TABLE if Exists Classes;

CREATE TABLE Classes(
courseID varchar (12),
studentID INT,
sectionNo INT (6),
year INT,
semester varchar (12),
grade char CHECK (grade ='A' OR grade ='B' OR grade ='C'OR grade ='D' OR grade ='F' OR grade ='W'  ) NULL, 
PRIMARY KEY(courseID,studentID,sectionNo)
);

Insert into Classes values ('22100 F',100,32131,2021,'Spring','A');
Insert into Classes values ('22100 P',101,32132,2021,'Spring','B');
Insert into Classes values ('22100 R',102,32150,2021,'Spring','C');
Insert into Classes values ('22100 F',103,32131,2021,'Spring','A');
Insert into Classes values ('22100 P',104,32132,2021,'Spring','C');
Insert into Classes values ('22100 R',105,32150,2021,'Spring','D');
Insert into Classes values ('22100 F',106,32131,2021,'Spring','A');
Insert into Classes values ('22100 P',107,32132,2021,'Spring','A');
Insert into Classes values ('22100 R',108,32150,2021,'Spring','B');

Insert into Classes values ('22100 F',109,32131,2021,'Spring','B');
Insert into Classes values ('22100 P',201,32132,2021,'Spring','B');
Insert into Classes values ('22100 R',202,32150,2021,'Spring','D');
Insert into Classes values ('22100 F',203,32131,2021,'Spring','A');
Insert into Classes values ('22100 P',204,32132,2021,'Spring','C');
Insert into Classes values ('22100 R',205,32150,2021,'Spring','D');
Insert into Classes values ('22100 F',206,32131,2021,'Spring','D');
Insert into Classes values ('22100 P',207,32132,2021,'Spring','A');
Insert into Classes values ('22100 R',208,32150,2021,'Spring','A');


Select *From Classes;

Drop table if exists GradeAggerate;

create Table GradeAggerate(
    grade char,
    numberStudents INT);

INSERT INTO GradeAggerate
SELECT grade, count(grade)
FROM Classes
Group BY grade;

Select *From GradeAggerate;
*/
