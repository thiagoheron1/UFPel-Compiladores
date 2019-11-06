import java.io.*;

enum TokenType{ NUM, SOMA, SUB, DIV, MULT, APar, FPar, EOF}

class Token{
	char lexema;
	TokenType token;

	Token (char l, TokenType t){ 
		lexema=l;token = t;
	}	
}

class AnaliseLexica {
	BufferedReader arquivo;
	String arg;
	int mark = 0;

	AnaliseLexica(String a) throws Exception{
		this.arg = a;
		this.arquivo = new BufferedReader(new FileReader(a));
	}

	Token getNextToken() throws Exception{	
			Token token;
			int eof = -1;
			char currchar;
			int currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;

				this.mark += 1;
			    this.arquivo.mark(this.mark);
				//System.out.println(currchar+" ----- Mark:"+this.mark);

			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
					
	
				if (currchar >= '0' && currchar <= '9')
					return (new Token (currchar, TokenType.NUM));
				else
					switch (currchar){
						case '(':
							return (new Token (currchar,TokenType.APar));
						case ')':
							return (new Token (currchar,TokenType.FPar));
						case '+':
							return (new Token (currchar,TokenType.SOMA));
						case '-':
							return (new Token (currchar,TokenType.SUB));
						case '*':
							return (new Token (currchar,TokenType.MULT));
						case '/':
							return (new Token (currchar,TokenType.DIV));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();
			
		return (new Token(currchar,TokenType.EOF));
		
	}

	BufferedReader createBufferedReader() throws Exception{
		return new BufferedReader(new FileReader(this.arg));
	}
	
}
