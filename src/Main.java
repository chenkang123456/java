class test03 {
    public static void main(String[] args) {
        int i;
        double e=0, j=1;
        for(i=1; i<=10; i++){
            j *= (1.0/i);
            e += j;
        }

        System.out.println("e ="+e);
    }
}
