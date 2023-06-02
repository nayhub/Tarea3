enum ProductosEnumeracion{

    CocaCola(1),
    Sprite(2),
    Snicker(3),
    Super8(4);

    private final int num;
        ProductosEnumeracion(int num){
            this.num = num;

        }

    public int getNum(){
        return num;
    }
}
