#!/usr/bin/python
"""
Program to find if a group of student are inside a course in base his geolocation.
But only courses where there are at least two students inside a course are printed
"""
__version__ = '0.1'
__author__ = 'Antonio Mamani'

from earth.earth import Earth

if __name__ == '__main__':
    earth  = Earth()
    earth.exampleSimulationOne()
