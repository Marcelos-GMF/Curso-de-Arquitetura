package cotuba.tema;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cotuba.domain.Capitulo;

public class AplicadorTema {
	
	public void aplica(Capitulo capitulo) {
		
		String html = capitulo.getConteudoHTML();
		Document document = Jsoup.parse(html);
		
		String css = "h1 { border-botton: 1px dashed blue; }";
		
		document.select("head").append("<style> "+css+" </style> ");
		
	}

}
