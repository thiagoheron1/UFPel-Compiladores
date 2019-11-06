import java.io.FileWriter;  


class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]); // Só é feito a leitura do arquivo, criando obj AnaliseLexica que tem no arquivo no atributo "BufferedReader arquivo"
			Parser as = new Parser(al);                    // Só é feito o recebimento do do obj da AnaliseLexica no objeto Parser no atributo "AnaliseLexica scanner", que contém o arquivo
			arv = as.parseProg();						   // Cria uma Exp(). e verifica se o primeiro caractere(token) do arquivo é valido. Retornando o "ArvoreSintatica Exp();"
		
			
			CodeGen backend = new CodeGen();			  // Instancia a Classe CodeGen que possui métodos de gear
			String codigo = backend.geraCodigo(arv);
			System.out.println(codigo);


			
			FileWriter fw = new FileWriter("../testsFiles/stack.txt");    
			fw.write(codigo);  
			fw.close();   

		}catch(Exception e){			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
