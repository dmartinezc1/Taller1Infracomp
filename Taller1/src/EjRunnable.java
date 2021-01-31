import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjRunnable implements  Runnable {
	
	private boolean tipo;
	private int valor;
	private String nombre;

	public EjRunnable(boolean pTipo, String pNombre, int pValor){
		nombre=pNombre;
		tipo=pTipo;
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
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String resp=reader.readLine();
		Thread thread1=new Thread( new EjRunnable(false, "Thread impares",Integer.parseInt(resp)));
		Thread thread2=new Thread( new EjRunnable(true, "Thread pares",Integer.parseInt(resp)));
		
		thread1.start();
		thread2.start();
	}

}
