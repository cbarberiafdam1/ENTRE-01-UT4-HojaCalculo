
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - Carla Barberia Flamarique
 *  
 */
public class TestHojaCalculo
{
    /**
     * Constructor  
     */
    public TestHojaCalculo(){
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
        Fecha fecha1 = new Fecha(4,10,2020);
        Fila fila1 = new Fila("Fila1", fecha1, 25.50, 132.00);
        
        Fecha fecha2 = new Fecha(5,10,2020);
        Fila fila2 = new Fila("Fila2", fecha2, 300.00, 350.00);
        
        Fecha fecha3 = new Fecha(1,1,2020);
        Fila fila3 = new Fila("Fila3", fecha3, 0.00, 0.00);
        
        HojaCalculo hoja1 = new HojaCalculo("HOJA1");
        hoja1.addFila(fila1);
        hoja1.addFila(fila2);
        hoja1.addFila(fila3);
        
        Fila fila4 = new Fila("Fila4");
        hoja1.addFila(fila4);
        
        System.out.println(hoja1.toString());
        
        HojaCalculo hoja2 = hoja1.duplicarHoja();
        System.out.println(hoja2.toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        Fecha fecha1 = new Fecha(7,10,2020);
        Fila fila1 = new Fila("Fila1", fecha1, 260.00, 125.00);
        
        Fecha fecha2 = new Fecha(8,10,2020);
        Fila fila2 = new Fila("Fila2", fecha2, 125.00, 245.00);
        
        HojaCalculo hoja2 = new HojaCalculo("HOJA2");
        hoja2.addFila(fila1);
        hoja2.addFila(fila2);
        
        System.out.println(hoja2.toString());
        
        HojaCalculo hoja3 = hoja2.duplicarHoja();
        System.out.println(hoja3.toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        Fecha fecha1 = new Fecha(8,10,2020);
        Fila fila1 = new Fila("Fila1", fecha1, 670.00, 234.00);
        
        HojaCalculo hoja3 = new HojaCalculo("HOJA3");
        hoja3.addFila(fila1);
        
        System.out.println(hoja3.toString());
        
        HojaCalculo hoja4 = hoja3.duplicarHoja();
        System.out.println(hoja4.toString());
    }
}
