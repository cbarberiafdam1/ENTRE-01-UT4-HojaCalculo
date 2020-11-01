/**
 *  Representa a una fila de la hoja de cálculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author -  Carla Barberia Flamarique
 *  
 */
public class Fila
{
    private String id;
    private Fecha fecha;
    private double ingresos;
    private double gastos;

    /**
     * Constructor  
     */
    public Fila(String id)    {
        this.ingresos = 0.0;
        this.gastos = 0.0;
        this.fecha = new Fecha(1,1,2020);
        this.id = id;
    }

    /**
     * Constructor  
     */
    public Fila(String id, Fecha fecha, double ingresos, double gastos)    {
        this.id = id;
        this.fecha = fecha;
        this.ingresos = ingresos;
        this.gastos = gastos;
    }

    /**
     * Accesor para el id de la fila
     */
    public String getId() {
        if(this != null)
            return this.id;
        else
            return "";
    }

    /**
     * Accesor para la fecha
     */
    public Fecha getFecha() {
        if(this != null)
            return this.fecha;
        else
            return null;
    }

    /**
     * Accesor para los ingresos
     */
    public double getIngresos() {
        if(this != null)
            return this.ingresos;
        else
            return 0.0;
    }

    /**
     * Accesor para los gastos
     */
    public double getGastos() {
        if(this != null)
            return this.gastos;
        else
            return 0.0;
    }

    /**
     * Calcula y devuelve el beneficio
     */
    public double getBeneficio() {
        if(this.ingresos != 0 && this.gastos != 0)
            return this.ingresos - this.gastos;
        else
            return 0.0;
    }

    /**
     * Obtiene una copia idéntica a la fila actual.
     * La fecha que incluye la fila duplicada también es una copia
     * 
     */
    public Fila duplicar() {
        return new Fila(this.id, this.fecha, this.gastos, this.ingresos);
    }

    /**
     * Representación textual de una fila
     * (leer enunciado)
     */
    public String toString() {
        String resultado = "";
        if(this.equals(null)){
            return resultado;
        }else{
            if(this.getBeneficio() >= 0){
                resultado = String.format("%s %8d/%d/%d %15.2f€ %15.2f€ %15.2f€",
                    this.id,this.fecha.getDia(),this.fecha.getMes(),
                    this.fecha.getAño(),this.getIngresos(),this.getGastos(),
                    this.getBeneficio());
                return resultado;
            }else{
                resultado = String.format("%s %8d/%d/%d %15.2f€ %15.2f€ %15.2f€ **",
                    this.id,this.fecha.getDia(),this.fecha.getMes(),
                    this.fecha.getAño(),this.getIngresos(),this.getGastos(),
                    this.getBeneficio());
                return resultado;
            }
        }
    }
}
