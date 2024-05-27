from datetime import datetime

class Cliente:
    def __init__(self, nombre):
        self.nombre = nombre

class Electrodomesticos:
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, marca):
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.numero_serie = numero_serie
        self.marca = marca

class Limpieza:
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, es_biodegradable):
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.numero_serie = numero_serie
        self.es_biodegradable = es_biodegradable

class Maquillaje:
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, es_vegano):
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.numero_serie = numero_serie
        self.es_vegano = es_vegano

class Alimento:
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, fecha_caducidad):
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.numero_serie = numero_serie
        self.fecha_caducidad = fecha_caducidad

class Tienda:
    def __init__(self):
        self.clientes = []
        self.productos = []

    def registrar_cliente(self, cliente):
        self.clientes.append(cliente)

    def registrar_producto(self, producto):
        self.productos.append(producto)

    def eliminar_cliente(self, cliente):
        self.clientes.remove(cliente)

    def eliminar_producto(self, producto):
        self.productos.remove(producto)

class Sistema:
    def __init__(self, password):
        self.password = password
        self.tienda = Tienda()

    def login(self, password_ingresada):
        return self.password == password_ingresada

    def numero_clientes(self):
        return len(self.tienda.clientes)

    def numero_productos(self):
        return len(self.tienda.productos)

def main():
    sistema = Sistema("124578")
    print("----- BIENVENIDO A LA TIENDA EL RAYITO -----")

    password_ingresada = input("Por favor, introduce la contraseña para acceder al menú: ")
    if not sistema.login(password_ingresada):
        print("Contraseña incorrecta. Acceso denegado.")
        return

    while True:
        print("1. Registrar cliente")
        print("2. Registrar producto")
        print("3. Eliminar cliente")
        print("4. Eliminar producto")
        print("5. Número de clientes")
        print("6. Número de productos")
        print("7. Ver productos")
        print("8. Salir")
        opcion = input("Elige una opción: ")

        if opcion == "1":
            nombre_cliente = input("Nombre del cliente: ")
            cliente = Cliente(nombre_cliente)
            sistema.tienda.registrar_cliente(cliente)

        elif opcion == "2":
            print("¿Qué tipo de producto quieres registrar?")
            print("1. Electrodoméstico")
            print("2. Producto de limpieza")
            print("3. Producto de belleza")
            print("4. Alimento")
            tipo_producto = input("Elige una opción: ")

            nombre_producto = input("Nombre del producto: ")
            precio_producto = float(input("Precio del producto: "))
            fecha_importacion = datetime.now()
            numero_serie = input("Número de serie del producto: ")

            if tipo_producto == "1":
                marca = input("Marca del electrodoméstico: ")
                electrodomestico = Electrodomesticos(nombre_producto, precio_producto, fecha_importacion, numero_serie, marca)
                sistema.tienda.registrar_producto(electrodomestico)

            elif tipo_producto == "2":
                es_biodegradable = input("¿Es biodegradable el producto de limpieza? (true/false): ").lower() == "true"
                limpieza = Limpieza(nombre_producto, precio_producto, fecha_importacion, numero_serie, es_biodegradable)
                sistema.tienda.registrar_producto(limpieza)

            elif tipo_producto == "3":
                es_vegano = input("¿Es vegano el producto de belleza? (true/false): ").lower() == "true"
                belleza = Maquillaje(nombre_producto, precio_producto, fecha_importacion, numero_serie, es_vegano)
                sistema.tienda.registrar_producto(belleza)

            elif tipo_producto == "4":
                fecha_caducidad = input("Fecha de caducidad del alimento (dd/MM/yyyy): ")
                alimento = Alimento(nombre_producto, precio_producto, fecha_importacion, numero_serie, fecha_caducidad)
                sistema.tienda.registrar_producto(alimento)

            else:
                print("Opción no válida")

        elif opcion == "3":
            nombre_cliente_eliminar = input("Nombre del cliente a eliminar: ")
            cliente_eliminar = next((cliente for cliente in sistema.tienda.clientes if cliente.nombre == nombre_cliente_eliminar), None)
            if cliente_eliminar:
                sistema.tienda.eliminar_cliente(cliente_eliminar)
                print("Cliente eliminado exitosamente.")
            else:
                print("Cliente no encontrado.")

        elif opcion == "4":
            numero_serie_eliminar = input("Número de serie del producto a eliminar: ")
            producto_eliminar = next((producto for producto in sistema.tienda.productos if producto.numero_serie == numero_serie_eliminar), None)
            if producto_eliminar:
                sistema.tienda.eliminar_producto(producto_eliminar)
                print("Producto eliminado exitosamente.")
            else:
                print("Producto no encontrado.")

        elif opcion == "5":
            print("Número de clientes:", sistema.numero_clientes())

        elif opcion == "6":
            print("Número de productos:", sistema.numero_productos())

        elif opcion == "7":
            print("Productos:")
            for producto in sistema.tienda.productos:
                print("Nombre:", producto.nombre, ", Precio:", producto.precio, ", Número de serie:", producto.numero_serie)

        elif opcion == "8":
            print("Saliendo...")
            break

        else:
            print("Opción no válida")

if __name__ == "__main__":
    main()