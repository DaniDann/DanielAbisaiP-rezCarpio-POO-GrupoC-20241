class Cliente:
  
  def __init__(self, nombre):
    self.nombre = nombre
    self.compras = []

  def comprar(self, producto):
    self.compras.append(producto)
    producto.eliminar_stock()

  def get_nombre(self):
    return self.nombre

  def set_nombre(self, nombre):
    self.nombre = nombre

  def get_compras(self):
    return self.compras

  def set_compras(self, compras):
    self.compras = compras