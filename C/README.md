**Compilacion**

Para generar los archivos server y client
```
rpcgen Calculadora.x -a
```

Una vez editados los archivos procedemos
```
make -f Makefile.Calculadora
```

**Ejecucion**
First Terminal
```
./Calculadora_server
```
Second Terminal
```
./Calculadora_client 127.0.0.1
El resultado de la sumar 3 + 5 = 8
El resultado de restar  10 - 5 = 5
El resultado de  multiplicar 5 * 5 = 25
El resultado de  dividir 10 / 3 = 3.333333
```
