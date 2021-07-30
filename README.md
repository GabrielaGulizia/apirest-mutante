# Validador de adn mutantes

 La siguiente API Rest, determina si un ADN dado sea de un mutante. Para ello, valida si hay al menos cuatro letras consecutivas en forma horizontal, oblicua o vertical.
 
## Condiciones
El usuario debe ingresar por consola los valores del ADN, separados por coma. El sistema validará:

- La cantidad de carácteres, para que pueda generarse una matriz cuadrada
- Que los carácteres sean los correspondientes, es decir: "A", "C", "G" o "T"
- Que la matriz tenga al menos 5 letras

## Ejecución
Para la correcta ejecución, realizar los siguientes pasos:
- Clonar el repositorio desde:

    `https://github.com/GabrielaGulizia/apirest-mutante.git`



-Para levantar el servicio, ejecutar la siguiente linea de comando:

    `$ mvn spring-boot:run`

## Validar el servicio

- **Guardar un mutante en memoria local** 

**POST** `http://localhost:5000/mutants`

>**Header** `Content-Type: application/json`   
**Body**  `{"dna": "aacgtt,caacta,taatgt,aatcat,cttgca,gttacc"}`


- **Mostrar todos los ADN**

**GET** `http://localhost:5000/mutants`
