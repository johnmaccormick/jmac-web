// 
class callStackDemo {
	public static int num = 5;
	public static int val = 432;
	public static int total = 0;
    
    public static int apple() {
    	val = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<50; j++){
            	val += 487;
                banana();
            }
        }
        return banana();
    }


    public static int banana() {
        for(int k=0; k<25; k++){
            for(int m=0; m<10; m++){
                num += 2;
                if (total > 10000000 && num > 10000 && k>4 && m>6 && val > 30000) {
                    int x = 34;
                    x = x + 1;
                }
            }
        }
        return num;
    }


    public static void main(String[] args) {
        for(int v=0; v<5; v++){
        	total += apple();
        }
        System.out.println("total is " + total);
    }

}
