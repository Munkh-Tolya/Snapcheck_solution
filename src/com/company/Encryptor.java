package com.company;

public class Encryptor {
    public static String encrypt(String input){

        String noSpace = input.replaceAll("\\s",""); /* Removing blank spaces */
        int length = noSpace.length();

        double sqrt = Math.sqrt(length); /* Calculating lengths of the matrix */
        int floor = (int) Math.floor(sqrt);
        int ceil = (int) Math.ceil(sqrt);

        boolean floorTurn = true;
        while(floor * ceil < length){
            if(floorTurn) {
                floor++;
                floorTurn = false;
            }else{
                ceil++;
                floorTurn = true;
            }
        }

        char[][] matrix = new char[floor][ceil]; /* Creating and filling the matrix with char */
        for(int i = 0; i < length; i++){
            matrix[i / ceil][i % ceil] = noSpace.charAt(i);
        }

        StringBuilder builder = new StringBuilder(); /* Putting matrix values to string builder */
        for(int i = 0; i < ceil; i++){
            for(int j = 0; j < floor; j++){
                builder.append(matrix[j][i]);
            }
            builder.append(" ");
        }
        builder.deleteCharAt( builder.length() - 1 );
        return builder.toString();
    }
}
