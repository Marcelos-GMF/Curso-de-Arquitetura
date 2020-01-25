package cotuba.tema;



import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cotuba.domain.Capitulo;
import cotuba.plugin.Plugin;

public class AplicadorTema {
	
	public void aplica(Capitulo capitulo) {
		
		String html = capitulo.getConteudoHTML();
		Document document = Jsoup.parse(html);
		
		//String css = "h1 { border-botton: 1px dashed blue; }";
		List<String> listaDeTemas = Plugin.listaDeTemas();
		for(String css : listaDeTemas) {
			document.select("head").append("<style> "+ css +" </style> ");	
		}
		
		capitulo.setConteudoHTML(document.html());
		
	}

}
