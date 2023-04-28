package app.domain.shared;

public enum TypeOfBusiness {
    BUY(1){
        @Override
        public String toString() {
            return String.format("Buy");
        }
    }, RENT(2){
        @Override
        public String toString() {
            return String.format("Rent");
        }
    };
    private final int valor;

    TypeOfBusiness(int valor) {
        this.valor = valor;
    }

    public int getTypeOfBusinessID() {
        return this.valor;
    }

    public static TypeOfBusiness getTypeOfBusinessById(int id) {

        TypeOfBusiness[] array = TypeOfBusiness.values();

        for (int i = 0; i < array.length; i++) {

            if (id == array[i].getTypeOfBusinessID()) {

                return array[i];
            }
        }
        return null;
    }
}
