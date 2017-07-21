from geolocation import Geolocation


class Student:
    """Represent a Student property"""
    def __init__(self, name, latitude, longitude):
        self.name = name
        self.position = Geolocation(latitude, longitude)

    @property
    def name(self):
        return self.name

    @property
    def position(self):
        return self.position
