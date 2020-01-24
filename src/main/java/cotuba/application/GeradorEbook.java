package cotuba.application;

import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;

public interface GeradorEbook {
	
	public void gera(Ebook ebook);
	
	public static GeradorEbook cria(FormatoEbook formato) {
		
	    GeradorEbook gerador = formato.getGerador();
		/*if ("pdf".equals(formato)) {
            //GeradorPDF geradorPDF = GeradorPDF.cria();
            //geradorPDF.gera(ebook);
			gerador = new GeradorPDF();	
		} else if ("epub".equals(formato)) {
			//GeradorEPUB geradorEPUB = GeradorEPUB.cria();
			//geradorEPUB.gera(ebook);
            gerador = new GeradorEPUB();
		} else {
			throw new RuntimeException("Formato do ebook inválido: " + formato);
		}
		*/
		//gerador.gera(ebook);		
		return gerador;
		
	}

}
