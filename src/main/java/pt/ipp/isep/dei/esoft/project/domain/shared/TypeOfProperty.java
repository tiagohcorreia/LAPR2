package pt.ipp.isep.dei.esoft.project.domain.shared;

public enum TypeOfProperty {
    HOUSE(1){
        @Override
        public String toString() {
            return String.format("House");
        }
    },
    APARTMENT(2){
        @Override
        public String toString() {
            return String.format("Apartment");
        }
    },
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

    public int getTypeOfPropertyID() {
        return this.valor;
    }

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
