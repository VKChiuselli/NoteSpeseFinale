
import com.nsi.dao.NoteSpeseDao;
import com.nsi.dao.TipoSpesaDao;

import com.nsi.pojo.NoteSpese;
import com.nsi.pojo.TipiSpese;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import javafx.collections.ObservableList;

/**
 * Created by v.chiuselli on 02/11/2016.
 */
public class NoteSpeseDaoTest {

    @Test
    public void modificaNoteSpese() {

        NoteSpeseDao dao = new NoteSpeseDao();
        TipoSpesaDao dao2 = new TipoSpesaDao();

        dao2.inserisciTipoSpesa("uffa", "1.000", "22%");
        dao2.inserisciTipoSpesa("altro", "87", "12%");
        dao2.inserisciTipoSpesa("dai", "a000", "sdsa%");
        ObservableList<TipiSpese> listaTS = dao2.caricaSpese();
        boolean result = dao.inserisciNoteSpese("agente1", "matricola1", "ufficio1", "partenza1", "ritorno1", "viaggio1", listaTS);
    
        /**
         * controllo se è VERA la modifica.
         */
        assertEquals(true, result);
        /**
         * controllo se è VERA la data immessa.
         */

        // assertEquals(data1, noteSpese.getData_dal());
        //    assertTrue(result);
    }

}
