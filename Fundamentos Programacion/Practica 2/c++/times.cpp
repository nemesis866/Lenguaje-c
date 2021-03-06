/**********************************************
* Programa 3 - Practica 2
* Fecha: 18/04/2016
* Nombre: times
**********************************************/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    int num1 = 0, num2 = 0;
    int unidad, decena, centena, milesima;

    cout << "Ingrese dos numeros enteros entre 0 y 999 (separe con una coma): ";
    cin >> num1 >> num2;

    cout << "\nEl producto de ambos numeros es:\n";

    cout << setw(8) << num1 << "\n";
    cout << "*" << setw(7) << num2 << "\n";
    cout << "--------\n";

    // Obtenemos los multiplicando
    unidad = num2 % 10;
    decena = ((num2 % 100) - unidad) / 10;
    centena = (((num2 % 1000) - (decena * 10) - unidad)) / 100;
    //milesima = (((num2 % 10000) - (centena * 100) - (decena * 10)) - unidad) / 1000;

    // Imprimimos los resultados
    if(unidad != 0 || decena != 0 || centena != 0) cout << setw(8) << unidad * num1 << "\n";
    if(decena != 0 || centena != 0) cout << setw(7) << decena * num1 << "\n";
    if(centena != 0) cout << setw(6) << centena * num1 << "\n";
    //if(milesima != 0) printf("\n%5i   ", milesima * num1);

    // Imprimimos el resultado solo si el multiplicador tiene dos o mas digitos
    if(decena != 0 || centena != 0){
        cout << "--------\n";
        cout << setw(8) << num1 * num2 << "\n";
    }

    return 0;
}
