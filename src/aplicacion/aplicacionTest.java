package aplicacion;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class aplicacionTest {
	private Juego testjuego;

	public void setUp(){
		
		
	}

	@Test
	public void deberiacreareljuegoconXjugadoresSA() {
   String[] jugadores={"Manuel	","Daniel"};
   Color[] colores = {Color.YELLOW,Color.RED};
	testjuego = new Juego(6,8,jugadores,colores,10);
    
	assertEquals("Deberian haber 2 jugadores jugando",2,jugadores.length);
	}
	

	@Test
	public void deberiacreartablerodeNfilasyMcolumnasSA(){
		Tablero testtablero = new Tablero(10,10);
		int dimensiontab = (testtablero.getFilas()*testtablero.getColumnas());
		assertEquals("Deberia crear tablero de 10 *10",100,dimensiontab);
	}
	@Test
	public void deberiapermitiraljugadorponerVirusSA(){
		Color blue = new Color( 0,   0, 255);
		Jugador jugador1 = new Jugador("Manuel",Color.BLUE);
		Tablero tablero = new Tablero(10,10);
		jugador1.ponerVirus(tablero,5, 5);
		boolean ok = jugador1.lastAction();
		assertTrue("El virus se ha puesto",ok);
		Color red = new Color( 255,   0,   0);
		Jugador jugador2 = new Jugador("Daniel",Color.RED);
		jugador2.ponerVirus(tablero,7, 9);
		boolean ok2 = jugador2.lastAction();
		assertTrue("El virus se ha puesto",ok2);
	}
	@Test
	public void eltablerodeberiasabersilacasillaestalibreSA()
	{
		Color blue = new Color( 0,   0, 255);
		Tablero tablero = new Tablero(8,5);
	   
		boolean ok =  tablero.estaLibre(2,3);
		assertTrue("Casilla libre",ok);
		VirusEvolutivo virus = new VirusEvolutivo(1,blue);
		tablero.ponerVirus(2, 3, virus);
	    boolean op = tablero.estaLibre(2, 3);
	    assertFalse("casilla ocupada", op);
			
	}
	@Test
	public void deberiapermitircrearnuevosjugadoresSA(){
		String[] jugadores = {"Felipe","Andres","Miguel"};
		Color[] colores = {Color.RED,Color.BLUE,Color.YELLOW};
			testjuego = new Juego(8,8,jugadores,colores,10);
		boolean ok = testjuego.lastAction();
		assertTrue("Jugadores Creados:",ok);
		
	}
	@Test 
	public void deberiapermitircrearyponerVirusNeutralSA(){
		Tablero tablero = new Tablero(8,5);
		Color gray = new Color( 0,   255,0 );
		VirusNeutral neutro = new VirusNeutral(1,gray);
		tablero.ponerVirus(3, 3, neutro);
		boolean hecho = neutro.lastAction();
		assertTrue("Creado y Puesto",hecho);
	}
	@Test 
	public void deberiapermitircrearyponerVirusDestructor(){
		Tablero tablero = new Tablero(10,10);
		Color blue = new Color( 0,   0, 255);
		VirusDestructor destructor = new VirusDestructor(blue);
		tablero.ponerVirus(4, 4, destructor);
		VirusDestructor destructor2 = new VirusDestructor(blue);
		tablero.ponerVirus(2, 2, destructor2);
		boolean last = destructor2.lastAction();
		assertTrue("Creado y Puesto",last);
		
		
	}
	@Test  
	public void deberiapermitirModificarelTableroSA(){
		Tablero tablero = new Tablero(12,12);
	   tablero.setFilas(15);
	   tablero.setColumnas(15);
	   int dimensionnueva = tablero.getColumnas()* tablero.getFilas();
		assertEquals("Filas y Columnas Modificadas (15/15)",225,dimensionnueva);
	}
	@Test  
	public void deberiapermitiralaMaquinaponerVirusSA(){
		Tablero tablero = new Tablero(10,10);
		Color blue = new Color( 0,   0, 255);
		Maquina machine = new Maquina("Machine",2,blue);
		boolean ok = machine.ponerVirus(tablero);
		assertFalse("La maquina ha puesto un virus", ok);
	}
	
	
	

}