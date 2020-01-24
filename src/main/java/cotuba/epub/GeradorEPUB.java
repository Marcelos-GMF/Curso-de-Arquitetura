package cotuba.epub;

import java.nio.file.Files;
import java.nio.file.Path;

import cotuba.application.GeradorEbook;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;

public class GeradorEPUB implements GeradorEbook {

	@Override
	public void gera(Ebook ebook) {

		Path arquivoDeSaida = ebook.getArquivoDeSaida();
		Book epub = new Book();

		for (Capitulo capitulo : ebook.getCapitulos()) {

			String html = capitulo.getConteudoHTML();

			String tituloDoCapitulo = capitulo.getTitulo();

			epub.addSection(tituloDoCapitulo, new Resource(html.getBytes(), MediatypeService.XHTML));

		}

		EpubWriter epubWriter = new EpubWriter();

		try {
			// HtmlRenderer renderer = HtmlRenderer.builder().build();
			// String html = renderer.render(document);

			epubWriter.write(epub, Files.newOutputStream(arquivoDeSaida));

		} catch (Exception ex) {
			throw new RuntimeException("Erro ao renderizar para HTML o arquivo " + arquivoDeSaida.toAbsolutePath(), ex);
		}

	}

}
