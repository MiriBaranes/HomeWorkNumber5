import java.util.Scanner;
public class ParserBasePassword extends ParserBase {

        public ParserBasePassword(String request, Object helperData) {
            super(request, helperData);
        }
        public ParserBasePassword(String request) {
            this(request, null);
        }
        @Override
        protected boolean checkInput(String password, Object helperData) {
            boolean strong=false;
            if (password.length()>=6) {
                strong = true;
            }

            return strong;
        }
    }

