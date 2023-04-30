package pt.ipp.isep.dei.esoft.project.domain.shared;

import pt.ipp.isep.dei.esoft.project.domain.model.Role;

/**
 * The enum Sun exposure.
 */
public enum SunExposure {
    /**
     * The North.
     */
    NORTH(1){
        @Override
        public String toString() {
            return String.format("North");
        }
    },
    /**
     * The East.
     */
    EAST(2){
        @Override
        public String toString() {
            return String.format("East");
        }
    },
    /**
     * The South.
     */
    SOUTH(3){
        @Override
        public String toString() {
            return String.format("South");
        }
    },
    /**
     * The West.
     */
    WEST(4){
        @Override
        public String toString() {
            return String.format("West");
        }
    };

    private final int valor;

    SunExposure(int valor) {
        this.valor = valor;
    }

    /**
     * Gets sun exposure id.
     *
     * @return the sun exposure id
     */
    public int getSunExposureID() {
        return this.valor;
    }

    /**
     * Gets sun exposure by id.
     *
     * @param id the id
     * @return the sun exposure by id
     */
    public static SunExposure getSunExposureById(int id) {

        SunExposure[] array = SunExposure.values();

        for (int i = 0; i < array.length; i++) {

            if (id == array[i].getSunExposureID()) {

                return array[i];
            }
        }
        return null;
    }


}

