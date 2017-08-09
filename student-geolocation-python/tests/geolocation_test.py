from nose.tools import assert_equals, assert_true, assert_false
from student_geolocation.geolocation_simulation import GeolocationSimulation
from student_geolocation.models.student import Student
from student_geolocation.models.classroom import ClassRoom


def test_a_classroom_with_two_students():

    geolocation_simulation = GeolocationSimulation()

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

    rooms = geolocation_simulation.student_clusters_in_classes(students,
                                                               class_rooms)

    assert_equals(len(rooms), 1)


def test_there_aren_not_two_students_in_classroom():

    geolocation_simulation = GeolocationSimulation()

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
        Student("Pame Bam", 34.071513, -118.441181)
    ]

    rooms = geolocation_simulation.student_clusters_in_classes(students,
                                                               class_rooms)
    assert_equals(len(rooms), 0)


def test_student_is_not_inside_of_classroom():

    class_room = ClassRoom("Art Hitory", 34.071528, -118.441211)
    student = Student("Jane Graham", 34.069601, -118.441862)

    assert_false(class_room.is_student_in_class_room(student.position))


def test_student_is_inside_of_classroom():

    class_room = ClassRoom("Art Hitory", 34.071528, -118.441211)
    student = Student("Pame Bam", 34.071513, -118.441181)

    assert_true(class_room.is_student_in_class_room(student.position))
