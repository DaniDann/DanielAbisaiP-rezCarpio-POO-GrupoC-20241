from datetime import datetime

class Producto:
    stock = 0

    def __init__(self, nombre, precio, fecha_importacion, numero_serie):
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.numero_serie = numero_serie

    @staticmethod
    def agregar_stock():
        Producto.stock += 1

    @staticmethod
    def eliminar_stock():
        if Producto.stock > 0:
            Producto.stock -= 1
        else:
            print("No hay stock disponible")

    @property
    def nombre(self):
        return self._nombre

    @nombre.setter
    def nombre(self, value):
        self._nombre = value

    @property
    def precio(self):
        return self._precio

    @precio.setter
    def precio(self, value):
        self._precio = value

    @property
    def fecha_importacion(self):
        return self._fecha_importacion

    @fecha_importacion.setter
    def fecha_importacion(self, value):
        self._fecha_importacion = value

    @property
    def numero_serie(self):
        return self._numero_serie

    @numero_serie.setter
    def numero_serie(self, value):
        self._numero_serie = value

    @classmethod
    def get_stock(cls):
        return cls.stock

    @classmethod
    def set_stock(cls, stock):
        cls.stock = stock
class Alimento(Producto):
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, fecha_caducidad):
        super().__init__(nombre, precio, fecha_importacion, numero_serie)
        self.fecha_caducidad = fecha_caducidad

    @property
    def fecha_caducidad(self):
        return self._fecha_caducidad

    @fecha_caducidad.setter
    def fecha_caducidad(self, value):
        self._fecha_caducidad = value
