import com.nsi.dao.TipoSpesaDao;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

/**
 * Created by b.pesty on 13/09/2016.
 */
public class TipoSpesaDaoTest {

    @Test
    public void inserisciTipoSpesaTest(){
        String descrizione = "Benzina";
        String importo = "3332.78";
        String iva = "22";

        TipoSpesaDao tsd = new TipoSpesaDao();

        boolean prova = tsd.inserisciTipoSpesa(descrizione,importo,iva);
        assertTrue(prova);

    }
}
