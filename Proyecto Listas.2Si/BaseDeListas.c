#include <stdio.h>
#include <stdlib.h>
#include "Listas.h"

Nodo* raiz = NULL;        
Nodo* cabeza = NULL;     
Nodo* cola = NULL;   

Nodo* obtenerUltimoDobles() {
    Nodo* ultimo = raiz;
    if (ultimo == NULL) {
        return NULL;
    }
    while (ultimo->sig != NULL) {
        ultimo = ultimo->sig;
    }
    return ultimo;
}

void imprimir() {
    if (raiz == NULL) {
        printf("Lista vacía.\n");
        return;
    }
    Nodo* nodito = raiz;
    int esCircular = 0;
    if (raiz->ante && raiz->ante->sig == raiz) {
        esCircular = 1;
    }
    do {
        printf(" %d ", nodito->valor);
        nodito = nodito->sig;
    } while (nodito != NULL && (esCircular ? nodito != raiz : 1));
    printf("\n");
}

void insertarInicioCirculares(int x) {
    Nodo* aux = (Nodo*)malloc(sizeof(Nodo));
    if (!aux) {
        printf("Error al asignar memoria.\n");
        return;
    }
    aux->valor = x;

    if (raiz == NULL) {
        aux->sig = aux;
        aux->ante = aux;
        raiz = aux;
    } else {
        Nodo* ultimo = raiz->ante;
        aux->sig = raiz;
        aux->ante = ultimo;
        raiz->ante = aux;
        ultimo->sig = aux;
        raiz = aux;
    }
    imprimir();
}

void insertarFinalCirculares(int x) {
    Nodo* aux = (Nodo*)malloc(sizeof(Nodo));
    if (!aux) {
        printf("Error al asignar memoria.\n");
        return;
    }
    aux->valor = x;

    if (raiz == NULL) {
        aux->sig = aux;
        aux->ante = aux;
        raiz = aux;
    } else {
        Nodo* ultimo = raiz->ante;
        aux->sig = raiz;
        aux->ante = ultimo;
        ultimo->sig = aux;
        raiz->ante = aux;
    }
    imprimir();
}

void insertarEnOrdenCirculares(int x) {
    Nodo* aux = (Nodo*)malloc(sizeof(Nodo));
    if (!aux) {
        printf("Error al asignar memoria.\n");
        return;
    }
    aux->valor = x;

    if (raiz == NULL) {
        aux->sig = aux;
        aux->ante = aux;
        raiz = aux;
    } else if (raiz->valor >= x) {
        insertarInicioCirculares(x);
        return;
    } else {
        Nodo* temp = raiz;
        while (temp->sig != raiz && temp->sig->valor < x) {
            temp = temp->sig;
        }
        aux->sig = temp->sig;
        aux->ante = temp;
        temp->sig->ante = aux;
        temp->sig = aux;
    }
    imprimir();
}

void eliminarEspecificoCirculares(int x) {
    if (raiz == NULL) {
        printf("Lista vacía\n");
        return;
    }
    Nodo* aux = raiz;
    do {
        if (aux->valor == x) {
            if (aux == raiz && aux->sig == raiz) {
                raiz = NULL;
            } else {
                Nodo* ant = aux->ante;
                Nodo* sig = aux->sig;
                ant->sig = sig;
                sig->ante = ant;
                if (aux == raiz) {
                    raiz = sig;
                }
            }
            free(aux);
            imprimir();
            return;
        }
        aux = aux->sig;
    } while (aux != raiz);
    printf("Nodo no existe\n");
}

void eliminarGeneralCirculares() {
    if (raiz == NULL) {
        printf("Lista vacía\n");
        return;
    }
    Nodo* aux = raiz;
    if (aux->sig == raiz) {
        raiz = NULL;
    } else {
        Nodo* ultimo = raiz->ante;
        raiz = raiz->sig;
        raiz->ante = ultimo;
        ultimo->sig = raiz;
    }
    free(aux);
    imprimir();
}

void insertarAlInicioDobles(int x) {
    Nodo* aux = (Nodo*)malloc(sizeof(Nodo));
    if (!aux) {
        printf("Error al asignar memoria.\n");
        return;
    }
    aux->valor = x;
    aux->sig = raiz;
    aux->ante = NULL;

    if (raiz != NULL) {
        raiz->ante = aux;
    }
    raiz = aux;
    imprimir();
}

