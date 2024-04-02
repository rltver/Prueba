package bote;

public class Main {

    public static void main(String[] args) {
        
        operacionPintar();
    }

    private static void operacionPintar() {
        BotePintura titanlux; /// la instancia de la clase BotePintura es la variable titan
        
        int centilitros = 300;
        int centimos = 200;
        int metros = 2;
        
        titanlux = new BotePintura(300,10,2,500, "verde");
        
        /*
        Vamos a pintar 2 metros, como hay sufuiciente pintura la operación tendrá éxito y se
        descontarán 20 centilitros del contenido del bote quedan 280 centilitros
        */
        try {
            System.out.println("Vamos a pintar de color " + titanlux.getColor());
            titanlux.pintar(metros);
            System.out.println("En el bote quedan "+titanlux.getContenido()+" centilitros");
        } catch (Exception e) {
            System.out.println("Error al pintar");
        }
        
        
        /*
        Vamos a intentar rellenar con 300 centilitros al bote, como se supera la capacidad saltará
        una excepción y no se modificará el contenido del depósito que seguirá siendo 280 centilitros
        */
        try {
            System.out.println("Vamos a rellenar el bote con " + centilitros + " centilitros");
            operacionRellenar(titanlux, centilitros, centimos);
            System.out.println("Recarga realizada, ahora tiene "+titanlux.getContenido()+" centilitros en el bote");
        } catch (Exception e) {
            System.out.println("Error al rellenar el bote, el contenido sigue siendo: "+titanlux.getContenido() + " centilitros");
            
        }
    }

    private static void operacionRellenar(BotePintura titanlux, int centilitros, int centimos) throws Exception {
        titanlux.rellenar(centilitros, centimos, "verde");
    }
    
}
