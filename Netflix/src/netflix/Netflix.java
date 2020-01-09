/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;

import java.io.*;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Belle
 */
public class Netflix {

    /**
     * @param args the command line arguments
     */
    /*
 * I have considered the ratings from -1 to 5
 * where -1 means the user has not seen the movie at all
 * and 0 means the user has watched it but didn't like the movie at all
 * I have ignored the possibility that the user has not seen any movie as was asked by instructor
     */
    public static double[][] loadRatings(String filename) {
        double[][] ret = new double[30][20];

        try {
            Scanner sc = new Scanner(new File(filename));
            String line = null;
            Scanner lineSc = null;
            int i = 0;
            while (sc.hasNextLine() && i < ret.length) {
                line = sc.nextLine();
                lineSc = new Scanner(line);
                for (int j = 0; j < ret[i].length && lineSc.hasNextDouble(); j++) {
                    ret[i][j] = lineSc.nextDouble();
                }
                i++;
            }

            sc.close();
        } catch (IOException e) {
            System.out.println("Error opening " + filename
                    + " for reading.  Quitting ...");
            System.exit(1);
        }
        return ret;
    }

    public static String[] loadMovieNames(String filename) {
        String[] ret = new String[20];

        try {
            Scanner sc = new Scanner(new File(filename));
            String line = null;
            int i = 0;
            while (sc.hasNextLine() && i < ret.length) {
                ret[i] = sc.nextLine();
                i++;
            }

            sc.close();
        } catch (IOException e) {
            System.out.println("Error opening " + filename
                    + " for reading.  Quitting ...");
            System.exit(1);
        }
        return ret;
    }

    public static void score(double r[]) {
        double assigned[][] = new double[30][20];
        double cosim;
        double usertotal = 0;
        for (int i = 0; i < 20; i++) {
            usertotal += r[i] * r[i];
        }
        double curuser = Math.sqrt(usertotal);
        String movieArray[] = loadMovieNames("movies.txt");

        double ratinga[][] = loadRatings("ratings.txt");
        double assignedutot = 0;
        double assignedu[] = new double[30];
        double similarity[] = new double[30];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 20; j++) {
                if (ratinga[i][j] != -1) {
                    assignedutot += ratinga[i][j] * ratinga[i][j];
                }
            }
            assignedu[i] = Math.sqrt(assignedutot);
            //System.out.println(i+"="+assignedu[i]);
            assignedutot = 0;
        }
        double both = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 20; j++) {
                if (r[j] != -1 && ratinga[i][j] != -1) {
                    both += r[j] * ratinga[i][j];
                }
            }
            similarity[i] = both / (curuser * assignedu[i]);
            //System.out.println("Similarity"+(i+1)+"="+similarity[i]);
            both = 0;
        }
        double[] avg = new double[20];
        double[] favg = new double[20];
        double[] wavg = new double[20];
        double count = 0;
        double similaritytot = 0;
        //System.out.println("in similarity:" + Arrays.toString(similarity));
        for (int i = 0; i < 30; i++) {
            similaritytot += similarity[i];
        }
        //System.out.println(similaritytot);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 30; j++) {
                if (ratinga[j][i] != -1) {
                    avg[i] += ratinga[j][i] * similarity[j];
                } else {
                    avg[i] += 0;
                    count++;
                }
            }
            favg[i] = avg[i] / similaritytot;
            //System.out.println(favg[i]);
            avg[i] = 0;
            count = 0;
        }
        int max = 0;
        for (int i = 0; i < 20; i++) {
            if (r[i] == -1) {
                if (favg[i] > favg[max]) {
                    max = i;
                }
            }

        }
        //System.out.println("Max="+(max));
        if (max == 0) {
            System.out.println("My God, you watch a lot of movies. You should recommend me a movie instead");
        } else {
            System.out.println("Recommended Movie for you is " + movieArray[max]);
        }

    }

    public static void main(String[] args) {
        String movieArray[] = loadMovieNames("movies.txt");
        Scanner ratin = new Scanner(System.in);
        System.out.println("Please rate all the movies from -1 to 5");
        System.out.println(" -1 means you haven't watched the movie and 0 means you have watched the movie but did like it at all");
        double r[] = new double[20];
        for (int k = 0; k < 20; k++) {
            System.out.print(movieArray[k] + "=");
            r[k] = ratin.nextDouble();
            double ratings[] = new double[20];
            if (r[k] < -1 || r[k] > 5) {
                System.out.println("Rating invalid");
                break;
            }        //score();
            double ratinga[][] = loadRatings("ratings.txt");
//        for (int i=0; i<30; i++){
//           for (int j=0; j<20; j++){
//           //System.out.print(ratinga[i][j]);
//            }
//                //System.out.println();
//            }               
        }
        score(r);
    }
}
// TODO code application logic here

