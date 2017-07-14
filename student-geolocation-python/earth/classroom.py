import math

from geolocation import Geolocation

class ClassRoom:
    """Represent a ClassRoom with name, latitude, and longitude as parameters"""
    def __init__(self, name, latitude, longitude):
        self.name = name
        self.geolocation = Geolocation(latitude,longitude)
        self.squarePoints = []
        self.dimention = 20
        self.fillSquerePoints()

    @property
    def name(self):
        return self.name

    @property
    def dimention(self):
        return self.dimention

    @property
    def geolocation(self):
        return self.geolocation

    def fillSquerePoints(self):
        '''
        Function to calculate the geolocation points (North-East, South-East, South-West,
        North-West) in base a geolocation point in the earth where is create a classroom
        with dimension NxN.
        Then the classroom know their points in the earth wich represent a square.
        '''
        meters = self.dimention/2
		# 1 degree in google map is equal to 111.32 Kilometer. 1Degree = 111.32KM. 
		# 1KM in Degree = 1 / 111.32 = 0.008983. 1M in Degree = 0.000008983
		# 0.0000089 ~= coefficient of variation
        coef = meters * 0.0000089
        divLat = math.cos(self.geolocation.latitude * 0.018); # pi/180 ~= 0.018
        ne = Geolocation(self.geolocation.latitude + coef, self.geolocation.longitude + coef/divLat)
        se = Geolocation(self.geolocation.latitude - coef, self.geolocation.longitude + coef/divLat)
        sw = Geolocation(self.geolocation.latitude - coef, self.geolocation.longitude - coef/divLat)
        nw = Geolocation(self.geolocation.latitude + coef, self.geolocation.longitude - coef/divLat)
        self.squarePoints.append(ne)
        self.squarePoints.append(se)
        self.squarePoints.append(sw)
        self.squarePoints.append(nw)

    def isStudentInClassRoom(self,geo):
        """
        Function to verify if a geolocation point is inside of any polygon,
        This algorithm is bases point in polygon (PIP) used in computer graphics
        @see https://en.wikipedia.org/wiki/Point_in_polygon
        @see https://wrf.ecse.rpi.edu//Research/Short_Notes/pnpoly.html

        @param geo: is a object that has a latitude and longitude
        @type geo: Golocation
        @rtype: boolean
        @return: if the student is inside a course in base his geolocation
        """
    	inside = False
        x = geo.latitude
        y = geo.longitude
        size = len(self.squarePoints)
        i = 0
        j = size -1
        while i < size :
            xi = self.squarePoints[i].latitude
            yi = self.squarePoints[i].longitude
            xj = self.squarePoints[j].latitude
            yj = self.squarePoints[j].longitude
            intersect = ((yi > y) != (yj > y)) and (x < (xj - xi) * (y - yi) / (yj - yi) + xi)
            if intersect :
                inside = True
            i += 1
            j = i

        return inside
