class Geolocation:
    """Represent a geolocation with latitude and longitude"""
    def __init__(self, latitude, longitude):
        self.latitude = latitude
        self.longitude = longitude

    @property
    def latitude(self):
        return self.latitude

    @property
    def longitude(self):
        return self.longitude

    @latitude.setter
    def latitude(self, latitude):
        self.longitude = latitude

    @longitude.setter
    def longitude(self, longitude):
        self.longitude = longitude
