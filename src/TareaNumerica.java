
public class TareaNumerica extends Tarea{
	//---Atributos------------------------------------------------------------------------------------------------------
	private int numero;
	//------------------------------------------------------------------------------------------------------------------


	//---Constructores--------------------------------------------------------------------------------------------------
	public TareaNumerica() {
	}

	public TareaNumerica(String taskName) {
		super(taskName);
	}
	//------------------------------------------------------------------------------------------------------------------


	//---Getters y Setters----------------------------------------------------------------------------------------------
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	//------------------------------------------------------------------------------------------------------------------


	//---toString-------------------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		if(this.isTaskDone()){
			sb.append(" | Dato: " + numero);
		}
		return sb.toString();
	}
	//------------------------------------------------------------------------------------------------------------------
}
