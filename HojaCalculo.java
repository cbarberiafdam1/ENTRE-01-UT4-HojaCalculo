
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -   
 *  
 */
public class HojaCalculo
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila2 = null;
        this.fila3 = null;
    }

    /**
     * Accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Accesor para la fila1
     */
    public Fila getFila1() {
        return fila1;
    }

    /**
     * Accesor para la fila2
     */
    public Fila getFila2() {
        return fila2;
    }

    /**
     * Accesor para la fila3
     */
    public Fila getFila3() {
        return fila3;
    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {        
        int contador = 0; 
        if(this.fila1 != null){
            contador++;
        }
        if(this.fila2 != null){
            contador++;
        }        
        if(this.fila3 != null){
            contador++;
        }          
        return contador;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if(this.fila1 != null){
            if(this.fila2 != null){
                if(this.fila3 !=null){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(this.hojaCompleta() == true){
            System.out.println(fila.getId() + " no se puede añadir en Hoja " + this.nombre);
        }else{
            if(this.fila1 == null){
                this.fila1 = fila;
            }else if(this.fila2 == null){
                this.fila2 = fila;
            }else if(this.fila3 == null){
                this.fila3 = fila;
            }
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila fila = new Fila(id, fecha, ingresos, gastos);
        this.addFila(fila);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double totalIngresos = 0.0;
        if(this.fila1 != null){
            totalIngresos += this.fila1.getIngresos();
        }
        if(this.fila2 != null){
            totalIngresos += this.fila2.getIngresos();
        }
        if(this.fila3 != null){
            totalIngresos += this.fila3.getIngresos();
        }
        return totalIngresos;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double totalGastos = 0.0;
        if(this.fila1 != null){
            totalGastos += this.fila1.getGastos();
        }
        if(this.fila2 != null){
            totalGastos += this.fila2.getGastos();
        }
        if(this.fila3 != null){
            totalGastos += this.fila3.getGastos();
        }
        return totalGastos;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double totalBeneficio = 0.0;
        if(this.fila1 != null){
            totalBeneficio += this.fila1.getBeneficio();
        } 
        if(this.fila2 != null){
            totalBeneficio += this.fila2.getBeneficio();
        }
        if(this.fila3 != null){
            totalBeneficio += this.fila3.getBeneficio();
        }
        return totalBeneficio;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {         
        String fecha = "FECHA";
        String ingresos = "INGRESOS";
        String gastos = "GASTOS";
        String beneficio = "BENEFICIO";
        String fila1 = "";
        String fila2 = "";
        String fila3 = "";
        if(this.fila1 != null){
            fila1 = this.fila1.toString();
        }
        if(this.fila2 != null){
            fila2 = this.fila2.toString();
        }
        if(this.fila3 != null){
            fila3 = this.fila3.toString();
        }        
        String resultado = String.format("%s\n %22s %16s %16s %16s\n %s\n %s\n %s\n -------------------------------------------------------------------------------\n %37.2f€ %15.2f€ %15.2f€", 
                this.nombre, fecha, ingresos, gastos, beneficio, 
                fila1, fila2, fila3,
                this.getTotalIngresos(),
                this.getTotalGastos(),
                this.getBeneficio());
        return resultado;
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {  
        HojaCalculo hoja = new HojaCalculo("Duplicada " + this.getNombre());
        hoja.fila1 = this.fila1;
        hoja.fila2 = this.fila2;
        hoja.fila3 = this.fila3;
        return hoja;
    }
}
