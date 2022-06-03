import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrador extends Usuario implements CrearPlan, Menu{
	

	
	public Administrador(String userName ,String email, String password, String userDni, String userCel) {
		super(userName,email,password,userDni,userCel);
		
	}

	
	public Paciente ingresoPacientes()
	{
		Paciente p = new Paciente();
		Usuario.crearUser(p);
		return p;
	}
	
	public Profesional ingresoProfesionales()
	{
		Profesional p = new Profesional();
		Usuario.crearUser(p);
		return p;
	}
	
	public void administracionEnfermedades()
	{
		
	}
	
	public void administracionTareasDeControl()
	{
		int choice = 0;
		Scanner scan =  new Scanner(System.in);
		Tarea tarea = null;

		do{
			try{
				System.out.println("1. Agregar tarea.\n"
								 + "2. Modificar tarea.\n"
								 + "3. Eliminar tarea.\n"
								 + "4. Ver lista de tareas.\n"
								 + "0. Salir.\n");
				choice = scan.nextInt();
				switch (choice){
					case 1:	tarea = nuevaTarea();
							break;
					case 2:	tarea = modificarTarea();
							break;
					case 3:	eliminarTarea();
							break;
					case 4: 
							break;
				}
			}
			catch(InputMismatchException e){
				System.out.println("Ingrese una opcion valida.\n");
			}
		} while (choice!=0);
		scan.close();
	}
	
	public void eliminarTarea()
	{
		//buscar archivo
		//borrar del archivo
		Sistema.users.remove(0);//El 0 deberia ser cambiado por la forma de busqueda del usuario . 
		//Pasar por parametro el usuario? o solo dni?
	}
	
	public Tarea modificarTarea()
	{
		Tarea tareaAModificar = null; //cambiar null y agregar la apertura del archivo
		System.out.println("Nombre : "+tareaAModificar.getTaskName());
		if(tareaAModificar instanceof TareaAlfanumerica)
		{
			System.out.println(((TareaAlfanumerica) tareaAModificar).getInfo());
		}
		if(tareaAModificar instanceof TareaSiNo)
		{
			System.out.println(((TareaSiNo) tareaAModificar).getDecision());
		}
		if(tareaAModificar instanceof TareaNumerica)
		{
			System.out.println(((TareaNumerica) tareaAModificar).getNumero());
		}
		return tareaAModificar;
	}
	
	public Tarea nuevaTarea()
	{
		int choice = 0;
		String taskName = "";
		Tarea nuevaTarea = null;
		Scanner scan = new Scanner(System.in);
		do{
			try{
				System.out.println("1. Tarea de Si/No\n"
								 + "2. Tarea con respuesta Alfanumerica.\n"
								 + "3. Tarea con respuesta Numerica\n"
								 + "4. Tarea simple de solo Check");
				choice = scan.nextInt();
				switch (choice){
					case 1:
						nuevaTarea = new TareaSiNo(taskName);
						break;
					case 2:	
						nuevaTarea = new TareaAlfanumerica(taskName);
						break;
					case 3:
						nuevaTarea = new TareaNumerica(taskName);
						break;
					case 4:
						nuevaTarea = new Tarea(taskName);
						break;
				}
			}
			catch(InputMismatchException e){
				System.out.println("Ingrese una opcion valida.\n");
			}
		} while (nuevaTarea == null);
		scan.close();
		//agregar tarea al archivo
		return nuevaTarea;
	}


	@Override
	public void crearNuevoPlan() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void menu() {
		int choice = 0;
		Scanner scan =  new Scanner(System.in);

		do{
			try{
				System.out.println("1. Ingreso de Pacientes.\n"
								 + "2. Ingreso de Profesionales.\n"
								 + "3. Administracion de Enfermedades.\n"
								 + "4. Administracion de Tareas de Control.\n"
								 + "0. Salir.\n");
				choice = scan.nextInt();
				switch (choice){
					case 1:	ingresoPacientes();
							break;
					case 2:	ingresoProfesionales();
							break;
					case 3:	administracionEnfermedades();
							break;
					case 4: administracionTareasDeControl();
							break;
				}
			}
			catch(InputMismatchException e){
				System.out.println("Ingrese una opcion valida.\n");
			}
		} while (choice!=0);
		scan.close();
	}
}
