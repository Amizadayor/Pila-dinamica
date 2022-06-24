import java.util.Scanner; // Importamos las librerias para la entrada de datos
import javax.swing.JOptionPane; // Importamos las librerias para los mensajes de JOptionPane

class PilasD{ // Creeamos la clase de la pila
    Nodo Primero, Final;
    int pos;
    
    Scanner t = new Scanner (System.in); // declaramos la t como capturador de datos
    public PilasD (){
        Primero = null;
        Final = null;
        pos=0;
    }
    private Boolean esVacia(){
        return this.Primero==null;
    }
    private void mensaje (String cad){
        System.out.println (cad);
    }
    private int LeerDato(){ // Creamos la entrada de los datos
        mensaje (" INGRESE EL DATO : ");
        return t.nextInt();
    }
    private  void Insertar(int dato){ // insertar al inicio
        Nodo nuevo = new Nodo (dato);
        Primero=nuevo;
        Final=nuevo;
        pos++;
    }
    private void Longitud(){ // Creamos la funcion para el tamanio de la pila //
        if (esVacia()) // Hacemos la comparacion de si es vacia
        JOptionPane.showMessageDialog(null, " PILA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // si si es vacia, mostramos el mensaje de que la pila esta vacia
        else{ // si no
        mensaje(" LA LONGITUD DE LA PILA ES DE : "+ pos); // mostramos la longitud de la pila.
        return;
        }
    }
    private void InsertaI(){ // creamos la funcion para insertar al inicio
        int v; // validacion
        do{ // inicio de la validacion
            try{
                v=0;
                    int dato;
                    dato = LeerDato();
                    if (esVacia()) // hacemos la comparacion, si es vacia insertamos el dato
                        Insertar(dato);
                    else{ // si no es vacia, insertamos el dato nuevo primero
                        Primero = new  Nodo (dato,Primero);
                        pos++;
                    }
                JOptionPane.showMessageDialog(null," DATO INSERTADO ");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null," INGRESE SOLO DATOS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE);  // mensaje de error cunado el usuario ingrese variables no aceptados
                v=1;
                t.nextLine();
                pos--;
            }
        }while (v !=0 ); // final de la validacion
    }
    private void EliminarI(){ // creamos la funcion de para eliminar el inicio
        if (esVacia()) // hacemos la comparacion, si es vacia
            JOptionPane.showMessageDialog(null, " PILA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mostramos un mensaje de que la lista esta vacia
        else{ // si no es vacia, entonces eliminamos el primer dato de la pila
            Primero = Primero.getEnlace();
            pos++;
        }
        JOptionPane.showMessageDialog(null," DATO ELIMINADO "); // mensaje cuando el dato se haya insertado correctamente
        Listar(); // Listamos los daos nuevos
    }
    private void Listar(){ // Creamos la funcion para listar todos los datos disponibles en la pila
        if (esVacia()) // hacemos la comaracion, si es vacia
            JOptionPane.showMessageDialog(null, " PILA VACIA ", " ERROR ", JOptionPane.ERROR_MESSAGE);// mostramos un mensaje de que la pila esta vacia
        else{ // si no es vaciam, entonces listamos todos lo datos disponibles en la pila
            Nodo n;
            n=Primero;
            int c=1;
            while (n!=null){ // mostramos el valor del dato y la direccion de memoria en la que se encuentra
                mensaje ("  DATO = "+ n.getInfo() + " , DIRECCION : "+ n.getEnlace());
                n=n.getEnlace();
                c++;
            }
            mensaje (" -------------------- LISTADO TERMINADO -------------------- "); // mensaje cuando el listado hay terminado
        }
    }
    private void menu(){ // creamos el menu del programa y todas sus funciones
        int op;
        int v;
            do{
                try{
                    v=0;
                    do{
                        mensaje (" _____________________________________ "); // menu que se mostrara al inicio del programa
                        mensaje ("|          MENU DE OPCIONES           |");
                        mensaje ("|                                     |");
                        mensaje ("|    1. INSERTAR AL INICIO            |");
                        mensaje ("|    2. ELIMINAR FINAL DE LA PILA     |");
                        mensaje ("|    3. LISTAR                        |");
                        mensaje ("|    4. LONGITUD DE LA PILA           |");
                        mensaje ("|    5. SALIR                         |");
                        mensaje ("|                                     |");
                        mensaje ("|_____________________________________|");
                        mensaje ("|           ELIGE TU OPCION :         |");
                        mensaje ("|_____________________________________|");
                        op = t.nextInt();
                        switch (op){ // creamos un switch para las funciones de las opciones
                            case 1: InsertaI();
                            break;
                            case 2: EliminarI();
                            break;
                            case 3: Listar();
                            break;
                            case 4: Longitud();
                            break;
                            case 5:
                            break;
                            default:
                            JOptionPane.showMessageDialog(null," OPCION INVALIDA, INGRESE UNA OPCION EXISTENTE DEL MENU ", " ERROR ", JOptionPane.ERROR_MESSAGE); // en caso de que el usuario ingres una opcion del menu que no se encuentre , se mostrara un mensaje de error
                        }
                    }while (op!=5);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE);
                    v=1;
                    t.nextLine();
                }
            } while (v !=0); // final de la validacion
    }
    public static void main (String[] a){
        PilasD p = new PilasD();
        p.menu();
    }
}