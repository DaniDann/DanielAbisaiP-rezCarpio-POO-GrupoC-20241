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

class Tienda:
    def __init__(self):
        self.clientes = []
        self.productos = []

    def registrar_cliente(self, cliente):
        self.clientes.append(cliente)

    def registrar_producto(self, producto):
        self.productos.append(producto)
        Producto.agregar_stock()

    def eliminar_cliente(self, cliente):
        if not cliente.compras:
            self.clientes.remove(cliente)
        else:
            print("El cliente tiene compras asociadas")

    def eliminar_producto(self, producto):
        if Producto.stock > 0:
            self.productos.remove(producto)
            Producto.eliminar_stock()
        else:
            print("El producto no está en stock")

    def numero_clientes(self):
        return len(self.clientes)

    def numero_productos(self):
        return len(self.productos)