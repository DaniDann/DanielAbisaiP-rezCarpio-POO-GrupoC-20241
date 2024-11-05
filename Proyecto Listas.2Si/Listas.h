#ifndef LISTAS_H
#define LISTAS_H

typedef struct Nodo {
    int valor;
    struct Nodo* sig;
    struct Nodo* ante;
} Nodo;


void imprimir();               
void imprimirCircular();

void insertarInicioCirculares(int x);
void insertarFinalCirculares(int x);
void insertarEnOrdenCirculares(int x);
void eliminarEspecificoCirculares(int x);
void eliminarGeneralCirculares();

Nodo* obtenerUltimoDobles();    
void insertarAlInicioDobles(int x);
void insertarAlFinalDobles(int x);
void insertarOrdenadoDobles(int x);
void eliminarElementoDobles(int x);
void eliminarGeneralDobles();

void insertarInicioSimples(int x);
void insertarAlFinalSimples(int x);
void insertarOrdenadaSimples(int x);
void eliminarEspecificoSimples(int x);
void eliminarGeneralSimples();

#endif

