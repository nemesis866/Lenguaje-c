#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Sep  5 17:47:38 2017

@author: Paulo Andrade
"""

import numpy as np
import sympy as sp
import cmath as cm

class NewtonRapson:
    def __init__(self, inicial, ecuacion, err=0.001, treeView=None):
        """
        Constructor de la clase
        """
        
        self.inicial = inicial # valor inicial
        self.err = sp.sympify(sp.Float(err)) # margen de error
        self.ec = str(ecuacion).lower() # ecuacion
        self.root = 0 # raices racionales
        self.real = [] # raices reales
        self.complex = [] # raices complejas
        self.tree = treeView # Arbol de resultados
    
    def roots(self):
        """
        x**3 + 2*x**2 + 10*x - 20
        Obtenemos el total de raices de la ecuacion
        """
        
        # Verificamos el grado del polinomio
        x = sp.Symbol("x") # Declaramos x como simbolo
        res = sp.solve(sp.sympify(self.ec), x) # obtenemos las raices

        for i in res:
            total = i.count("I")
            temp = cm.polar(sp.sympify(i)) # Obtenemos raiz en forma polar
            
            # Comprobamos si es compleja
            if total == 0 :
                self.root += 1
                self.real.append(sp.sympify(i)) # Sumamos las raices reales
            else :
                self.complex.append(cm.rect(sp.sympify(temp[0]), sp.sympify(temp[1])))
                
    def f(self, n):
        """
        f(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(self.ec) # Convertimos en cadena
        ec = sp.sympify(self.ec) # Convertimos a expresión
        return ec.subs(x, n) #resolvemos
    
    def fdx(self, n):
        """
        f'(x) a resolver
        """
        
        x = sp.Symbol("x") # convertimos de variable a simbolo
        ec = str(self.ec) # Convertimos en cadena
        ec = sp.sympify(self.ec) # Convertimos a expresión
        dx = sp.diff(ec, x) # Obtenemos la derivada
        return dx.subs(x, n) #resolvemos
    
    def g(self, xi):
        """
        Calculamos el valor siguiente
        Xi + 1 = g(x)
        """
        
        return xi - (self.f(xi) / self.fdx(xi))
    
    def vertex(self):
        """
        Obtenemos el vertice de una ecuacion cuadratica
        """
        
        # comprobamos si es una funcion cuadratica
        if self.root == 2 :
            x = self.real / 2
        
            # devolvemos el vertice
            return [x, self.f(x)]
        else :
            return None
        
    def estimate(self, count):
        """
        Realizamos los calculos de la raiz imaginaria
        """
        
        xi = self.inicial # Obtenemos valor inicial
        fxi = self.f(xi) # f(xi)
        fdxi = self.fdx(xi) # f'(xi)
        
        com = xi - ((fxi*(cm.sqrt(-1))) / (fdxi*(cm.sqrt(-1))))
        tempInicial = cm.polar(sp.sympify(xi))
        tempInicial = cm.rect(sp.sympify(tempInicial[0]), sp.sympify(tempInicial[1]))
        tempFxi = cm.polar(sp.sympify(fxi))
        tempFxi = cm.rect(sp.sympify(tempFxi[0]), sp.sympify(tempFxi[1]))
        tempFdxi = cm.polar(sp.sympify(fdxi))
        tempFdxi = cm.rect(sp.sympify(tempFdxi[0]), sp.sympify(tempFdxi[1]))
        tempCom = cm.polar(sp.sympify(com))
        tempCom = cm.rect(sp.sympify(tempCom[0]), sp.sympify(tempCom[1]))
        e = abs(tempInicial - tempCom)
        
        # Colocamos un separador si el contador es uno
        if count == 1:
            item = self.tree.insert("", 0, text="--", values=("------",
                "------", "------", "------"))
        
        # Mostramos la informacion
        item = self.tree.insert("" , (count - 1), text=str(count), values=(
                str(tempInicial), str(tempFxi), str(tempFdxi), str(tempCom)
            ))
        
        # Verificamos la raiz con el error estimado
        count += 1 # Aumentamos el contador
        self.tree.selection_set(item) # Seleccionamos la ultima fila
        
        # verificamos el error
        if e > self.err :
            self.inicial = tempCom # Cambiamos el valor inicial
            return self.estimate(count)
        else: return com