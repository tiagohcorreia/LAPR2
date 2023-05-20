package pt.ipp.isep.dei.esoft.project.domain.shared;

/**
 * The enum Type of business.
 */
public enum TypeOfBusiness {
    /**
     * The Sell.
     */
    SELL(1){
        @Override
        public String toString() {
            return String.format("Sell").toUpperCase();
        }
    },
    /**
     * The Rent.
     */
    RENT(2){
        @Override
        public String toString() {
            return String.format("Rent").toUpperCase();
        }
    };
    private final int valor;

    TypeOfBusiness(int valor) {
        this.valor = valor;
    }

    /**
     * Gets type of business id.
     *
     * @return the type of business id
     */
    public int getTypeOfBusinessID() {
        return this.valor;
    }

    /**
     * Gets type of business by id.
     *
     * @param id the id
     * @return the type of business by id
     */
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
