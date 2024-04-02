package bote;

public class BotePintura implements NewInterface {

    /**
     * @return the centilitros_metro
     */
    public int getCentilitros_metro() {
        return centilitros_metro;
    }

    /**
     * @param centilitros_metro the centilitros_metro to set
     */
    public void setCentilitros_metro(int centilitros_metro) {
        this.centilitros_metro = centilitros_metro;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    private int contenido;//Centilitros de pintura disponibles en el bote
    private int centilitros_metro;//Centrilitros necesarios para pintar un metro cuadrado
    private String color;//color de la pintura
    private int precio;//Precio en céntimos del centilitro de pintura
    private int capacidad;//Número máximo de centilitros que caben en el bote

    /*Constructor por defecto*/
    public BotePintura() {
    }

    /*Constructor por parámetros*/
    public BotePintura(int contenido, int centilitros_metro, int precio, int capacidad, String color) {
        this.contenido = contenido;
        this.centilitros_metro = centilitros_metro;
        this.precio = precio;
        this.capacidad = capacidad;
        this.color = color;
        
    }

    /*
      Método que devuelve el contenido en centilitros del bote
     */
    public int getContenido() {
        return contenido;
    }

    /*
         Método que modifica los centilitros que contiene el bote de pintura.
     */
    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    /*
        Método que permite pintar una superficie, es necesario que haya
        suficiente pintura en el bote y que la superficie que se va a pintar sea
        positiva
     */
    @Override
    public void pintar(int metros) throws Exception {
        if (metros * this.getCentilitros_metro() > this.getContenido()) {
            throw new Exception("No hay pintura suficiente para pintar esa superficie");
        }
        if (metros <= 0) {
            throw new Exception("No tiene sentido pintar una superficie que no sea positiva");
        }
        this.setContenido(this.getContenido() - (metros * this.getCentilitros_metro()));
    }

    /*
         Método que permite aumentar el contenido del bote de pintura, es
         necesario que la cantidad que se quiere añadir y el dinero con que se va
         a pagar sean positvos, además el dinero debe ser suficiente para pagar la
         cantidad que se va a añadir
    */
    @Override
    public void rellenar(int centilitros, int centimos, String color) throws Exception {
        
        
        /// se comprueba el dinero que se dispone
        if (centimos <= 0) {
            throw new Exception("Se necesita una cantidad positiva de dinero");
        }
        
        /// se comprueba que la cantidad a rellenar sea positiva
        if (centilitros <= 0) {
            throw new Exception("Los centilitros deben ser positivos");
        }

        /// se evita que se sobrepase la capacidad
        if (this.getContenido() + centilitros > getCapacidad()) {
            throw new Exception("No se puede superar la capacidad del bote");
        }
        
        /// se controla que se tenga dinero suficiente para pagar
        if (centimos < centilitros * getPrecio()) {
            throw new Exception("No tiene dinero suficiente");
        }
        this.setContenido(this.getContenido() + centilitros);
        
    }

}
