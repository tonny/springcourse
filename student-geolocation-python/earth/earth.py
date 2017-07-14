from classroom import ClassRoom
from student import Student

class Earth:
    """Earth class to find students in course"""
    def __init__(self):
        self.name = None

    def studentsInClasses(self, students, classRooms):
        """
        Function to verify if a bunch of students is inside of a list of class room

        @param students : is a students list -> [Student]
        @param classRooms : is a classRooms list -> [ClassRoom]

        @return: list with all students found inside a course
        @rtype : [Student]
        """
        studentsFound = []
        for classRoom in classRooms :
            for student in students :
                if classRoom.isStudentInClassRoom(student.position) :
                    studentsFound.append(student)

        return studentsFound


    def studentClustersInClasses(self, students, classRooms):
        """
        Function to find and return class rooms that has at least two students inside

        @param students : is a students list -> [Student]
        @param classRooms : is a class rooms list -> [ClassRoom]

        @return: a class room list whit has at least two students
        @rtype : [ClassRoom]
        """
        # Closure function to verify if the student is inside of classRoom
        def verify(student,clas):
            if not hasattr(clas,'students'):
                clas.students = []
            if clas.isStudentInClassRoom(student.position):
                  clas.students.append(student)
            return clas

        for student in students :
            classRooms = map((lambda c: verify(student,c)),classRooms)

        #filter classRoom that has at least two students
        classRooms = filter((lambda c: len(c.students) >= 2), classRooms)
        return classRooms


    def printClousterStudents(self,classRooms):
        for classRoom in classRooms:
            print "ClassRoom Name:" + classRoom.name + " has the following students /n" 
            for student in classRoom.students:
                print student.name 


    def exampleSimulationOne(self) :
        engineering_classroom = ClassRoom("Principles",34.069140,-118.442689)
        geology_classroom = ClassRoom("Sedimentary Petrology",34.069585,-118.441878)
        psychology_classroom = ClassRoom("Introductory Psychobiology",34.069742,118.441312)
        music_classroom = ClassRoom("Art of Listening",34.070223,-118.440193)
        humanities_classroom = ClassRoom("Art Hitory",34.071528,-118.441211)

        classRooms = []
        classRooms.append(humanities_classroom)
        classRooms.append(geology_classroom)
        classRooms.append(engineering_classroom)
        classRooms.append(music_classroom)
        classRooms.append(psychology_classroom)

        john_student = Student("John Wilson", 34.069149, -118.442639)
        jane_student = Student("Jane Graham", 34.069601, -118.441862)
        pam_student = Student( "Pame Bam", 34.071513, -118.441181)
        pom_student = Student( "Bam Bam", 34.071501, -118.441170)


        students = []
        students.append(john_student)
        students.append(jane_student)
        students.append(pam_student)
        students.append(pom_student)

        self.printClousterStudents(self.studentClustersInClasses(students, classRooms))
#        print (self.studentsInClasses(students,classRooms))



