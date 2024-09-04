public class Purse {
    int MAX_BALANCE;
    int balance;
    //@ invariant 0 <= balance && balance <= MAX_BALANCE;
    byte[] pin;
    /*@ invariant pin != null && pin.length == 4
      @ && (\forall int i; 0 <= i && i < 4;
      @ 0 <= pin[i] && pin[i] <= 9);
      @*/
    /*@ requires amount >= 0;
      @ assignable balance;
      @ ensures balance == \old(balance) - amount
      @ && \result == balance;
      @ signals (Exception) balance == \old(balance);
      @*/
    int debit(int amount) throws Exception {
        if (amount <= balance) { balance -= amount; return balance; }
        else { throw new Exception("overdrawn by " + amount); }
    }
    /*@ requires p != null && p.length >= 4;
      @ assignable \nothing;
      @ ensures \result <==> (\forall int i; 0 <= i && i < 4;
      @ pin[i] == p[i]);
      @*/
    boolean checkPin(byte[] p) {
        boolean res = true;
        for (int i=0; i < 4; i++) { res = res && pin[i] == p[i]; }
        return res;
    }
    /*@ requires 0 < mb && 0 <= b && b <= mb
      @ && p != null && p.length == 4
      @ && (\forall int i; 0 <= i && i < 4;
      @ 0 <= p[i] && p[i] <= 9);
      @ assignable MAX_BALANCE, balance, pin;
      @ ensures MAX_BALANCE == mb && balance == b
      @ && (\forall int i; 0 <= i && i < 4; p[i] == pin[i]);
      @*/
    Purse(int mb, int b, byte[] p) {
        MAX_BALANCE = mb; balance = b; pin = (byte[]) p.clone();
    }

    private static void test1()  throws Exception {
        Purse purse = new Purse(10000, 2000, new byte[] {2,3,2,3});
        purse.debit(1000);
    }

    private static void test2()  throws Exception {
        Purse purse = new Purse(10000, 2000, new byte[] {2,3,2,3});
        purse.debit(-500);
    }

    private static void test3()  throws Exception {
        Purse purse = new Purse(10000, 2000, new byte[] {2,3,2,3});
        purse.checkPin(new byte[] {2,3,2,3,2});
    }

    private static void test4()  throws Exception {
        Purse purse = new Purse(10000, 2000, new byte[] {2,3,2,3});
        purse.checkPin(new byte[] {1,1,1,1});
    }


    public static void main(String[] arguments) throws Exception {
        int test_num = Integer.parseInt(arguments[0]);
        switch(test_num) {
        case 1:
            test1();
            break;
        case 2:
            test2();
            break;
        case 3:
            test3();
            break;
        case 4:
            test4();
            break;
        }
    }
}