enum PreciosEnumeracion {
    CocaCola1(300),
    Sprite2(300),
    Snicker3(300),
    Super84(300);


    private int Enum;

    PreciosEnumeracion(int Enum) {
        this.Enum = Enum;
    }

    public int getNum() {
        return Enum;
    }

    public String getPrecios() {
        return this.name();
    }
}