void insertarAlFinalDobles(int x) {
    Nodo* aux = (Nodo*)malloc(sizeof(Nodo));
    if (!aux) {
        printf("Error al asignar memoria.\n");
        return;
    }
    aux->valor = x;
    aux->sig = NULL;

    Nodo* ultimo = obtenerUltimoDobles();
    if (ultimo == NULL) {
        raiz = aux;
        aux->ante = NULL;
    } else {
        ultimo->sig = aux;
        aux->ante = ultimo;
    }
    imprimir();
}

void insertarOrdenadoDobles(int x) {
    Nodo* aux = (Nodo*)malloc(sizeof(Nodo));
    aux->valor = x;

    if (raiz == NULL || x < raiz->valor) {
        aux->sig = raiz;
        aux->ante = NULL;
        if (raiz) raiz->ante = aux;
        raiz = aux;
    } else {
        Nodo* aux2 = raiz;
        while (aux2->sig != NULL && aux2->sig->valor < x) {
            aux2 = aux2->sig;
        }
        aux->sig = aux2->sig;
        aux->ante = aux2;
        if (aux2->sig) aux2->sig->ante = aux;
        aux2->sig = aux;
    }
    imprimir();
}

void eliminarElementoDobles(int x) {
    Nodo* aux = raiz;

    if (raiz != NULL && raiz->valor == x) {
        raiz = raiz->sig;
        if (raiz) raiz->ante = NULL;
        free(aux);
    } else {
        while (aux != NULL && aux->valor != x) {
            aux = aux->sig;
        }
        if (aux == NULL) {
            printf("El elemento no existe en la lista\n");
            return;
        } else {
            if (aux->sig) aux->sig->ante = aux->ante;
            if (aux->ante) aux->ante->sig = aux->sig;
            free(aux);
        }
    }
    imprimir();
}

void eliminarGeneralDobles() {
    Nodo* aux = raiz;

    if (raiz == NULL) {
        printf("Lista vac�a.");
    } else {
        raiz = raiz->sig;
        free(aux);
        printf("Elemento eliminado de la lista.");
    }
    imprimir();
}

void insertarInicioSimples(int x) {
    Nodo* aux = (Nodo*)malloc(sizeof(Nodo));
    aux->valor = x;

    if (raiz == NULL) {
        aux->sig = NULL;
        raiz = aux;
        printf(" Valor agregado como raiz: %d\n", x);
    } else {
        aux->sig = raiz;
        raiz = aux;
        printf("Valor agregado: %d\n", x);
    }
    imprimir();
}

void insertarAlFinalSimples(int y) {
    Nodo* aux = (Nodo*)malloc(sizeof(Nodo));
    aux->valor = y;
    aux->sig = NULL;

    if (raiz == NULL) {
        raiz = aux;
        printf(" Valor agregado como raiz: %d\n", y);
    } else {
        Nodo* aux2 = raiz;
        while (aux2->sig != NULL) {
            aux2 = aux2->sig;
        }
        aux2->sig = aux;
    }
    imprimir();
}

void insertarOrdenadaSimples(int x) {
    Nodo* aux = (Nodo*)malloc(sizeof(Nodo));
    aux->valor = x;
    aux->sig = NULL;

    if (raiz == NULL || x < raiz->valor) {
        aux->sig = raiz;
        raiz = aux;
    } else {
        Nodo* aux2 = raiz;
        while (aux2->sig != NULL && aux2->sig->valor < x) {
            aux2 = aux2->sig;
        }
        aux->sig = aux2->sig;
        aux2->sig = aux;
    }
    imprimir();
}

void eliminarEspecificoSimples(int x) {
    Nodo* aux = raiz;
    Nodo* aux2 = aux->sig;

    if (raiz == NULL) {
        printf("Lista vac�a.");
        return;
    }

    if (raiz->valor == x) {
        raiz = raiz->sig;
        free(aux);
        printf("Elemento sacado.");
    } else {
        while (aux->sig != NULL && aux->sig->valor != x) {
            aux = aux->sig;
        }
        if (aux->sig == NULL) {
            printf("No est� el elemento en la lista.");
        } else {
            aux2 = aux->sig;
            aux->sig = aux2->sig;
            free(aux2);
            printf("Se elimin� el elemento.");
        }
    }
    imprimir();
}

void eliminarGeneralSimples() {
    Nodo* aux = raiz;

    if (raiz == NULL) {
        printf("Lista vac�a.");
    } else {
        raiz = raiz->sig;
        free(aux);
        printf("Elemento eliminado de la lista.");
    }
    imprimir();
}
