public class Test {
    public static void main(String[] args) {
        CodeLine cl = new CodeLine("\n\n Hello world How\n\n        are you \n    doing?");
        sopl(cl);
        pwithdots(cl.getNext());
        pwithdots(cl.getNext().getNext());
        pwithdots(cl.getLast());
    }
    public static void sopl(Object... args) {
        if (args.length == 0) System.out.println();
        for (Object o : args) System.out.println(o);
    }
    public static void pwithdots(Object o) {
        String s = o.toString();
        char[] chArr = s.toCharArray();
        String result = "";
        for (char ch : chArr) result += ch + "·";
        sopl(result);
    }
}
