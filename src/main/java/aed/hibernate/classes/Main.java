package aed.hibernate.classes;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Main {

	static Scanner in = new Scanner(System.in);
	static Session sesion;

	public static void main(String[] args) {

		sesion = HibernateUtil.getSessionFactory().openSession();

		int valor = 99;

		while (valor != 0) {
			System.out.println("Selecione la Opcion que quiera realizar:");
			System.out.println("(1) Insertar datos");
			System.out.println("(2) Eliminar Habitacion");
			System.out.println("(3) Actualizar Habitacion");
			System.out.println(
					"(4) Visualizar todas las habitaciones con todos sus datos incluyendo la observación de la que tenga.");
			System.out.println(
					"(5) Visualizar todas las habitaciones y sus estancias, incluyendo los datos de los clientes y el hotel en los que están esas habitaciones.");
			System.out.println("(0) Salir");

			valor = in.nextInt();

			switch (valor) {
			case 1:
				InsertarDatos(sesion);
				break;
			case 2:
				EliminarHabitacion(sesion);
				break;
			case 3:
				ActualizarHabitacion(sesion);
				break;
			case 4:
				VizualizarUno(sesion);
				break;
			case 5:
				VizualizarDos(sesion);
				break;
			case 0:
				System.out.println("Saliendo de hibernate...");
				break;
			default:
				System.out.println("Elija una opción valida");
				break;

			}

		}
		sesion.close();

	}

	private static void InsertarDatos(Session sesion) {

		int valor = 99;
		int hO = 10;

		
		while (valor != 0) {
			
			System.out.println("Elija el valor que quiera insertar: ");
			System.out.println("(1) Hoteles");
			System.out.println("(2) Habitaciones");
			System.out.println("(3) Regimenes");
			System.out.println("(4) Clientes");
			System.out.println("(5) Estancias");
			System.out.println("(0) Salir");

			valor = in.nextInt();

			try {

				switch (valor) {
				case 1:
					sesion.beginTransaction();
					
					Hoteles hotel1 = new Hoteles();
					System.out.print("CodHotel ->");
					hotel1.setCodHotel(in.next());
					System.out.print("NomHotel ->");
					hotel1.setNomHotel(in.next());

					sesion.persist(hotel1);
					sesion.getTransaction().commit();
					break;
				case 2:
					sesion.beginTransaction();
					
					Habitaciones habitacion1 = new Habitaciones();
					System.out.println("Codhabitacion es AUTONUMERICO");
					System.out.print("NumHabitacion -> ");
					habitacion1.setNumHabitacion(in.next());
					System.out.print("Capacidad -> ");
					habitacion1.setCapacidad(in.nextInt());
					System.out.print("PrecioDia -> ");
					habitacion1.setPreciodia(in.nextInt());
					System.out.print("Activa (Si = 1 / No = 0) -> ");
					habitacion1.setActiva(in.nextInt());
					System.out.print("CodHotel -> ");
					habitacion1.setHotelObj(sesion.get(Hoteles.class, in.next()));

					sesion.persist(habitacion1);
					System.out.print("¿Quiere añadir observaciones? (Si = 1 / No = 0) -> ");
					hO = in.nextInt();
					if (hO == 1) {
						HabitacionesObservaciones habObs = new HabitacionesObservaciones();
						System.out.println("CodHabitacion ya está asignado");
						habObs.setHabitacion(sesion.get(Habitaciones.class, habitacion1.getCodHabitacion()));
						System.out.print("Observacion -> ");
						habObs.setObservaciones(in.next());

						sesion.persist(habObs);
					}

					else {
						System.out.println("Ha decidido no añadir Obrsevaciones");
					}
					sesion.getTransaction().commit();
					break;
				case 3:
					sesion.beginTransaction();
					
					Regimenes regimen1 = new Regimenes();
					System.out.println("CodRegimen es AUTONUMERICO");
					System.out.print("Tipo -> ");
					regimen1.setTipo(in.next());
					System.out.print("PrecioDia -> ");
					regimen1.setPrecioDia(in.nextInt());
					System.out.print("CodHotel -> ");
					regimen1.setHotelObj(sesion.get(Hoteles.class, in.next()));

					sesion.persist(regimen1);
					sesion.getTransaction().commit();

					break;
				case 4:
					sesion.beginTransaction();
					
					Clientes cliente1 = new Clientes();
					System.out.print("CodCliente ->");
					cliente1.setCodDNIoNIE(in.next());
					System.out.print("Nombre ->");
					cliente1.setNombre(in.next());
					System.out.print("Nacionalidad ->");
					cliente1.setNacionalidad(in.next());

					sesion.persist(cliente1);
					sesion.getTransaction().commit();
					break;
				case 5:
					sesion.beginTransaction();
					
					Estancias estancia1 = new Estancias();
					System.out.println("CodEstancia es AUTONUMERICO");
					System.out.print("DNI ->");
					estancia1.setCodDNIoNIEObj(sesion.get(Clientes.class, in.next()));
					System.out.print("CodHabitacion ->");
					estancia1.setHabitacionObj(sesion.get(Habitaciones.class, in.nextInt()));
					System.out.print("CodRegimen ->");
					estancia1.setRegimenObj(sesion.get(Regimenes.class, in.nextInt()));

					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					System.out.print("FechaInicio ->");
					estancia1.setFechaInicio(sdf.parse(in.next()));
					System.out.print("FechaFin ->");
					estancia1.setFechaFin(sdf.parse(in.next()));

					System.out.print("Ocupantes ->");
					estancia1.setOcupantes(in.nextInt());
					System.out.print("PrecioEstancia ->");
					estancia1.setPrecioestancia(in.nextInt());
					System.out.print("Pagado (Si = 1 / No = 0) ->");
					estancia1.setPagado(in.nextInt());

					sesion.persist(estancia1);
					sesion.getTransaction().commit();
					break;
				case 0:
					break;
				}
				

			} catch (Exception e) {
				System.err.print("Ha ocurrido el siguiente error: ");
				e.printStackTrace();
				sesion.getTransaction().rollback();
			}
		}

	}

	private static void EliminarHabitacion(Session sesion) {

		try {
			sesion.beginTransaction();

			Habitaciones habitacion = new Habitaciones();
			System.out.print("¿Que habitacion quiere eliminar? ->");
			habitacion = (Habitaciones) sesion.get(Habitaciones.class, in.nextInt());

			if (habitacion.getHabitacionObs() == null) {
				sesion.delete(habitacion);
			} else {
				HabitacionesObservaciones ho = habitacion.getHabitacionObs();
				sesion.delete(ho);
			}
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.err.print("Ha ocurrido el siguiente error: ");
			e.printStackTrace();
			sesion.getTransaction().rollback();
		}

	}

	private static void ActualizarHabitacion(Session sesion) {
		try {
			sesion.beginTransaction();

			Habitaciones habitacion = new Habitaciones();
			System.out.print("Inserte el código de la habitación que quiera modificar -> ");
			habitacion = (Habitaciones) sesion.get(Habitaciones.class, in.nextInt());
			System.out.print("NumHabitacion -> ");
			habitacion.setNumHabitacion(in.next());
			System.out.print("Capacidad -> ");
			habitacion.setCapacidad(in.nextInt());
			System.out.print("PrecioDia -> ");
			habitacion.setPreciodia(in.nextInt());
			System.out.print("Activa (Si = 1 / No = 0) -> ");
			habitacion.setActiva(in.nextInt());

			sesion.update(habitacion); 

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.err.print("Ha ocurrido el siguiente error: ");
			e.printStackTrace();
			sesion.getTransaction().rollback();
		}

	}

	private static void VizualizarUno(Session sesion) {

		try {
			sesion.beginTransaction();
			System.out.println(
					"---------------------------------- Visuliza Habitaciones Observaciones ---------------------------------- ");
			Query q = sesion.createQuery("from Habitaciones");
			List<Habitaciones> listaH = q.getResultList();
			System.out.println("Hay " + listaH.size() + " habitaciones en la base de datos");

			for (Habitaciones h : listaH) {
				System.out.println("|-------------------------------------\\");
				System.out.println("Codigo habitacion: " + h.getCodHabitacion());
				System.out.println("Codigo Hotel: " + h.getHotelObj().getCodHotel());
				System.out.println("Nombre de Hotel: " + h.getHotelObj().getNomHotel());
				System.out.println("NumHabitacion: " + h.getNumHabitacion());
				System.out.println("Capacidad: " + h.getCapacidad());
				System.out.println("Preciodia: " + h.getPreciodia());

				if (h.getActiva() == 1) {
					System.out.println("Activa: SI");
				} else {
					System.out.println("Activa: NO");
				}

				if (h.getHabitacionObs() == null) {
					System.out.println("Obersevacion: Sin Observacion");

				} else {
					System.out.println("Obersevacion: " + h.getHabitacionObs().getObservaciones());
				}
				System.out.println("|-------------------------------------/");

			}
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.err.print("Ha ocurrido el siguiente error: ");
			e.printStackTrace();
		}

	}

	private static void VizualizarDos(Session sesion) {
		try {
			sesion.beginTransaction();
			System.out.println(
					"---------------------------------- Visuliza Habitaciones Estancias Clientes Hoteles ---------------------------------- ");
			Query q = sesion.createQuery("from Habitaciones");
			List<Habitaciones> listaH = q.getResultList();
			System.out.println("Hay " + listaH.size() + " habitaciones en la base de datos");
			for (Habitaciones h : listaH) {
				System.out.println("|-------------------------------------\\");
				System.out.println("Codigo habitacion: " + h.getCodHabitacion());
				System.out.println("Codigo Hotel: " + h.getHotelObj().getCodHotel());
				System.out.println("Nombre de Hotel: " + h.getHotelObj().getNomHotel());
				System.out.println("NumHabitacion: " + h.getNumHabitacion());

				if(h.getEstancias().size() != 0)
				{
					System.out.println("Esta habitacione tiene " + h.getEstancias().size() + " estancia(s)");
					for (Estancias e : h.getEstancias()) {
						System.out.println("|**********************************|");
						System.out.println("DNI: " + e.getCodDNIoNIEObj().getCodDNIoNIE());
						System.out.println("Nombre: " + e.getCodDNIoNIEObj().getNombre());

						System.out.println("Fecha Inicio: " + e.getFechaInicio());
						System.out.println("Fecha Fin: " + e.getFechaFin());
						System.out.println("Precio Pagado: " + e.getPrecioestancia());
						System.out.println("|**********************************|");
					}
				}
				
				System.out.println("|-------------------------------------/");
				
			}
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.err.print("Ha ocurrido el siguiente error: ");
			e.printStackTrace();
		}

	}

}
