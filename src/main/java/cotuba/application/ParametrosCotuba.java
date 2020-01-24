package cotuba.application;

import java.nio.file.Path;

import cotuba.domain.FormatoEbook;

public interface ParametrosCotuba {

	//void executa(LeitorOpcoesCLI parametros);
	
    FormatoEbook getFormato() ;
	
	Path getDiretorioDosMD();
	
	Path getArquivoDeSaida();

}