/*
Fecha: 09/05/2017
Nombre: Paulo Cesar Andrade Gonzalez
Nota: Implementacion de dipoles con estructuras dinamicas
    con restricciones IRD (Input - restricted dequeue)
    (colas con doble terminación - double-endend)
*/

#ifndef IRD_HPP_INCLUDED
#define IRD_HPP_INCLUDED

// Clase para crear un dipole
class Ird
{
    // Clase para crear un objeto nodo de la lista
    class Node
    {
        // Contenido de un nodo
        int _data; // Datos del nodo
        Node *_next; // Apuntador al siguiente nodo
        Node *_prev; // Apuntador al nodo anterior

        public:
            // Constructor
            Node(int); // El apuntador siguiente siempre apunta a NULL

            // Pedimos la informacion del objeto
            // Se utiliza const por que no podemos modificar el objeto
            int data() const; // Nos devuelve el dato almacena
            Node *next() const; // Nos devuelve el siguiente nodo (si no existe retorna NULL)
            Node *prev() const; // Nos devuelve el nodo anterior (si no existe retorna NULL)

            // Metodo que permite modificar el apuntador
            // Asigno y me retorna el nuevo nodo
            Node *next(Node *);
            Node *prev(Node *);
    };

    Node *start; // Nodo Front
    Node *final; // Nodo Rear
    int _n; // Capacidad del dipole
    int _s; // Tamaño del dipole

    public:
        // Constructor
        Ird();
        // Destructor
        ~Ird();

        // Funciones de utileria
        int capacity() const { return _n; } // Obtenemos capacidad
        int size() const { return _s; } // Obtenemos tamaño
        bool empty() { return _s == 0; } // Vacuidad
        bool full() { return _s == _n; } // Plenitud

        // Metodos para dipoles
        bool enqueueRear(int); // Insertamos nodo por detras
        int dequeueFront(); // Obtiene nodo y lo eliminamos por el frente
        int dequeueRear(); // Obtiene nodo y lo elimina por detras
        int front(); // Obtiene el dato por el frente
        int rear(); // Obtiene el dato por detras
        bool search(int); // Busqueda de datos
        void print(); // Imprime el contenido de la cola
};

#endif // DIPOLE_HPP_INCLUDED

