#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Listas.h"

void menuListasSimples() {
    int opcion, valor;
    do {
        printf("\nLista Simplemente Enlazada.");
        printf("\n1. Insertar al inicio");
        printf("\n2. Insertar al final");
        printf("\n3. Insertar en orden");
        printf("\n4. Eliminar valor especifico");
        printf("\n5. Eliminar ultimo valor");
        printf("\n6. Imprimir lista.");
        printf("\n7. Volver al menu principal");
        printf("\nSeleccione una opcion: ");
        scanf("%d", &opcion);

        if (opcion >= 1 && opcion <= 6) {
            printf("Ingrese un valor: ");
            scanf("%d", &valor);
        }

        switch(opcion) {
            case 1:
                insertarInicioSimples(valor);
                break;
            case 2:
                insertarAlFinalSimples(valor);
                break;
            case 3:
                insertarOrdenadaSimples(valor);
                break;
            case 4:
                eliminarEspecificoSimples(valor);
                break;
            case 5:
                eliminarGeneralSimples();
                break;
            case 6:
                imprimir();
                break;
            case 7:
                printf("\nRegresando al menu principal.");
                break;
            default:
                printf("\n Ingrese un numero valido, por favor.");
        }
    } while(opcion != 7);
}

void menuListasDobles() {
    int opcion, valor;
    do {
        printf("\nLista Doblemente Enlazada");
        printf("\n1. Insertar al inicio");
        printf("\n2. Insertar al final");
        printf("\n3. Insertar en orden");
        printf("\n4. Eliminar valor especifico");
        printf("\n5. Eliminar ultimo valor");
        printf("\n6. Imprimir lista.");
        printf("\n7. Volver al menu principal");
        printf("\nSeleccione una opcion: ");
        scanf("%d", &opcion);

        if (opcion >= 1 && opcion <= 6) {
            printf("\nIngrese un valor: ");
            scanf("%d", &valor);
        }

        switch(opcion) {
            case 1:
                insertarAlInicioDobles(valor);
                break;
            case 2:
                insertarAlFinalDobles(valor);
                break;
            case 3:
                insertarOrdenadoDobles(valor);
                break;
            case 4:
                eliminarElementoDobles(valor);
                break;
            case 5:
                eliminarGeneralDobles();
                break;
            case 6:
                imprimir();
                break;
            case 7:
                printf("\nRegresando al menu principal.");
                break;
            default:
                printf("\nIngrese una opcion valida, por favor.");
        }
    } while(opcion != 7);
}

void menuListasDoblesCirculares() {
    int opcion, valor;
    do {
        printf("\nLista Doblemente Enlazada Circular");
        printf("\n1. Insertar al inicio");
        printf("\n2. Insertar al final");
        printf("\n3. Insertar en orden");
        printf("\n4. Eliminar valor especifico");
        printf("\n5. Eliminar ultimo valor");
        printf("\n6. Imprimir lista.");
        printf("\n7. Volver al menu principal");
        printf("\nSeleccione una opcion: ");
        scanf("%d", &opcion);

        if (opcion >= 1 && opcion <= 6) {
            printf("\nIngrese un valor: ");
            scanf("%d", &valor);
        }

        switch(opcion) {
            case 1:
                insertarInicioCirculares(valor);
                break;
            case 2:
                insertarFinalCirculares(valor);
                break;
            case 3:
                insertarEnOrdenCirculares(valor);
                break;
            case 4:
                eliminarEspecificoCirculares(valor);
                break;
            case 5:
                eliminarGeneralCirculares();
                break;
            case 6:
                imprimir();
                break;
            case 7:
                printf("\nRegresando al menu principal.");
                break;
            default:
                printf("\nIngrese una opcion valida, por favor.");
        }
    } while(opcion != 7);
}

int main() {
    int opcion;

    do {
        printf("\n¡Bienvenido al sistema de listas!");
        printf("\nMenu Principal.");
        printf("\n1. Listas Simplemente Enlazadas");
        printf("\n2. Listas Doblemente Enlazadas");
        printf("\n3. Listas Doblemente Enlazadas Circulares");
        printf("\n4. Salir");
        printf("\nSeleccione una opcion: ");
        scanf("%d", &opcion);

        switch(opcion) {
            case 1:
                menuListasSimples();
                break;
            case 2:
                menuListasDobles();
                break;
            case 3:
                menuListasDoblesCirculares();
                break;
            case 4:
                printf("\n ¡Hasta la proxima!");
                break;
            default:
                printf("\nIngrese una opcion valida, por favor.");
        }
    } while(opcion != 4);

    return 0;
}
