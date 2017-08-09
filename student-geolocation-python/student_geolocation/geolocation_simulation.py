from models.classroom import ClassRoom
from models.student import Student


class GeolocationSimulation:
    """Earth class to find students in course"""

    def students_in_classes(self, students, class_rooms):
        """
        Function to verify if a bunch of students is inside of a list of class
        room.

        @param students : is a students list -> [Student]
        @param class_rooms : is a class rooms list -> [ClassRoom]

        @return: list with all students found inside a course
        @rtype : [Student]
        """
        students_found = []
        for class_room in class_rooms:
            for student in students:
                if class_room.is_student_in_class_room(student.position):
                    students_found.append(student)

        return students_found

    def student_clusters_in_classes(self, students, class_rooms):
        """
        Function to find and return class rooms that has at least two students
        inside.

        @param students : is a students list -> [Student]
        @param class_rooms : is a class rooms list -> [ClassRoom]

        @return: a class room list whit has at least two students
        @rtype : [ClassRoom]
        """
        # Closure function to verify if the student is inside of classRoom
        def verify(student, clas):
            if not hasattr(clas, 'students'):
                clas.students = []
            if clas.is_student_in_class_room(student.position):
                clas.students.append(student)
            return clas

        for student in students:
            class_rooms = map((lambda c: verify(student, c)), class_rooms)

        # filter classRoom that has at least two students
        class_rooms = filter((lambda c: len(c.students) >= 2), class_rooms)
        return class_rooms

    def print_clouster_students(self, class_rooms):
        for class_room in class_rooms:
            print class_room.name + " has the following students:"
            for student in class_room.students:
                print student.name

    def example_simulation_one(self):
        class_rooms = [
            ClassRoom("Principles", 34.069140, -118.442689),
            ClassRoom("Sedimentary Petrology", 34.069585, -118.441878),
            ClassRoom("Introductory Psychobiology", 34.069742, 118.441312),
            ClassRoom("Art of Listening", 34.070223, -118.440193),
            ClassRoom("Art Hitory", 34.071528, -118.441211)
        ]

        students = [
            Student("John Wilson", 34.069149, -118.442639),
            Student("Jane Graham", 34.069601, -118.441862),
            Student("Pame Bam", 34.071513, -118.441181),
            Student("Bam Bam", 34.071501, -118.441170)
        ]

        self.print_clouster_students(
            self.student_clusters_in_classes(students, class_rooms))
