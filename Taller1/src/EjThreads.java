import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjThreads extends Thread{

	private boolean tipo;
	private int valor;
	private String nombre;
	public EjThreads(boolean pTipo, String pNombre, int pValor){
		tipo=pTipo;
		nombre=pNombre;
		valor=pValor;
	}

	public void run(){
		String respuesta="";
		if(tipo==true){
			
			for(int i=0; i<valor;i++)
			{
				if(i%2==0)
				{
					respuesta=respuesta+i+", ";
				}
			}
		}
		else{
			for(int i=0; i<valor;i++)
			{
				if(i%2!=0)
				{
					respuesta=respuesta+i+", ";
				}
			}
		}
		System.out.println(nombre + ": "+respuesta);
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Ingrese un número entero");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String resp=reader.readLine();
		EjThreads thread1=new EjThreads(false, "Thread impares", Integer.parseInt(resp));
		EjThreads thread2=new EjThreads(true, "Thread pares",Integer.parseInt(resp));
		
		thread1.start();
		thread2.start();
	}
	
}
