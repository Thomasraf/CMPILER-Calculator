lexer grammar calculatorAlgorithm;

INT: [0-9]+ ;
MUL: '*' ;
DIV: '/' ;
ADD: '+' ;
SUB: '-' ;
LPAR: '(';
RPAR: ')';
WS : [ \t\r\n]+ -> skip ;