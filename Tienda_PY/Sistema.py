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
class Sistema:
    def __init__(self, password):
        self.password = password
        self.tienda = Tienda()

    def login(self, password_ingresada):
        if self.password == password_ingresada:
            return True
        else:
            print("Contraseña incorrecta")
            return False

    def registrar_cliente(self, cliente):
        if self.login(self.password):
            self.tienda.registrar_cliente(cliente)

    def registrar_producto(self, producto):
        if self.login(self.password):
            self.tienda.registrar_producto(producto)

    def eliminar_cliente(self, cliente):
        if self.login(self.password):
            self.tienda.eliminar_cliente(cliente)

    def eliminar_producto(self, producto):
        if self.login(self.password):
            self.tienda.eliminar_producto(producto)

    def numero_clientes(self):
        if self.login(self.password):
            return self.tienda.numero_clientes()
        return -1

    def numero_productos(self):
        if self.login(self.password):
            return self.tienda.numero_productos()
        return -1

    @property
    def password(self):
        return self._password

    @password.setter
    def password(self, value):
        self._password = value

    @property
    def tienda(self):
        return self._tienda

    @tienda.setter
    def tienda(self, value):
        self._tienda = value