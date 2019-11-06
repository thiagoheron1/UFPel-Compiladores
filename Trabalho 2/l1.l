DIGITO	[0-9]
LETRA	  [a-zA-Z]
ID	    {LETRA}({LETRA}|{DIGITO}|_)*	
PALAVRA (case)|(switch)|(try)|(catch)|(null)|(instanceof)|(super)|(Exception)|(throws)|(do)|(char)|(enum)|(import)|(class)|(if)|(new)|(int)|(this)|(true)|(false)|(while)|(boolean)|(static)|(void)|(main)|(string)|(String)|(public)|(lenght)|(else)|(return)|(extends)|(<EOF>)|(System)|(out)|(println)
ACHAVES [{]
FCHAVES [}]
APAREN  [(]
FPAREN  [)]
ACOLCH  [[]
FCOLCH  []]
PONTO   [.]
PV      [;]
TWOP    [:]
COMPARADORES [<>&|]
EQUAL   "="
WHITESPACE (\t)|(\n)|(\r)|(" ")|'\'
SUM     "+"
SUB     "-"
MULT    "*"
DIV     "/"
COMMA   "," 
NOT     "!"
ASPAS ['"]
%%
{TWOP}                  {printf("Dois Pontos        %s\n",yytext);}
{EQUAL}                 {printf("Atribuicao         %s\n",yytext);}
{EQUAL}{EQUAL}          {printf("Comparador Equal   %s\n",yytext);}
{PALAVRA}               {printf("Palavra Reservada: %s\n",yytext);}
{DIGITO}+		            {printf("Numero Inteiro:    %s\n",yytext);}
{DIGITO}+"."{DIGITO}+	  {printf("Numero Real:       %s\n",yytext);} 
{ID}			              {printf("Identificador:     %s\n",yytext);}
{ACHAVES}		            {printf("Abre Chaves:       %s\n",yytext);}
{FCHAVES}		            {printf("Fecha Chaves:      %s\n",yytext);}
{APAREN}		            {printf("Abre Parenteses:   %s\n",yytext);}
{FPAREN}		            {printf("Fecha Parenteses:  %s\n",yytext);}
{ACOLCH}		            {printf("Abre Colchetes:    %s\n",yytext);}
{FCOLCH}		            {printf("Fecha Colchetes:   %s\n",yytext);}
{PV}			              {printf("Ponto Virgula:     %s\n",yytext);}		
{COMPARADORES}+		      {printf("Comparador:        %s\n",yytext);}
{PONTO}		              {printf("Ponto:             %s\n",yytext);}	
{SUM}		                {printf("Sum:               %s\n",yytext);}		
{SUB}		                {printf("Sub:               %s\n",yytext);}		
{MULT}		              {printf("Mult:              %s\n",yytext);}		
{DIV}		                {printf("Div:               %s\n",yytext);}	
{NOT}		                {printf("Not:               %s\n",yytext);}	
{COMMA}		              {printf("Virgula:           %s\n",yytext);}		
{ASPAS}		              {printf("Aspas:             %s\n",yytext);}		
{WHITESPACE}+           {break;}		

%%
int yywrap();

void main(){
  yylex();

  return ;
}

int yywrap(){
 return 1;
}
