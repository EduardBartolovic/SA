public class CustomException {
    public static void main(String...args) throws AnyExceptionany {
        if(!args[0].equals("0"))
            new CustomException().throwExec();
    }
    private void throwExec() throws AnyExceptionany {
        throw new AnyExceptionany();
    }
    private class AnyExceptionany extends Exception {
        @Override
        public String getMessage() {
            return "Haha";
        }
    }
}
