import java.io.*;

public class FicherosTexto {
    public static void testEscribirFicheroTexto(){
        File fichero = null;
        PrintWriter f = null;

        fichero = new File("prueba.txt");
        System.out.println("Escribiendo en el fichero " + fichero.getAbsolutePath());

        try {
            f = new PrintWriter(new FileWriter(fichero, true));
            for (int i = 0; i < 10; i++){
                f.println("Linea: " + i);
            }
            f.println(fichero.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (f != null){
                f.close();
            }
        }

    }

    public static void testLeerFicheroTexto(){
        File fichero = null;
        BufferedReader bf = null;

        fichero = new File("prueba.txt");
        System.out.println("Leer en el fichero " + fichero.getAbsolutePath());

        try {
            bf = new BufferedReader(new FileReader(fichero));
            String linea;
            while ((linea = bf.readLine()) != null){
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
    }

}
