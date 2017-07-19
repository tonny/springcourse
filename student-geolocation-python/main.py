#!/usr/bin/python

from student_geolocation.geolocation_simulation import GeolocationSimulation

"""
Program to find if a group of student are inside a course in base his
geolocation. But only courses where there are at least two students
inside a course are printed.
"""
__version__ = '0.1'
__author__ = 'Antonio Mamani'

if __name__ == '__main__':
    geolocation_simulation = GeolocationSimulation()
    geolocation_simulation.example_simulation_one()
