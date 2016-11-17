import com.nsi.dao.UtenteDao;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by acerioni on 07/09/2016.
 */
public class UtenteDaoTest {

    @Test
    public void creaUtenteTest(){

        String cognome = "Cerioni";
        String nome = "Alessandra";
        String matricola = "";
        String ufficio = "pt";

        UtenteDao utenteDao = new UtenteDao();

        String result = utenteDao.creaNuovoUtente(cognome,nome,matricola,ufficio);
        assertEquals(result,"OK");
    }
}
