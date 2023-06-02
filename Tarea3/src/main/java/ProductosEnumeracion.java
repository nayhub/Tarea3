enum ProductosEnumeracion {
    CocaCola(1),
    Sprite(2),
    Snicker(3),
    Super8(4);

    private int num;

    ProductosEnumeracion(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public String getNombre() {
        return this.name();
    }
}

