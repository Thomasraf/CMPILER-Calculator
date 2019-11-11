import org.antlr.runtime.Token;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    public static double eval(final String str) throws IOException {


        return new Object() {
            CharStream stringInput = CharStreams.fromString(str);
            calculatorAlgorithm lexer = new calculatorAlgorithm(stringInput);


            int pos = -1, ch;

            void lookForward() {
                if(++pos < str.length())
                    ch = str.charAt(pos);
                else
                    ch = -1;
            }

            boolean pointer(int charTopointer) {
                while (ch == ' ') lookForward();
                if (ch == charTopointer) {
                    lookForward();
                    return true;
                }
                return false;
            }

            double parse() {
                lookForward();
                double input= EXPR();
                if
                    (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return input;
            }

            double EXPR() {
                double input= TERM();
                while (true) {
                    if
                        (pointer('+')) input+= TERM();
                    else if
                        (pointer('-')) input-= TERM();
                    else
                        return input;
                }
            }

            double TERM() {
                double input= FACTOR();
                while (true) {
                    if
                        (pointer('*')) input *= FACTOR();
                    else if
                        (pointer('/')) input /= FACTOR();
                    else
                        return input;
                }
            }

            double FACTOR() {
                if
                    (pointer('+')) return FACTOR();
                if
                    (pointer('-')) return -FACTOR();

                double input;
                int startPos = this.pos;
                if (pointer('(')) {
                    input = EXPR();
                    pointer(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.')
                        lookForward();
                    input= Double.parseDouble(str.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if
                (pointer('^')) input = Math.pow(input, FACTOR());

                return input;
            }
        }.parse();
    }
}
