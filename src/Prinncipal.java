import java.io.IOException;
import java.util.Scanner;

public class Prinncipal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("Dijite el numero de la pelicula que desea consultar: ");

        try {
            var numeroPelicula = Integer.valueOf(teclado.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(numeroPelicula);
            System.out.println(pelicula);
            GeneradorArchivo generador = new GeneradorArchivo();
            generador.guardarJson(pelicula);
        } catch (NumberFormatException e) {
            System.out.println("Numero no encontrado" + e.getMessage());;
        } catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion");
        }
    }
}
