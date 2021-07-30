package com.Final;

import org.springframework.stereotype.Service;

@Service
public class MutantService {

    /**
     * @param dnaString
     * @return boolean
     * Cuando el ADN corresponde a un mutante, devuelve verdadero e imprime matriz
     */
    public boolean validateMutantDna(String dnaString) {
        String[] dna = dnaString.split(",");
        if (validateInput(dna)) {
            //imprime matriz generada
            char[][] matrix = createMatrix(dna);
            printMatrix(dna, matrix);

            //valida el dna ingresado
            if (isMutant(dna)) {
                System.out.println("\n\n El ADN corresponde a un MUTANTE \n\n");
                return true;

            } else {
                System.out.println("\n\nEste humano no es mutante\n\n");
                return false;
            }
        }
        System.out.println("\n\nEste humano no es mutante\n\n");
        return false;
    }

    /**
     * @param dna
     * @return boolean
     * Valida que el ADN corresponda a un mutante
     */
    private static boolean isMutant(String[] dna) {
        //verifica secuencia vertical
        boolean vertical = validateVertical(dna);
        if (vertical) {
            return true;
        }
        //verifica secuencia horizontal
        for (int i = 0; dna.length > i; i++) {
            boolean horizontal = validateHorizontal(dna[i]);
            if (horizontal) {
                return true;
            }
        }
        //verifica secuencia oblicuo
        boolean diagonal = validateDiagonal(dna);
        if (diagonal) {
            return true;
        }
        return false;
    }

    /**
     * @param dna
     * @return boolean
     * Valida que un ADN coincida en forma horizontal
     */
    private static boolean validateHorizontal(String dna) {
        int letterCounter = 1;
        char[] dnaChars = dna.toCharArray();

        for (int i = 0; i < dnaChars.length; i++) {
            //compara consecutivas desde la segunda posición
            if (i == 0) {
                continue;
            }
            //resetea contado si la letra de la derecha no es igual a la de la izquierda
            if (dnaChars[i] == dnaChars[i - 1]) {
                letterCounter++;
            } else {
                letterCounter = 1;
            }
            //finaliza como verdadero si hay 4 letras iguales consecutivas
            if (letterCounter == 4) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param dna
     * @return boolean
     * Valida que un ADN coincida en forma vertical
     */
    public static boolean validateVertical(String[] dna) {
        char[][] matrix = createMatrix(dna);
        int letterCounter = 1;

        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                //compara consecutivas desde la segunda posición
                if (j == 0) {
                    continue;
                }
                //resetea contado si la letra de arriba no es igual a la de abajo
                if (matrix[j][i] == matrix[j - 1][i]) {
                    letterCounter++;
                } else letterCounter = 1;
                //finaliza como verdadero si hay 4 letras iguales consecutivas
                if (letterCounter == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param dna
     * @return boolean
     * Valida que un ADN coincida en forma oblicua
     */
    public static boolean validateDiagonal(String[] dna) {
        char[][] matrix = createMatrix(dna);
        int letterCounter = 1;

        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                if (j == 0) continue;
                if (i == 0) continue;
                //compara con la posicion superior izquierda
                if (matrix[i - 1][j - 1] == matrix[i][j]) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                //compara con la posicion superior derecha
                if (matrix[i + 1][j + 1] == matrix[i][j]) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                //finaliza como verdadero si hay 4 letras iguales consecutivas
                if (letterCounter == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param dna
     * @return char[][]
     * Crea una matriz con los datos ingresados
     */
    private static char[][] createMatrix(String[] dna) {
        char[][] matrix = new char[dna.length][dna.length];
        for (int i = 0; i < dna.length; i++) {
            //valida que la matriz sea de al menos 5 caracteres
            if (dna.length < 6) {
                System.out.println("\n\nERROR: EL tamaño de la matriz es menor a 6.\n\n");
                break;
            }
            //valida que la matriz sea cuadrada
            if (dna.length != dna[i].length()) {
                System.out.println("\n\nERROR: EL tamaño de la matriz no es correcto");
                break;
            } else {
                for (int j = 0; j < dna[0].length(); j++) {
                    //completa la matriz con el dna
                    matrix[i][j] = dna[i].toCharArray()[j];
                }
            }
        }
        return matrix;
    }

    /**
     * @param dna
     * @param matrix imprime matriz
     */
    private static void printMatrix(String[] dna, char[][] matrix) {
        System.out.println("\n\n Matriz : ");
        for (int i = 0; i < dna.length; i++) {
            System.out.println("");
            for (int j = 0; j < dna[0].length(); j++) {
                //imprime matriz generada
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    /**
     * @param dna
     * @return boolean
     * validates if the imput only has valid chars
     */
    static boolean validateInput(String[] dna) {
        String validChars = "^[acgt].*";
        for (String s : dna)
            if (s.toLowerCase().matches(validChars)) {
                return true;
            } else {
                System.out.println("\n\nERROR: Ingrese Caracteres válidos.\n\n");
                return false;
            }
        return false;
    }
}



