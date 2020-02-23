class CustomExp extends Exception {

    public CustomExp(String m) {
        super(m, null, true, false);
    }

}

class CustomException{
    public static void main(String [] x){
        try {
            throw new CustomExp("Custom Exception!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}