import com.nsi.dao.NoteSpeseDao;

import com.nsi.pojo.NoteSpese;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by v.chiuselli on 02/11/2016.
 */


public class NoteSpeseDaoTest {


    @Test
    public void modificaNoteSpese() {

        int numero = 25;
        Date data1 = Calendar.getInstance().getTime();
        Date data2 = Calendar.getInstance().getTime();
        String viaggio = "Viagg";
        String partenza = "Siviglia";
        String ritorno = "Roma";

        NoteSpeseDao noteSpeseDao = new NoteSpeseDao();

        NoteSpese noteSpese= new NoteSpese("agente","12324321","Trasferta","Roma","Bologna");

        boolean result = noteSpeseDao.updateNoteSpese(noteSpese);

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


