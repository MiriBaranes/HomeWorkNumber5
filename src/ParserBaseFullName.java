public class ParserBaseFullName extends ParserBase{
    public ParserBaseFullName(String request, Object helperData) {
        super(request, helperData);
    }
    public ParserBaseFullName(String request){
        this(request,null);
    }
    protected boolean checkInput(String input, Object helperData){
        boolean formatUserName = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isAlphabetic(input.charAt(i))) {
                formatUserName = false;
                break;
            }

        }
        return formatUserName;
    }
}
