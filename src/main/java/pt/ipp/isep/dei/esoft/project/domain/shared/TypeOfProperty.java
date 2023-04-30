package pt.ipp.isep.dei.esoft.project.domain.shared;

/**
 * The enum Type of property.
 */
public enum TypeOfProperty {
    /**
     * The House.
     */
    HOUSE(1){
        @Override
        public String toString() {
            return String.format("House");
        }
    },
    /**
     * The Apartment.
     */
    APARTMENT(2){
        @Override
        public String toString() {
            return String.format("Apartment");
        }
    },
    /**
     * The Land.
     */
    LAND(3){
        @Override
        public String toString() {
            return String.format("Land");
        }
    };

    private final int valor;

    TypeOfProperty(int valor) {
        this.valor = valor;
    }

    /**
     * Gets type of property id.
     *
     * @return the type of property id
     */
    public int getTypeOfPropertyID() {
        return this.valor;
    }

    /**
     * Gets type of property by id.
     *
     * @param id the id
     * @return the type of property by id
     */
    public static TypeOfProperty getTypeOfPropertyById(int id) {

        TypeOfProperty[] array = TypeOfProperty.values();

        for (int i = 0; i < array.length; i++) {

            if (id == array[i].getTypeOfPropertyID()) {

                return array[i];
            }
        }
        return null;
    }

}
